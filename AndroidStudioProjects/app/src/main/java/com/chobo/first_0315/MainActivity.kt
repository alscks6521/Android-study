package com.chobo.first_0315

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.chobo.first_0315.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AAA {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main) // 레이아웃을 setContentView 기본 함수에 넣어서 뷰바인딩해준다는 뜻임. 아래는 직접 만들기.
        binding = ActivityMainBinding.inflate(layoutInflater)  // activity_main.xml을 ActivityMainBinding가 받아옴.
        setContentView(binding.root) // xml을 받은 binding 객체를 .root로 뷰 반인딩을 시켜줌


        binding.bt.setOnClickListener {
            Log.e("test Log e", "에러로그")
            var a:String = "Hi"
            onClick(a)
            // startActivity안에는 두가지의 엑티비티가 필여하다. 페이지 이동 ( 현재 , 대상 )
            startActivity(Intent(this, MainActivity2::class.java))
//            finish() // 뒤로 가기 안되게 끝내기
        }

//        binding.fragBtn.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.one_fragment, Fragment_test())
//                    .addToBackStack(null)
//                    .commit()
//            }
//        }
        binding.fragBtn.setOnClickListener {
            val data = "데이터 바인딩 값!"
            val fragmentTest = Fragment_test()
            fragmentTest.setCallback(this)
            val bundle = Bundle()
            bundle.putString("data", data)
            fragmentTest.arguments = bundle
            aa(data);
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.one_fragment, fragmentTest)
                    .addToBackStack(null)
                    .commit()
            }
        }
        binding.battBtn.setOnClickListener {
            startActivity(Intent(this, bottom_navigation_activity::class.java))
        }

        binding.viewpagerBtn.setOnClickListener {
            startActivity(Intent(this, ViewPager::class.java))
        }
    }

     override fun aa(data: String){
        Log.d("aa CallBack :","$data")
    }

    @Override private fun onClick(str:String){
        Log.e("test Log onClick: ", str)
    }


}



