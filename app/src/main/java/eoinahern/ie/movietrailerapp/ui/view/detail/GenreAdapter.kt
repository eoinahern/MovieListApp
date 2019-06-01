package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.data.model.Genre


class GenreAdapter : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var genres: List<Genre> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate()
        return ViewHolder(view)
    }

    override fun getItemCount() = genres.size

    override fun onBindViewHolder(holder: GenreAdapter.ViewHolder, position: Int) {

    }

    fun setGnereList(listIn: List<Genre>) {
        genres = listIn
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}