package com.example.a10week


import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import com.example.a10week.databinding.ActivityMainBinding
import com.example.a10week.interfaces.DateApiService
import com.example.a10week.models.PublicHolidays
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    // 여기부터
    val retrofit = Retrofit.Builder()
        .baseUrl("https://date.nager.at/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val dateApiService = retrofit.create(DateApiService::class.java)
    // 여기까지

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.restGetButton.setOnClickListener {

            dateApiService.getHolidays("2023", "KR")
                .enqueue(object: Callback<List<PublicHolidays>> {

                    override fun onResponse(call: Call<List<PublicHolidays>>, response: Response<List<PublicHolidays>>) {

                        if(response.isSuccessful.not()) return

                        response.body()?.let{
                            Log.d("OK", it.toString())

                            binding.container.removeAllViews() // 사전 초기화

                            it.forEachIndexed { index, publicHolidays ->
                                Log.d(
                                    "DATA",
                                    "[$index] date = ${publicHolidays.date}, name = ${publicHolidays.dateName}"
                                )


                                // 텍스트뷰 생성
                                val textView = TextView(this@MainActivity).apply {
                                    text = "${publicHolidays.date}: ${publicHolidays.dateName}"
                                    layoutParams = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT
                                    )
                                    textSize = 16f
                                    setPadding(8, 8, 8, 8)
                                }


                                // 컨테이너에 텍스트뷰 추가
                                binding.container.addView(textView)

                            }
                        } ?: run {
                            Log.d("NG", "body is null")
                        }
                    }

                    override fun onFailure(call: Call<List<PublicHolidays>>, t: Throwable) {
                        Log.e("ERROR", t.toString())
                        Toast.makeText(applicationContext, t.toString(), Toast.LENGTH_LONG).show()
                    }

                })
        }
    }
}
