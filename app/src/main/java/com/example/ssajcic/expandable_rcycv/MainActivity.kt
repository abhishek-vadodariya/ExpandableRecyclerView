package com.example.ssajcic.expandable_rcycv

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.ssajcic.expandable_rcycv.Adapter.MovieAdapter
import com.example.ssajcic.expandable_rcycv.Data.Movie
import com.example.ssajcic.expandable_rcycv.Data.MovieCategory
import java.util.*

class MainActivity : AppCompatActivity() {

    private var list: RecyclerView? = null
    private var movies: MutableList<Movie>? = null
    private var adapter: MovieAdapter? = null
    private val data = ArrayList<Any>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.rcycMovies) as RecyclerView

        val layoutManager = LinearLayoutManager(applicationContext)
        list!!.layoutManager = layoutManager

        generateDummyData()
    }

    private fun generateDummyData() {
        movies = ArrayList()
        movies!!.add(Movie("Murder on the Orient Express"))
        data.add(MovieCategory("Crime", movies))

        movies = ArrayList()
        movies!!.add(Movie("The Matrix"))
        movies!!.add(Movie("The Fifth Element"))
        movies!!.add(Movie("Aliens"))
        data.add(MovieCategory("Sci-fi", movies))

        movies = ArrayList()
        movies!!.add(Movie("The Mummy"))
        data.add(MovieCategory("Fantasy", movies))

        adapter = MovieAdapter(data)
        list!!.adapter = adapter
    }
}
