package eoinahern.ie.movietrailerapp.util.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import eoinahern.ie.movietrailerapp.R


class RatingBarometerView(context: Context, attrs: AttributeSet? = null) : View(
    context,
    attrs
) {

    private lateinit var paint: Paint

    init {
        init()
    }

    /**
     * animate the barometer increase
     */

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(
            left.toFloat(), top.toFloat(), right.toFloat(),
            bottom.toFloat(), 270f, 180f, true, paint
        )
    }


    fun updatePercentageView(percentage: Int) {
    }


    private fun animateCircle() {
    }


    fun init() {
        paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.wineRed)
        paint.style = Paint.Style.STROKE
        paint.strokeCap = Paint.Cap.ROUND
    }
}