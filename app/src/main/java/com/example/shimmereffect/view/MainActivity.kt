package com.example.shimmereffect.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shimmereffect.R
import com.example.shimmereffect.model.Status
import com.example.shimmereffect.view.adapter.MainAdapter
import com.example.shimmereffect.viewmodel.MainViewModel
import com.example.shimmereffect.model.Result
import com.facebook.shimmer.ShimmerFrameLayout

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    lateinit var mainRecyclerView: RecyclerView
    lateinit var mainAdapter: MainAdapter
    lateinit var shimmer: ShimmerFrameLayout
    val TAG = "MAIN_ACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shimmer = findViewById(R.id.shimmer_layout)



        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getPokemon()
        mainViewModel.pokeResult.observe(this,{

            when(it.status){
                Status.SUCCESS -> {
                    Log.d(TAG, "Completed")
                    setupRecycleView(it.data!!.results)
                    shimmer.visibility = View.GONE
                }
                Status.FAILURE -> Log.d(TAG, "failed call")
                Status.LOADING -> shimmer.visibility = View.VISIBLE

            }

        })
    }

    private fun setupRecycleView(list : List<Result>){
        mainAdapter = MainAdapter(list)
        val layoutManager = LinearLayoutManager(this)
        mainRecyclerView = findViewById(R.id.main_recyclerview)
        mainRecyclerView.adapter = mainAdapter
        mainRecyclerView.layoutManager = layoutManager

    }


}