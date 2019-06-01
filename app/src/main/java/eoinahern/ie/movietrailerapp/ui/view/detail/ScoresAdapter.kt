package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.data.model.Score
import javax.inject.Inject


class ScoresAdapter @Inject constructor() : RecyclerView.Adapter<ScoresAdapter.ViewHolder>() {


    private var scores: List<Score> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}