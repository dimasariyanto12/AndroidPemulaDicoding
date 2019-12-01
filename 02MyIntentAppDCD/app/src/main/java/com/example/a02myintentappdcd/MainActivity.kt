package com.example.a02myintentappdcd

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActifity:Button=findViewById(R.id.btn_move_activity)
        btnMoveActifity.setOnClickListener(this)

        val btnMoveActivityWithDataActivity:Button=findViewById(R.id.btn_move_activity_data)
        btnMoveActivityWithDataActivity.setOnClickListener(this)

        val btnDialPhone:Button=findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveWithObjects:Button=findViewById(R.id.btn_move_activity_object)
        btnMoveWithObjects.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btn_move_activity->{
                val moveIntent= Intent(this@MainActivity,MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data->{
                val moveWithDataIntent=Intent(this@MainActivity,MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Dimas Ariyanto")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,5)
                startActivity(moveWithDataIntent)
            }
            R.id.btn_dial_number->{
                val phoneNumber="082325125341"
                val dialPhoneIntent=Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_activity_object->{
                val person=Person(
                    "DicodingAcademy",
                    5,
                     "dimasari@gmail.com",
                    "Jepara"
                )
                val moveWithObjectIntent=Intent(this@MainActivity,MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON,person)

                startActivity(moveWithObjectIntent)
            }
        }
    }

}
