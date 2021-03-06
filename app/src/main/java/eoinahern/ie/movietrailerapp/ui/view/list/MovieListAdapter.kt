package eoinahern.ie.movietrailerapp.ui.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.util.view.setGlideImage


class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var list: MutableList<MovieListEntry> = mutableListOf()
    lateinit var listener: (String) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.small_nested_recycler_movie_layout,
            parent, false
        )

        return ViewHolder(view, list, listener)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    fun setList(listIn: MutableList<MovieListEntry>) {
        list.clear()
        list.addAll(listIn)
        notifyDataSetChanged()
    }

    class ViewHolder(
        val view: View, val list: List<MovieListEntry>, val listener: (String) -> Unit
    ) :
        RecyclerView.ViewHolder(view) {

        private val rating: TextView by lazy { view.findViewById<TextView>(R.id.rating) }
        private val movieImage: ImageView by lazy { view.findViewById<ImageView>(R.id.image) }
        private val votes: TextView by lazy { view.findViewById<TextView>(R.id.votes) }

        init {
            view.setOnClickListener {
                listener(list[adapterPosition].id)
            }
        }

        fun bindItem(movieItem: MovieListEntry) {
            rating.text = movieItem.highlightedScore.score.toString()
            votes.text = movieItem.highlightedScore.formattedAmountVotes ?:
                    view.context.resources.getString(R.string.unknown)
            movieImage.setGlideImage(movieItem.images.artwork)
        }
    }
}