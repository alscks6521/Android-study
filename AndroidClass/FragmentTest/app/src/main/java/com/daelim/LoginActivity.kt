package com.daelim

import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.daelim.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginBtn.setOnClickListener {
            var id = binding.idTextFiled.text.toString()
            var pw = binding.pwTextFiled.text.toString()
            val bundle = Bundle()
            bundle.putString("id", id)
            bundle.putString("pw", pw)


                if(pw == "1234"){
                    startActivity(Intent(this, MainActivity::class.java).apply {
                        putExtras(bundle)
//                        putExtra("id", id)
//                        putExtra("pw", pw)
                    })
                }else{
                    Log.e("pw error","비밀번호 오류.")
                    Toast.makeText(this, "비밀번호 오류", Toast.LENGTH_SHORT).show()

                }
        }
    }
}