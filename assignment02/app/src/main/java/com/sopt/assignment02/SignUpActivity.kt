package com.sopt.assignment02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        intent.getStringExtra("id")?.let{
            val initId = intent.getStringExtra("id")
            et_sign_up_id.setText(initId)

        }

        btn_signup_complete.setOnClickListener {
            val intent : Intent = Intent()
            intent.putExtra("id", et_sign_up_id.text.toString())
            setResult(Activity.RESULT_OK,intent)

            finish()
        }

    }


}