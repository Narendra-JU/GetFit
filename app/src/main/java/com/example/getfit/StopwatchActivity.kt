package com.example.getfit

import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_stopwatch.*
import java.io.Serializable

class StopwatchActivity : AppCompatActivity() {


    lateinit var lapList:MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stopwatch)
        var lapcount:Int=1
        var buttonStartstate=0;
        lapList= mutableListOf<String>()


        buttonNewLap.isEnabled=false
        buttonStats.isEnabled=false
        chronometer1.base = SystemClock.elapsedRealtime()
        chronometer2.base = SystemClock.elapsedRealtime()

        buttonStart.setOnClickListener {
            textviewlapcount.text=lapcount.toString()
            if (buttonStartstate==0) {
                buttonStart.text="STOP"//starts the process

                chronometer1.start()
                chronometer2.start()


                buttonNewLap.isEnabled=true
                buttonStats.isEnabled=true
            }
            if (buttonStartstate==1){
                chronometer1.stop()
                chronometer2.stop()
                buttonNewLap.isEnabled=false
                buttonStart.isEnabled=false
                var str1:String=chronometer1.getText().toString()

                lapList.add(str1)


            }
            buttonStartstate=1;

        }

        buttonNewLap.setOnClickListener {
            lapcount += 1
            textviewlapcount.text=lapcount.toString()
            var str:String=chronometer1.getText().toString()

            lapList.add(str)
            chronometer2.stop()
            chronometer1.base=SystemClock.elapsedRealtime()

            chronometer1.start()
            chronometer2.start()

        }
        buttonReset.setOnClickListener {
            chronometer1.base=SystemClock.elapsedRealtime()
            chronometer1.stop()
            chronometer2.base=SystemClock.elapsedRealtime()
            chronometer2.stop()
            lapcount=1
            buttonStartstate=0;
            buttonStart.text="START"
            textviewlapcount.text="0"
            buttonNewLap.isEnabled=false
            buttonStats.isEnabled=false
            buttonStart.isEnabled=true
            lapList= mutableListOf<String>()


        }
        buttonStats.setOnClickListener {

            var intent1=Intent(this, StatusActivity::class.java)
            var bundle = Bundle()
            bundle.putSerializable("data",lapList as Serializable)
            intent1.putExtras(bundle)
            startActivity(intent1)


        }
    }
}