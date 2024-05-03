package com.chobo.first_0315
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chobo.first_0315.databinding.FragmentTestBinding

class Fragment_test : Fragment() {
//    private lateinit var bbbInstance: BBB
    private var callback: AAA? = null

    lateinit var testBinding : FragmentTestBinding

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
////        arguments?.let {
////        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        /// FragmentTestBinding 클래스를 사용하여 XML 레이아웃 파일과 바인딩한다.
        /// onCreateView() 메서드에서 FragmentTestBinding.inflate()를 호출하여 XML 레이아웃을 inflate한다.
        /// inflate된 레이아웃의 루트 뷰(testBinding.root)를 반환하여 프래그먼트의 UI를 설정한다.
        testBinding = FragmentTestBinding.inflate(inflater, container, false)
        return testBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data = arguments?.getString("data")
//        bbbInstance = BBB()
//        bbbInstance.aa(data ?: "No Data!")
        someEvent()
    }

    private fun someEvent() {
        val data = "Some data"
        Log.d("aa Fragment", "data: $data")
    }
    // 콜백 설정 메서드
    fun setCallback(callback: AAA) {
        callback?.aa("hi")
        this.callback = callback
    }
}

