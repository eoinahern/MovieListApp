package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.Actor
import eoinahern.ie.movietrailerapp.util.view.setGlideImage
import javax.inject.Inject


class ActorsAdapter @Inject constructor() : RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {

    private var actors: List<Actor> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.actors_item_layout,
            parent, false
        )

        return ViewHolder(view)
    }

    override fun getItemCount() = actors.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(actors[position])
    }

    fun setList(listIn: List<Actor>) {
        actors = listIn
        notifyDataSetChanged()
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val actorImage by lazy { v.findViewById<ImageView>(R.id.actorImage) }
        private val actorName by lazy { v.findViewById<TextView>(R.id.actorName) }

        fun bindData(actor: Actor) {
            actorName.text = actor.name
            actor.photo?.let {
                actorImage.setGlideImage(actor.photo)
            }
        }
    }

}