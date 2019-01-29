package com.ljt.kotlinanko.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.dip

class SharesChat :View {
    constructor(context: Context) :super(context){}


    constructor(context: Context,attrs:AttributeSet?):super(context){}



    val yinPaint= Paint();
    val yanPaint= Paint()

    val totalPaint=Paint()
    var currentPaint= yinPaint


    var height=0f
    var width = 0f

    val list = arrayListOf<Shares>()

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        System.out.println("---------onSizeChanged----------");
        height=h.toFloat()
        width=w.toFloat()


        yinPaint.strokeWidth=dip(2).toFloat()
        yinPaint.style=Paint.Style.FILL
        yinPaint.color= Color.BLUE
        yinPaint.isAntiAlias=true
        yinPaint.textSize=dip(15).toFloat()

        yanPaint.strokeWidth=dip(2).toFloat()
        yanPaint.style=Paint.Style.STROKE
        yanPaint.color=Color.RED

        totalPaint.style=Paint.Style.FILL
        totalPaint.strokeWidth=dip(5).toFloat()

        for(i in 1..5){
            val shares=Shares(800f-i*50,700f-i*50,600f-i*50,500f-i*50,i*50f)
            list.add(shares)
        }

        for(i in 1..5){
            val shares=Shares(800f-(5-i)*50,700f-(5-i)*50
                    ,600f-(5-i)*50,500f-(5-i)*50,(5-i)*50f)
            list.add(shares)
        }



    }

    var topPrice=800f
    var openPrice=700f
    var receivePrice=600f
    var bottomPrice=500f
    var widthPrice=dip(5).toFloat()
    var currentPosition=200f

    override fun onDraw(canvas: Canvas){
        super.onDraw(canvas)
        System.out.println("---------onDraw----------");
        for(i in list.indices){
            if(i % 2 ==0){
                totalPaint.color=Color.BLUE
                currentPaint=yinPaint
            } else {
                totalPaint.color=Color.RED
                currentPaint=yanPaint
            }
            yinCanvas(list[i],canvas)
            currentPosition+=100f
        }
        drawScale(canvas)
    }

    fun yinCanvas(shares: Shares,canvas: Canvas){
        System.out.println("---------yinCanvas----------");
        canvas.drawLine(currentPosition,height-shares.bottomPrice,currentPosition,height-shares.receivePrice,
                currentPaint )
        val rectF= RectF()
        rectF.left=currentPosition-widthPrice
        rectF.bottom=height-shares.receivePrice
        rectF.right=currentPosition+widthPrice
        rectF.top=height-shares.openPrice
        canvas.drawRect(rectF,currentPaint)
        canvas.drawLine(currentPosition,rectF.top,currentPosition,height-shares.topPrice,currentPaint)

        canvas.drawLine(currentPosition,height,currentPosition,height-shares.total,totalPaint)
    }

    fun drawScale(canvas:Canvas){
        System.out.println("---------drawScale----------");
        for(i in 1..height.toInt()){
            if(i % 100==0){
                canvas.drawLine(0f,height-i,dip(10).toFloat(),height-i,yinPaint)
                canvas.drawText(i.toString(),dip(10).toFloat(),height-i,yinPaint)
            }
        }
        for(i in 1..width.toInt()){
            if(i%100==0){
                canvas.drawLine(i.toFloat(),height,i.toFloat(),height-dip(10).toFloat(),yinPaint)
            }
        }
    }

}