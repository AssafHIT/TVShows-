package com.example.moviesapp
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.databinding.FavoritesLayoutBinding
import com.example.moviesapp.databinding.ShowsBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.*

class Shows : Fragment() {
    private var _binding : ShowsBinding? = null
    private val binding get() = _binding!!
    private lateinit var dbref : DatabaseReference
    private lateinit var showRecyclerview : RecyclerView
    private lateinit var showArrayList : ArrayList<showCard>

//    val recyclerView = binding.recShows
//    val adapter = MyAdapter(showArrayList)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ShowsBinding.inflate(layoutInflater, container, false)

        showRecyclerview = binding.recShows
        //showRecyclerview = findViewById<RecyclerView>(R.id.rec_shows)
        showRecyclerview.layoutManager = LinearLayoutManager(context)
        showRecyclerview.setHasFixedSize(true)

        showArrayList = arrayListOf<showCard>()
        getShowsData()
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refreshApp()
    }
//    @SuppressLint("MissingInflatedId")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.shows)
//
//        showRecyclerview = findViewById<RecyclerView>(R.id.rec_shows)
//        showRecyclerview.layoutManager = LinearLayoutManager(this)
//        showRecyclerview.setHasFixedSize(true)
//
//        showArrayList = arrayListOf<showCard>()
//        getShowsData()
//
//    }

    private fun getShowsData() {

        dbref = FirebaseDatabase.getInstance().reference.child("shows")
        dbref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (showSnapshot in snapshot.children) {
                        val show = showSnapshot.getValue(showCard::class.java)
                        showArrayList.add(show!!)
                    }
                    showRecyclerview.adapter = MyAdapter(showArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }


        }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun refreshApp()
    {
        binding.swipeToRefresh.setOnRefreshListener {
            Toast.makeText(requireActivity(), "Page refreshed", Toast.LENGTH_LONG).show()
            binding.swipeToRefresh.isRefreshing = false
        }
    }
}


