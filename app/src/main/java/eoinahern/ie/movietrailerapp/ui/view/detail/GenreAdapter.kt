package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.Genre
import eoinahern.ie.movietrailerapp.util.view.setGlideImage
import javax.inject.Inject


class GenreAdapter @Inject constructor() : RecyclerView.Adapter<GenreAdapter.ViewHolder>() {

    private var genres: List<Genre> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.genre_view_layout,
            parent, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount() = genres.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(genres[position])
    }

    fun setGnereList(listIn: List<Genre>) {
        genres = listIn
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val icon by lazy { view.findViewById<ImageView>(R.id.icon) }
        val title by lazy { view.findViewById<TextView>(R.id.genreText) }

        fun bindData(genre: Genre) {
            icon.setGlideImage(genre.additional_images.icon)
            title.text = genre.name
        }
    }
}