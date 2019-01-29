package com.ljt.kotlinanko.view

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.ljt.kotlinanko.MainActivity
import com.ljt.kotlinanko.R
import com.ljt.kotlinanko.SecondActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainView : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>): View =ui.apply{
        scrollView {
            padding=dip(30)
            verticalLayout {

                textView{
                    text="Anko Commons组件的使用"
                    textColor=0xff0000

                }

                val name=editText{
                    hint="请输入你名字"
                }

                button{
                    text="点击"
                    onClick {
                        toast("${name.text}"+ R.string.app_name)
                    }
                }.lparams(width= wrapContent,height = wrapContent){
                    topMargin=dip(10)
                }

                button{
//                    id=R.id.main
                    text="startActivity"
                    onClick {
                        var intent= Intent(ctx, SecondActivity::class.java)
                        intent.putExtra("id","${name.text}")
                        ctx.startActivity(intent)
                    }
                }


            }

        }.applyRecursively {
            view->
            //
            when(view){
                is Button ->{
                    view.textSize =15f
//                    view.textColor=ctx.getColor(R.color.colorAccent)
                }

                is EditText ->{
                    view.hint="批量修改"
                }
            }
        }
    }.view
}