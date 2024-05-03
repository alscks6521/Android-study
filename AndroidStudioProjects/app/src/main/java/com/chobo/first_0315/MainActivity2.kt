package com.chobo.first_0315

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.chobo.first_0315.databinding.ActivityMain2Binding
import org.w3c.dom.Text


class MainActivity2 : AppCompatActivity() {
    private var inputValue:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        var binding = ActivityMain2Binding.inflate(layoutInflater)  // activity_main.xml을 ActivityMainBinding가 받아옴.


    }
    fun onValue(v:View){
        inputValue?.append((v as Button).text)
        println("click : $inputValue")
    }
}