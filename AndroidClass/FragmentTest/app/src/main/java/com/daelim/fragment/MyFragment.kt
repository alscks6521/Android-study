package com.daelim.fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.daelim.MainActivity
import com.daelim.databinding.FragmentMyBinding

class MyFragment : Fragment() {

    // 최신 Fragment의 뷰바인딩
    private var _binding : FragmentMyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMy.setOnClickListener {
            btnClick(it)
        }

        binding.btnProfile.setOnClickListener {
            btnClick(it)
        }
    }
    private fun btnClick(view: View){
        if(view is Button){
            (activity as? MainActivity)?.setButtonText(view.text.toString())
        }
    }

}

