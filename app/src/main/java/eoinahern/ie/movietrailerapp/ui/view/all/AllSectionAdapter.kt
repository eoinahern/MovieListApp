package eoinahern.ie.movietrailerapp.ui.view.all

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import javax.inject.Inject

class AllSectionAdapter @Inject constructor() :
    RecyclerView.Adapter<AllSectionAdapter.ViewHolder>() {

    private var movieList: List<MovieListEntry> = listOf()
    var listener: (String) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nested_recycler_image_item, parent, false)
        return ViewHolder(view, listener, movieList)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(movieList[position])
    }

    fun setList(list: List<MovieListEntry>) {
        movieList = list
        notifyDataSetChanged()
    }

    class ViewHolder(view: View, listener: (String) -> Unit, list: List<MovieListEntry>) :
        RecyclerView.ViewHolder(view) {

        private val rating: TextView by lazy { view.findViewById<TextView>(R.id.rating) }
        private val movieImage: ImageView by lazy { view.findViewById<ImageView>(R.id.image) }
        private val votes: TextView by lazy { view.findViewById<TextView>(R.id.votes) }

        init {
            itemView.setOnClickListener {
                listener(list[adapterPosition].id)
            }
        }

        fun bindItem(movie: MovieListEntry) {
            rating.text = movie.highlightedScore.score.toString()
            votes.text = movie.highlightedScore.formattedAmountVotes
            Glide.with(itemView.context).load(movie.images.artwork)
                .override(movieImage.width, movieImage.height)
                .into(movieImage)
        }
    }
}