package eoinahern.ie.movietrailerapp.util

import android.app.Activity
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.util.view.LoadingView
import eoinahern.ie.movietrailerapp.util.view.LoadingView.State


fun Activity.showLoading(show: State) {
    val loadingView = this.findViewById<LoadingView>(R.id.loading)
    loadingView.setState(show)
}