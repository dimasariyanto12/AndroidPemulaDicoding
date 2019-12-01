package com.example.a01hitungvolumedcd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import javax.xml.transform.Templates

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var edtWidth:EditText
    private lateinit var edtHeight:EditText
    private lateinit var edtLenght:EditText
    private lateinit var btnCalculate:Button
    private lateinit var tvResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth=findViewById(R.id.edt_width)
        edtHeight=findViewById(R.id.edt_height)
        edtLenght=findViewById(R.id.edt_lengt)
        btnCalculate=findViewById(R.id.btn_calculate)
        tvResult=findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if (savedInstanceState!=null){
            val result=savedInstanceState.getString(STATE_RESULT)
            tvResult.text=result
        }
    }
    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val inputLenght =edtLenght.text.toString().trim()
            val inputWidth=edtWidth.text.toString().trim()
            val inputHeight=edtHeight.text.toString().trim()

            var isEmtyFields=false
            var isInvalidDouble=false

            if (inputLenght.isEmpty()){
                isEmtyFields=true
                edtLenght.error="Field ini tidak boleh kodong!"
            }
            if (inputWidth.isEmpty()){
                isEmtyFields=true
                edtWidth.error="Field ini tidak boleh kosong"
            }
            if (inputHeight.isEmpty()){
                isEmtyFields=true
                edtLenght.error="Field ini tidak boleh kosong"
            }

            val length = toDouble(inputLenght)
            val width= toDouble(inputWidth)
            val heiight=toDouble(inputHeight)

            if (length==null){
                isInvalidDouble=true
                edtLenght.error="Field ini harus berupa nomor yang valid"
            }
            if (width==null){
                isInvalidDouble=true
                edtWidth.error="Field ini harus berupa nomor yang valid"

            }
            if (heiight==null){
                isInvalidDouble=true
                edtHeight.error="Field ini harus berupa nomor yang valid"
            }

            if (!isEmtyFields && !isInvalidDouble){
                val volume = length as Double * width as Double * heiight as Double
                tvResult.text=volume.toString()
            }


        }


    }
    companion object{
        private  const val STATE_RESULT="state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT,tvResult.text.toString())
    }

    private fun toDouble(str: String): Double? {
        return  try {
            str.toDouble()
        }catch (e:NumberFormatException){
            null
        }
    }
}
