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


class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var list: MutableList<MovieListEntry> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.nested_recycler_image_item,
            parent, false
        )

        return ViewHolder(view)
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

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rating: TextView by lazy { view.findViewById<TextView>(R.id.rating) }
        private val movieImage: ImageView by lazy { view.findViewById<ImageView>(R.id.image) }
        private val votes: TextView by lazy { view.findViewById<TextView>(R.id.votes) }

        init {
            view.setOnClickListener {
                //do stuff
            }
        }

        fun bindItem(movieItem: MovieListEntry) {
            rating.text = movieItem.highlightedScore.score.toString()
            votes.text = movieItem.highlightedScore.formattedAmountVotes
            Glide.with(itemView.context).load(movieItem.images.artwork)
                .override(movieImage.width, movieImage.height)
                .into(movieImage)

        }
    }
}