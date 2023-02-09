package com.example.moviesapp

data class showCard(var name : String ?= null,var language : String ?= null,var genres1 : String ?= null
                    ,var genres2 : String ?= null,var genres3 : String ?= null,var runtime : Long ?= null,var rating : Double ?= null)