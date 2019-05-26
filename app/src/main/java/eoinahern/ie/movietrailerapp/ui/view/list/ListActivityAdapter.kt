package eoinahern.ie.movietrailerapp.ui.view.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import javax.inject.Inject


class ListActivityAdapter @Inject constructor() :
    RecyclerView.Adapter<ListActivityAdapter.ViewHolder>() {

    var viewListItemlistener: (String) -> Unit = {}
    private lateinit var map: Map<String, List<MovieListEntry>>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(
                R.layout.nested_movie_layout,
                parent, false
            )
        return ViewHolder(view, map.entries.map { it.key }, viewListItemlistener)
    }

    fun setMap(mapIn: Map<String, List<MovieListEntry>>) {
        this.map = mapIn
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = map.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val keys = map.keys.toList()
        val key = keys[position]
        val listItem = map[key]
        holder.bindData(key, listItem!!.toMutableList())
    }

    class ViewHolder(view: View, list: List<String>, listener: (String) -> Unit) :
        RecyclerView.ViewHolder(view) {

        private val recyclerView: RecyclerView by lazy { view.findViewById<RecyclerView>(R.id.innerRecycler) }
        private val llManager: LinearLayoutManager = LinearLayoutManager(
            itemView.context,
            RecyclerView.HORIZONTAL, false
        )
        private val titleTxt: TextView by lazy { view.findViewById<TextView>(R.id.top_text) }
        private val nextTxt: TextView by lazy { view.findViewById<TextView>(R.id.next_text) }
        private val adapter: MovieListAdapter = MovieListAdapter()

        init {
            nextTxt.setOnClickListener {
                listener(list[adapterPosition])
            }
        }

        fun bindData(title: String, list: MutableList<MovieListEntry>) {
            titleTxt.text = title
            setUpAdapter(list)
        }

        private fun setUpAdapter(list: MutableList<MovieListEntry>) {
            adapter.setList(list)
            recyclerView.layoutManager = llManager
            recyclerView.adapter = adapter
        }

    }

}