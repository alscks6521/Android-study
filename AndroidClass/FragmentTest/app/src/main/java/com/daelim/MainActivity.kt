package com.daelim

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.daelim.databinding.ActivityMainBinding
import com.daelim.fragment.HomeFragment
import com.daelim.fragment.MyFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // 레이아웃을 setContentView 기본 함수. 아래는 뷰바인딩 만들기.
        binding = ActivityMainBinding.inflate(layoutInflater)  // activity_main.xml을 ActivityMainBinding가 받아옴.
        setContentView(binding.root) // xml을 받은 binding 객체를 .root로 뷰 반인딩을 시켜줌

        val id = intent.getStringExtra("id")

        binding.userId.text = "${id}님 반갑습니다."


        binding.cateHomeBtn.setOnClickListener {
            showFragment(HomeFragment())
        }

        binding.cateMyBtn.setOnClickListener {
            showFragment(MyFragment())
        }
    }

    fun setButtonText(text: String) {
        binding.selectView.text = text
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_fragment, fragment)
            commit()
        }
    }

}