package eoinahern.ie.movietrailerapp.ui.view.all

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailActivity
import eoinahern.ie.movietrailerapp.util.MOVIE_LIST_KEY
import eoinahern.ie.movietrailerapp.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_all_section.*
import javax.inject.Inject

class AllSectionActivity : BaseActivity() {

    @Inject
    lateinit var adapter: AllSectionAdapter

    private val layoutManager: GridLayoutManager = GridLayoutManager(baseContext, 2)

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val movieList = intent.getParcelableArrayListExtra<MovieListEntry>(MOVIE_LIST_KEY)
            .toList()
        initAdapter()
        adapter.setList(movieList)
        adapter.listener = ::navigateDetail
    }

    override fun getLayout() = R.layout.activity_all_section

    private fun initAdapter() {
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
    }

    private fun navigateDetail(id: String) {
        startActivity(DetailActivity.getStartIntent(this))
    }

    companion object {
        fun getStartIntent(context: Context): Intent =
            Intent(context, AllSectionActivity::class.java)
    }
}
