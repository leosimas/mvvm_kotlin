package com.leosimas.mvvm.ui.main

import android.app.Application
import com.leosimas.mvvm.viewmodel.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.leosimas.mvvm.bean.Movie
import com.leosimas.mvvm.bean.MoviePage
import androidx.lifecycle.LiveData
import android.R

class MainViewModel(application: Application) : BaseViewModel(application) {

//    private val api: MoviesAPI? = null

    private var upcomingMoviesLastPage: MoviePage? = null
    private var currentMoviesLastPage = MoviePage()

    private val upcomingMovies = ArrayList<Movie>()
    private val searchMovies = ArrayList<Movie>()

//    private val callAdapter: CallAdapter<MoviePage>? = null

    private var lastSearchQuery = ""

    private val movies = MutableLiveData<List<Movie>>()
    private val searchState = MutableLiveData<Boolean>()

    init {
//        api = MoviesAPI_.getInstance_( getApplication().getApplicationContext() );
        searchState.value = false
    }

    fun getMovies(): LiveData<List<Movie>> {
        if (movies.value == null && !isLoading()) {
            this.requestMovies()
        }
        return movies
    }

    fun getSearchState(): LiveData<Boolean> {
        return searchState
    }

    fun requestMovies() {
        this.requestMovies(null)
    }

    fun searchMovies(query: String) {
        this.requestMovies(query)
    }

    private fun requestMovies(query: String?) {
        var query = query
        val nextPage = currentMoviesLastPage.page + 1
        if (searchState.value == true) {
            if (query == null) {
                query = lastSearchQuery
            } else if (query.isEmpty()) {
//                toastMessage.value = R.string.type_movie_name
                return
            } else if (!lastSearchQuery.equals(query)) {
                lastSearchQuery = query
                searchMovies.clear()
                currentMoviesLastPage = MoviePage()
            }

//            callAdapter = api.search(query, nextPage)
        } else {
//            callAdapter = api.upcoming(nextPage)
        }

        setLoadingState()

//        callAdapter.enqueue(object : MoviesAPI.Callback<MoviePage>() {
//            fun onSuccess(result: MoviePage) {
//                val list: MutableList<Movie>
//                if (searchState.value == true) {
//                    list = searchMovies
//                    if (list.isEmpty()) {
////                        toastMessage.value = R.string.no_movie_found
//                    }
//                } else {
//                    upcomingMoviesLastPage = result
//                    list = upcomingMovies
//                }
//
//                setNormalState()
//
//                currentMoviesLastPage = result
//                list.addAll( result.results )
//                movies.setValue(list)
//            }
//
//            fun onFailure() {
//                setErrorState()
//            }
//        })
    }

    fun setSearchMode(searchMode: Boolean) {
//        callAdapter.cancel()

        val list: List<Movie>
        if (searchMode) {
            list = searchMovies
            currentMoviesLastPage = MoviePage()
        } else {
            list = upcomingMovies
            currentMoviesLastPage = if (upcomingMoviesLastPage != null) upcomingMoviesLastPage!! else MoviePage()
        }

        searchMovies.clear()

        movies.value = list

        searchState.value = searchMode
    }

    fun hasMorePages(): Boolean {
        return currentMoviesLastPage.totalPages > currentMoviesLastPage.page
    }

}