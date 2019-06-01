package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.Actor
import javax.inject.Inject


class ActorsAdapter @Inject constructor() : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    private var actors: List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.small_nested_recycler_movie_layout,
            parent, false
        )

        return ViewHolder(view)
    }

    override fun getItemCount() = actors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    fun setList(listIn: List<Actor>) {
        actors = listIn
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    }

}