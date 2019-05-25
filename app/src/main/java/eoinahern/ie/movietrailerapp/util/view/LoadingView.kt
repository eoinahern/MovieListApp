package eoinahern.ie.movietrailerapp.util.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import eoinahern.ie.movietrailerapp.R


class LoadingView : FrameLayout {

    lateinit var errorView: LinearLayout
    lateinit var loadingView: LinearLayout

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context)
    }


    private fun init(context: Context) {
        val view = View.inflate(context, R.layout.loading_view_layout, this)
        errorView = view.findViewById(R.id.error_view)
        loadingView = view.findViewById(R.id.progress_view)
    }

    fun setState(state: State) {

        when (state) {
            State.LOADING -> {
                errorView.visibility = View.GONE
                loadingView.visibility = View.VISIBLE
            }
            State.ERROR -> {
                errorView.visibility = View.VISIBLE
                loadingView.visibility = View.GONE
            }
            State.GONE -> {
                visibility = View.GONE
            }
        }
    }

    enum class State {
        LOADING,
        ERROR,
        GONE
    }


}