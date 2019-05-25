package eoinahern.ie.movietrailerapp.ui.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import javax.inject.Inject


class ListActivityAdapter @Inject constructor() :
    RecyclerView.Adapter<ListActivityAdapter.ViewHolder>() {

    private lateinit var map: Map<String, List<MovieListEntry>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.nested_movie_layout,
                parent, false
            )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = map.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}