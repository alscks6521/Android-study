package com.example.notification0419
import android.app.Notification
import com.example.notification0419.databinding.ActivityMainBinding
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            createNotificationChannel()
        }
    }

    private fun createNotificationChannel() {
        // Android 8.0 (API 레벨 26) 이상에서만 알림 채널을 생성하도록
        var builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelName = "My Channel"

            // Id: 알림 채널의 고유 ID / name: 사용자에게 표시될 알림 채널의 이름 / importance: 알림 채널의 중요도를 나타내는 상수
            // 함수를 호출하여 알림 채널을 생성하고 등록
            val channel = NotificationChannel("id_1", "Channel1", NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = "My channel 설명"

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // 호출하여 생성한 알림 채널을 시스템에 등록
            notificationManager.createNotificationChannel(channel)

             builder = NotificationCompat.Builder(this, "id_1")
//
//            notificationManager.notify(1, builder.build())
////            with(NotificationManagerCompat.from(this)) {
////                notificationManager.notify(1, builder.build())
//            }
        }else{
             builder = NotificationCompat.Builder(this).setPriority(NotificationCompat.PRIORITY_DEFAULT)
        }
         builder
             .setSmallIcon(R.drawable.ic_launcher_background)
             .setContentTitle("알림 제목")
            .setContentText("알림 내용")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        // Send the notification for all API levels
        NotificationManagerCompat.from(this).notify(1, builder.build())
    }


}