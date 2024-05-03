package com.daelim.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daelim.databinding.FragmentHomeBinding
import android.widget.Button
import com.daelim.MainActivity

class HomeFragment : Fragment() {
//    https://developer.android.com/topic/libraries/view-binding?hl=ko#kts
//    프래그먼트에서의 뷰 바인딩, 메인액티비 뷰 바인딩 관리하는 방식이 조금 다름!

    private var _binding : FragmentHomeBinding?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        /// FragmentTestBinding 클래스를 사용하여 XML 레이아웃 파일과 바인딩한다.
        /// onCreateView() 메서드에서 FragmentTestBinding.inflate()를 호출하여 XML 레이아웃을 inflate한다.
        /// inflate된 레이아웃의 루트 뷰(testBinding.root)를 반환하여 프래그먼트의 UI를 설정한다.
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            btnClick(it)
        }
        binding.btn2.setOnClickListener {
            btnClick(it)
        }
        binding.btn3.setOnClickListener {
            btnClick(it)
        }
    }

    private fun btnClick(view: View){
        if(view is Button){
            (activity as? MainActivity)?.setButtonText(view.text.toString())
        }
    }
}

