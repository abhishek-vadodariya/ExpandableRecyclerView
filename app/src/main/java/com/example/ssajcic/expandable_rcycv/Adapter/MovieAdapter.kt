package com.example.ssajcic.expandable_rcycv.Adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.ssajcic.expandable_rcycv.Data.Movie
import com.example.ssajcic.expandable_rcycv.Data.MovieCategory
import com.example.ssajcic.expandable_rcycv.ViewHolders.ChildViewHolder
import com.example.ssajcic.expandable_rcycv.ViewHolders.ParentViewHolder
import java.util.*

/**
 * Created by ssajcic on 15.11.17..
 */

class MovieAdapter(data: ArrayList<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>()
{
    internal var dataOfTheList: ArrayList<Any>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    {
        if (viewType == 1) {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.parent_movie_category, parent, false)
            return ParentViewHolder(v)
        } else {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.child_movies, parent, false)
            return ChildViewHolder(v)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val parent = holder.itemView

        if (holder is ParentViewHolder) {
            (parent.findViewById(R.id.tvMovieCategory) as TextView).text = (dataOfTheList!![position] as MovieCategory).categoryName!!.toString()

            parent.setOnClickListener {
                val movies = (dataOfTheList!![position] as MovieCategory).movies
                if (parent.isActivated) {
                    (parent.findViewById(R.id.ivMovieCategoryExpand) as ImageView).setImageResource(R.drawable.left_arrow)
                    removeFrom(position, movies!!.size)
                } else {
                    (parent.findViewById(R.id.ivMovieCategoryExpand) as ImageView).setImageResource(R.drawable.down_arrow)
                    addInFrontOf(position, movies!!)
                }
                parent.isActivated = !parent.isActivated
                notifyDataSetChanged()
            }
        } else {
            (parent.findViewById(R.id.tvMovieName) as TextView).text = (dataOfTheList!![position] as Movie).movieName
        }
    }

    override fun getItemCount(): Int {
        return if (dataOfTheList != null)
            dataOfTheList!!.size
        else
            0
    }

    override fun getItemViewType(position: Int): Int {
        return if (dataOfTheList!![position] is MovieCategory)
            1
        else
            0
    }

    fun addInFrontOf(position:Int, movies:List<Movie>) {
        var i =0;
        while(i < movies.size)
            dataOfTheList?.add(position + i + 1, movies.get(i))
    }
    fun removeFrom(position:Int, numOfMovies:Int) {
        var i =0
        while (i < numOfMovies)
            dataOfTheList?.remove(position + 1)
    }
}

