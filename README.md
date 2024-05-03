# 복습 AndroidStudioProjects  
## 중요포인트💡  
### 디자인패턴 MVVM ( Model-View-ViewModel )  
<img height="10%" alt="image" src="https://github.com/alscks6521/Android-study/assets/112923685/e86b70e2-6e16-4555-a164-b2497cb675a7">  

### View(UI 레이어):  

UI 컴포넌트들로 구성 (예: Activity, Fragment, XML 레이아웃 등)  

사용자의 액션이나 이벤트를 받아들이고, 이를 ViewModel에 전달한다.  

ViewModel의 상태 변화를 관찰(Observer)하고 있다가, 변경사항이 발생하면 그에 따라 UI를 업데이트한다.  

UI 로직을 포함하지만, 비즈니스 로직은 포함하지 않는다.  

### Model(프레젠테이션 레이어):  
앱의 데이터와 관련된 로직을 담당 및 데이터의 상태와 조작 방법을 정의한다.  

로컬 데이터베이스, 원격 서버, 파일 시스템 등 다양한 데이터 소스와 상호작용한다.  

Repository 패턴을 사용하여 데이터 소스에 접근하는 로직을 추상화하고, ViewModel에 데이터를 제공한다.  

네트워크 요청, 데이터베이스 쿼리, 파일 I/O 등의 작업을 수행

### ViewModel:
Flutter의 GetX 라이브러리와 MVVM 패턴의 ViewModel은 유사한 역할을 한다.  

View와 Model 사이의 중개자 역할을 한다.  

View에 표시될 데이터를 가공하고 관리한다. LiveData나 Observable을 사용하여 데이터를 노출한다.  

사용자 액션이나 이벤트에 대한 로직을 처리하고, 필요한 데이터를 Model에 요청한다.  

Android Jetpack의 ViewModel 클래스를 상속받아 구현하며, 구성 변경(Configuration Changes)에도 데이터를 유지할 수 있다.  

비즈니스 로직을 담당하지만, UI에 대한 직접적인 참조는 가지고 있지 않다.  
### 정리  
View는 사용자 인터페이스를 담당하고, 사용자 이벤트를 받아들인다.  

ViewModel은 View와 Model 사이의 중개자 역할을 하며, 데이터를 가공하고 관리한다.  

Model은 앱의 데이터와 관련된 로직을 담당하며, 데이터 소스와 상호작용한다.  

---  

## 1.0  JAVA, Kotlin
Q. 자바와 코틀린이 비슷하지만 앱개발을 코틀린으로 하는 이유 : 
A. 개발자가 개발함에 있어 오류를 발생할 확률이 났다.

Q. 하지만 오류가 없다는 과정이면 자바가 효율이 좋을 수 있다.
A. 코틀린과 자바의 라이브러리, 함수 → ‘JAVA API’ → ‘JVM’ 에서 동작  

### 1.1. 
1. Kotlin! 코틀린은 모든 변수가 객체이다.  

2. Kotlin! 객체기 때문에 앞에 글자는 대문자로 사용한다. 예: val i : Int. 

3. System! Int형 = 8바이트   

4. Kotlin! fun (반환형) 함수명(매개변수) : (반환형) { }. 
    
---
## 2.0 안드로이드 액티비티 화면 컨트롤   
```kotlin
// 레이아웃을 setContentView 기본 함수에 넣어서 뷰바인딩해준다는 뜻
setContentView(R.layout.activity_main)
```  
↓  

```kotlin
// activity_main.xml을 ActivityMainBinding가 받아옴.	
var binding = ActivityMainBinding.inflate(layoutInflater)
// xml을 받은 binding 객체를 .root로 뷰 반인딩을 시켜줌
setContentView(binding.root) 
```
```kotlin
// 페이지 이동
startActivity(Intent(this, MainActivity2::class.java))
// 만약 넘어간뒤 현재 페이지로 뒤돌아오지 않게 하려면 
 finsh()  
```  
---  
### 3.0 LinearLayout, 화면구성, Fragment  

***안드로이드에서 크기값 수정 방법 3가지***
1. 수치값 ( px, sp, dp 단위 )
2. wrap-content
3. match-parent 

***LinearLayout의 특이점***
```kotlin
android:orientation = “____”
// 정렬을 해주어야됨. ( 가로(ver…), 세로(hor…) 
```   
***Fragment***.   

아래 코드는 지정된 액티비티 내에서 R.id.one_fragment라는 컨테이너에 fragmentTest라는 새 프래그먼트를 삽입하고, 이 변경을 백스택에 추가한 다음, 이 모든 변경을 커밋하여 실행하는 과정을 담고 있다.   
이를 통해 액티비티의 UI 상에서 프래그먼트 교체가 이루어지며, 사용자가 뒤로 가기를 할 경우 이전 프래그먼트 상태로 돌아갈 수 있다
```kotlin
// 프래그먼트 관리를 위해 사용
// 주로 액티비티 내에서 다른 프래그먼트로의 전환을 처리하는 데 사용
supportFragmentManager.beginTransaction().apply {
    replace(R.id.one_fragment, testFragment)
        .addToBackStack(null)
        .commit()
}
```
---
# Notification사용 AndroidClass
**권한설정 코드추가 AndoridManifest.xml**  
```kotlin
<manifest xmlns.../>
// Notification 코드추가
 <uses-permission android:name="android.permission.POST_NOTIFICATIONS"/>
<application...
```
```kotlin
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
        var builder: NotificationCompat.Builder

        // Android 8.0 (API 레벨 26) 이상에서만 알림 채널을 생성하도록
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
```  


---
