package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var names = listOf<Int>(1,2,3,4,5,6,7,8,9)
    lateinit var timer:Timer
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }
    private fun  init(){
        yktextView.text = names[index].toString()

        ykbutton.setOnClickListener(){
            if (ykbutton.text.toString() == "START"){
                ykbutton.text = "STOP"
//                创建定时器
                timer = Timer()
                timer.schedule(object : TimerTask(){
                        override fun run() {
                            if (index + 1 > names.size - 1){
                                index = 0
                            }else{
                                index ++
                            }
                            yktextView.text = names[index].toString()
                        }
                },0,100)
            }else{
                ykbutton.text = "START"
                timer.cancel()
            }

        }
    }
}
