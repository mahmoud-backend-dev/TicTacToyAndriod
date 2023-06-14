package com.example.myfirstapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkwinner()
    }
    fun buSelect(view:View)
    {
        var buChoise = view as Button
        var cellid=0
        when(buChoise.id)
        {
            R.id.bu1-> cellid=1
            R.id.bu2-> cellid=2
            R.id.bu3-> cellid=3
            R.id.bu4-> cellid=4
            R.id.bu5-> cellid=5
            R.id.bu6-> cellid=6
            R.id.bu7-> cellid=7
            R.id.bu8-> cellid=8
            R.id.bu9-> cellid=9
        }
        Log.d("cellid:", cellid.toString())
         PlayGame(cellid,buChoise)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlaye=1

    fun PlayGame(cellid:Int,buChoise:Button)
    {
        if (activePlaye==1)
        {
            buChoise.text="X"
            buChoise.setBackgroundResource(R.color.blue)
            player1.add(cellid)
            activePlaye=2
            AutoPlay()
        }else
        {
            buChoise.text="O"
            buChoise.setBackgroundResource(R.color.darkgreen)
            player2.add(cellid)
            activePlaye=1
        }
        buChoise.isEnabled=false
        checkwinner()
    }
     fun checkwinner()
    {
        var winner = -1
        //row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner=1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner=2
        }
        //row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner=1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner=2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner=1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner=2
        }
        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner=1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner=2
        }
        //col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner=1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner=2
        }
        //col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner=1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner=2
        }
        //inbox right
        if (player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner=1
        }
        if (player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner=2
        }
        //inbox left
        if (player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner=1
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner=2
        }
        if (winner !=-1)
        {
            if (winner==1)
            {
                 Toast.makeText(this,"player 1 win the game",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"player 2 win the gama",Toast.LENGTH_LONG).show()
            }
        }
    }

    fun AutoPlay()
    {
        val empteCells=ArrayList<Int>()
        for (cellID in 1..9)
        {
            if (!(player1.contains(cellID)))
                empteCells.add(cellID)
        }

        val r=Random()
        val randIndex=r.nextInt(empteCells.size-1)+1
        val CellID=empteCells[randIndex]
        var buSelect:Button?
        when(CellID)
        {
            1->buSelect=bu1
            2->buSelect=bu2
            3->buSelect=bu3
            4->buSelect=bu4
            5->buSelect=bu5
            6->buSelect=bu6
            7->buSelect=bu7
            8->buSelect=bu8
            9->buSelect=bu9
            else->{
                buSelect=bu1
            }
        }
        PlayGame(CellID,buSelect)
    }

}