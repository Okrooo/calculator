package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand:Int = 0
    private var operation:String =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        resultTextView= findViewById(R.id.resultTextView)
    }

    fun numberClick(clickedView: View){
        if (clickedView is TextView){
            val number: String = clickedView.text.toString()
            val resultText: String = resultTextView.text.toString()
            resultTextView.text = resultText+number
        }
    }

    fun operationClick(view:View) {
        if (view is TextView) {
            val result: String = resultTextView.text.toString()
            if (result.isNotEmpty()) {
                this.operand = result.toInt()
            }
            resultTextView.text = ""

            this.operation = view.text.toString()
        }
    }

    fun equalsClick(view: View){
        val secOperandText: String = resultTextView.text.toString()
        var secOperand: Int = 0

        if(secOperandText.isNotEmpty()){
            secOperand = secOperandText.toInt()
        }
        when(this.operation){
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "x" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "%" -> resultTextView.text = (operand / 100).toString()
            "X^" -> resultTextView.text = (Math.pow(operand.toDouble(),secOperand.toDouble())).toString()
            "R" -> resultTextView.text = (Math.sqrt(operand.toDouble())).toString()

        }
    }

    fun clearClick(view: View){
        if(view is View){

        }
    }

}