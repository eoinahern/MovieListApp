package eoinahern.ie.movietrailerapp.ui.view.list

import android.os.Bundle
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.data.model.MovieListEntry
import eoinahern.ie.movietrailerapp.ui.base.BaseActivity
import eoinahern.ie.movietrailerapp.ui.view.all.AllSectionActivity
import eoinahern.ie.movietrailerapp.ui.view.detail.DetailActivity
import eoinahern.ie.movietrailerapp.util.exception.Failure
import eoinahern.ie.movietrailerapp.util.lifecycle.failure
import eoinahern.ie.movietrailerapp.util.lifecycle.observe
import eoinahern.ie.movietrailerapp.util.view.LoadingView.State
import kotlinx.android.synthetic.main.activity_list.*
import javax.inject.Inject

class ListActivity : BaseActivity() {

    @Inject
    lateinit var adapter: ListActivityAdapter

    private lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        initViewModel()
        observeUpdates()
        getMovieData()
    }

    override fun getLayout() = R.layout.activity_list

    private fun initViewModel() {
        viewModel = getViewModel(ListViewModel::class.java)
    }

    private fun observeUpdates() {
        observe(viewModel.getMovieList(), ::onDataReturned)
        observe(viewModel.getListNavigate(), ::navigateList)
        observe(viewModel.getItemNavigate(), ::navigateSingleItem)
        failure(viewModel.failureLiveData, ::handleFailure)
    }

    private fun getMovieData() {
        viewModel.getFromApi(resources.getStringArray(R.array.end_point_titles).toList())
    }

    private fun handleFailure(failure: Failure) {
        when (failure) {
            Failure.ServerFailure, Failure.NetworkFailure -> {
                loading.setState(State.ERROR)
            }
        }
    }

    private fun navigateList(list: List<MovieListEntry>) {
        startActivity(AllSectionActivity.getStartIntent(this))
    }

    private fun navigateSingleItem(id: String) {
        startActivity(DetailActivity.getStartIntent(this))
    }

    private fun onDataReturned(map: Map<String, List<MovieListEntry>>) {
        loading.setState(State.GONE)
        adapter.setMap(map)
        recycler.adapter = adapter

    }
}
