package com.example.getfit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_status.*
import java.text.DecimalFormat
import java.text.NumberFormat

class StatusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_status)
        var average:Int=0

        var timelist= mutableListOf<Int>()
        var mylist= mutableListOf<String>()
        var bundle=intent.extras
        if (bundle != null) {
            mylist=bundle.getSerializable("data") as MutableList<String>
        }

        mylist.forEach {
           timelist.add(it.toSeconds())
        }

       textViewSlowestLap.text= mylist[timelist.indexOf(timelist.maxOrNull())]
        textViewFastestLap.text=mylist[timelist.indexOf(timelist.minOrNull())]

        average=timelist.average().toInt()

        var formatter:NumberFormat=DecimalFormat("00")

        textViewAverageLap.text="${formatter.format(average/60)}:${formatter.format(average%60)}"



        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=ListAdapter(mylist)
  }
}


fun String.toSeconds():Int{
    val factors= arrayOf(60,1)
    var value=0
    this.split(":").forEachIndexed{
        i,s -> value+=factors[i]*s.toInt()
    }
    return value
}