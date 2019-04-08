package com.leosimas.mvvm.bean

import java.util.*

class Movie {

    protected var id: Int = 0
    protected var title: String? = null
//    @SerializedName("original_title")
    protected var originalTitle: String? = null
    protected var overview: String? = null
//    @SerializedName("release_date")
    protected var releaseDate: Date? = null
//    @SerializedName("poster_path")
    protected var posterPath: String? = null
//    @SerializedName("backdrop_path")
    protected var backdropPath: String? = null
//    @SerializedName("genre_ids")
    protected var genreIds: IntArray? = null

    protected var posterFullUrl: String? = null
    protected var backdropFullUrl: String? = null
    protected var genres: List<Genre>? = null

}