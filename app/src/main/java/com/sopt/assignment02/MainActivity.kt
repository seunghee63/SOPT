package com.sopt.assignment02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_SIGN_UP = 111 //후에 어떤 액티비티에서 보낸 것인지 확인하기 위함

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //입력받은 id값을 문자열 변수로 바뀌줌

        //sign up 버튼을 눌렀을 때,
        btn_main_sign_up.setOnClickListener {

            val mInputId: String = et_main_id.text.toString() //그냥 input으로 하면 에러남
            val intent = Intent(this, SignUpActivity::class.java)

            //id라는 이름으로 mInputId 값 넘김
            intent.putExtra("id",mInputId)
            startActivityForResult(intent, REQUEST_CODE_SIGN_UP)
        }

        //sign_in 버튼을 눌렀을 때,
        btn_main_sign_in.setOnClickListener {
            //toast("로그인")
        }
    }

    //signup activity에서 보낸 결과 받아 옴
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //sign_up에서 보낸 액티비티가 맞을 경우
        if (requestCode == REQUEST_CODE_SIGN_UP) {
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    val id = data.getStringExtra("id")
                    et_main_id.setText(id)
                }
            }
        }
    }

}
