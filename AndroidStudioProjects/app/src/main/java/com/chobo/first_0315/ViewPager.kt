package com.chobo.first_0315

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class ViewPager : AppCompatActivity() {

    // 내부클래스 ViewPagerAdapter 정의방법의 프래그먼트 리스트 초기화
    private val fragments = listOf(
        FirstFragment(),
        SecondFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_pager)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            /// insets = 리스너에게 반환
            insets
        }

        // ViewPager2 설정
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPager.adapter = ViewPagerAdapter(this) // this. 현재 액티비티의 인스턴스
    }

    // 내부 클래스로 ViewPagerAdapter 정의방법임.  | 외부 클래스로 정의방법은 ViewPagerAdapter.kt 파일 확인.
    private inner class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = fragments.size

        override fun createFragment(position: Int): Fragment {
            return when(position){
                0 -> FirstFragment()
                1 -> SecondFragment()
                else -> throw IllegalStateException("Invalid position $position") // 예외 처리
            }
        }
    }
}