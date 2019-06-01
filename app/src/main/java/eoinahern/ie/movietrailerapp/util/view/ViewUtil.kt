package eoinahern.ie.movietrailerapp.util.view

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide


fun View.updateOpacityVal(opacityVal: Float) {
    this.alpha = opacityVal
}


fun ImageView.setGlideImage(url: String) {

    Glide.with(this.context)
        .load(url)
        .override(this.width, this.height)
        .into(this)
}