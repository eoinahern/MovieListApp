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
    private var score: Float = -1f
    private var scale: Float = -1f
    private var negativeArcAngle: Float = -1f
    private var scoreArcAngle: Float = -1f
    private val zeroStartPoint = 0f
    private val startPointAngle = 270f
    private val fullSweepAngle = 360f

    init {
        initPaint()
    }

    fun setScores(score: Float, scale: Float) {
        this.score = score
        this.scale = scale
        calculatePercentage(score, scale)
    }

    /**
     * animate the barometer increase
     */

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        drawChart(canvas)
    }

    private fun drawChart(canvas: Canvas?) {

        if (score < 0f && scale < 0f) return

        canvas?.drawArc(
            zeroStartPoint, zeroStartPoint, width.toFloat(), height.toFloat(), startPointAngle,
            negativeArcAngle, true, paintRemainder
        )


        canvas?.drawArc(
            zeroStartPoint, zeroStartPoint, width.toFloat(), height.toFloat(), startPointAngle,
            scoreArcAngle, true, paint
        )

        drawInnerCircle(canvas)
    }


    private fun drawInnerCircle(canvas: Canvas?) {

        val innerwidth = (width * 0.90).toFloat()
        val innerheight = (height * 0.90).toFloat()
        val innerLeft = width - innerwidth
        val innerTop = height - innerheight

        canvas?.drawArc(
            innerLeft, innerTop, innerwidth, innerheight, startPointAngle, fullSweepAngle,
            true, innerPaint
        )
    }

    private fun calculatePercentage(rating: Float, scale: Float) {
        scoreArcAngle = (rating / scale) * fullSweepAngle
        negativeArcAngle = -(1 - (rating / scale) * fullSweepAngle)
        invalidate()
    }

    private fun initPaint() {
        paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.limeGreen)
        paint.strokeWidth = 30f
        paint.style = Paint.Style.FILL
        paint.strokeCap = Paint.Cap.ROUND

        paintRemainder = Paint()
        paintRemainder.color = ContextCompat.getColor(context, R.color.greyTransparent)
        paintRemainder.strokeWidth = 30f
        paintRemainder.style = Paint.Style.FILL
        paintRemainder.strokeCap = Paint.Cap.SQUARE

        innerPaint = Paint()
        innerPaint.color = ContextCompat.getColor(context, R.color.dimGrey)
        innerPaint.style = Paint.Style.FILL
        innerPaint.strokeCap = Paint.Cap.SQUARE
    }
}