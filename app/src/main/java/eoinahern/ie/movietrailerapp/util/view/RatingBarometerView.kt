package eoinahern.ie.movietrailerapp.util.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import eoinahern.ie.movietrailerapp.R


class RatingBarometerView(context: Context, attrs: AttributeSet? = null) : View(
    context,
    attrs
) {

    private lateinit var paint: Paint
    private lateinit var paintRemainder: Paint
    private lateinit var innerPaint: Paint


    init {
        init()
    }

    /**
     * animate the barometer increase
     */

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawArc(
            0f, 0f, width.toFloat(), height.toFloat(), 270f,
            -160f, true, paintRemainder
        )


        canvas?.drawArc(
            0f, 0f, width.toFloat(), height.toFloat(), 270f,
            240f, true, paint
        )

        val innerwidth = (width * 0.90).toFloat()
        val innerheight = (height * 0.90).toFloat()
        val innerLeft = width - innerwidth
        val innerTop = height - innerheight


        canvas?.drawArc(
            innerLeft, innerTop, innerwidth, innerheight, 270f, 360f,
            true, innerPaint
        )

    }


    fun updatePercentageView(percentage: Int) {
    }


    private fun animateCircle() {
    }


    fun init() {
        paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.limeGreen)
        paint.strokeWidth = 30f
        paint.style = Paint.Style.FILL
        paint.strokeCap = Paint.Cap.ROUND

        paintRemainder = Paint()
        paintRemainder.color = ContextCompat.getColor(context, R.color.medGrey)
        paintRemainder.strokeWidth = 30f
        paintRemainder.style = Paint.Style.FILL
        paintRemainder.strokeCap = Paint.Cap.SQUARE

        innerPaint = Paint()
        innerPaint.color = ContextCompat.getColor(context, R.color.dimGrey)
        innerPaint.style = Paint.Style.FILL
        //sinnerPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.OVERLAY)
        innerPaint.strokeCap = Paint.Cap.SQUARE
    }
}