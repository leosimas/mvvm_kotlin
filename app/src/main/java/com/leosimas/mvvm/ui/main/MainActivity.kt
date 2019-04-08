package com.leosimas.mvvm.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.leosimas.mvvm.R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.afterViews()

    }

    private fun afterViews() {
//        initLayout()
        initViewModel()
    }

    private fun initViewModel() {
        Log.d(TAG, "initViewModel")
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.getMovies().observe(this, Observer {
            Log.d(TAG, "observe movies: $it")
//            recyclerView.showList(it)
        })

        mainViewModel.getViewState().observe(this, Observer {
            Log.d(TAG, "observe viewState: $it")
            if (it.isError) {
//                recyclerView.showError()
            } else if ( it.isLoading ) {
//                recyclerView.showLoading()
            }
        })

        mainViewModel.getSearchState().observe(this, Observer { isSearchState ->
            Log.d(TAG, "observe search: $isSearchState")
//            changeSearchMode(isSearchState)
        })

        mainViewModel.getToastMessage().observe(this, Observer {
            Log.d(TAG, "observe toast: $it")
//            AppUtils.showToastShort(MainActivity.this, it);
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(com.leosimas.mvvm.R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            com.leosimas.mvvm.R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
