package com.example.ssajcic.expandable_rcycv.ViewHolders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by ssajcic on 15.11.17..
 */

class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var sub_cetegory =  itemView.findViewById(R.id.tvMovieName) as TextView
}
