package com.leosimas.mvvm.bean

class MoviePage {

    var page: Int = 0
        private set
    //    @SerializedName("total_pages")
    var totalPages: Int = 0
        private set
    var results: List<Movie> = ArrayList()
        private set

}