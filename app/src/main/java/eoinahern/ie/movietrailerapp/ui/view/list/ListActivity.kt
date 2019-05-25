package eoinahern.ie.movietrailerapp.ui.view.list

import android.os.Bundle
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.util.lifecycle.observe
import javax.inject.Inject

class ListActivity : BaseActivity() {

    @Inject
    lateinit var adapter: ListActivityAdapter

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        viewModel = getViewModel(ListViewModel::class.java)
        observe(viewModel.getMovieList(), ::onDataReturned)
    }


    private fun onError() {

    }

    private fun onDataReturned(map: Map<String, List<MovieListEntry>>) {

    }
}
