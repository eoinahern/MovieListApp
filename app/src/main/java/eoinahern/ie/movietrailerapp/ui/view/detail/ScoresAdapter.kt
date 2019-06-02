package eoinahern.ie.movietrailerapp.ui.view.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.Score
import eoinahern.ie.movietrailerapp.util.view.RatingBarometerView
import eoinahern.ie.movietrailerapp.util.view.setGlideImage
import javax.inject.Inject


class ScoresAdapter @Inject constructor() : RecyclerView.Adapter<ScoresAdapter.ViewHolder>() {

    private var scores: List<Score> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.scores_layout_item,
            parent, false
        )

        return ViewHolder(view)
    }

    override fun getItemCount() = scores.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(scores[position])
    }

    fun setScores(listIn: List<Score>) {
        scores = listIn
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val logo by lazy { view.findViewById<ImageView>(R.id.siteLogo) }
        private val scoreBarometer by lazy { view.findViewById<RatingBarometerView>(R.id.ratingBar) }
        private val scoreText by lazy { view.findViewById<TextView>(R.id.scoreTxt) }

        fun bind(score: Score) {
            logo.setGlideImage(score.site.image)
            scoreText.text = score.score.toString()
            scoreBarometer.setScores(score.score, score.site.scale)
        }
    }
}