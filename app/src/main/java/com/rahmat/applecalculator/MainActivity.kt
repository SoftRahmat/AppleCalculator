package com.rahmat.applecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun buNumberEvent(view: View){
        if (isNewOp){
            ShowDisplay.setText("")
        }
        isNewOp=false
        val buSelect= view as Button
        var buClickValue:String=ShowDisplay.text.toString()
        when(buSelect.id) {
            bu0.id-> {
                buClickValue+="0"
            }
            bu1.id-> {
                buClickValue+="1"
            }
            button2.id-> {
                buClickValue+="2"
            }
            button3.id-> {
                buClickValue+="3"
            }
            button4.id-> {
                buClickValue+="4"
            }
            button5.id-> {
                buClickValue+="5"
            }
            button6.id-> {
                buClickValue+="6"
            }
            button7.id-> {
                buClickValue+="7"
            }
            button8.id-> {
                buClickValue+="8"
            }
            button9.id-> {
                buClickValue+="9"
            }
            buttonDot.id-> {
                //TODO: prevent adding more than 1 dot
                buClickValue+="."
            }
            buttonPm.id-> {
                buClickValue="-"+ buClickValue
            }
        }
        ShowDisplay.setText(buClickValue)
    }
    var op="*"
    var oldNumber=""
    var isNewOp=true

    fun buttonDivEvent(view: View) {

        val buSelect= view as Button

        when (buSelect.id) {
            buttonDiv.id -> {
                op="/"
            }
            buttonMul.id -> {
                op="*"
            }
            buttonSub.id -> {
                op="-"
            }
            buttonPlus.id -> {
                op="+"
            }
        }
        oldNumber=ShowDisplay.text.toString()
        isNewOp=true
    }
    fun buttonEqualEvent(view: View){
        val newNumber=ShowDisplay.text.toString()
        var finalNumber:Double?=null
        when(op){
            "/"->{
                finalNumber= oldNumber.toDouble() /newNumber.toDouble()
            }
            "*"->{
                finalNumber= oldNumber.toDouble() *newNumber.toDouble()
            }
            "-"->{
                finalNumber= oldNumber.toDouble() -newNumber.toDouble()
            }
            "+"->{
                finalNumber= oldNumber.toDouble() +newNumber.toDouble()
            }
        }
        ShowDisplay.setText(finalNumber.toString())
        isNewOp=true
    }
    fun buttonPerEvent(view: View){
        val percent:Double=ShowDisplay.text.toString().toDouble()/100

        ShowDisplay.setText(percent.toString())
        isNewOp=true
    }
    fun buttonAcEvent(view: View){
        ShowDisplay.setText("0")
        isNewOp=true
    }
}
