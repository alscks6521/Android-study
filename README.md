## 11w
**JSON. Restful Api

## 10w
**Socket 통신**   (양방향 통신)  
단점: 접속자 수가 늘어나면 서버 개수도 늘어나야된다.   

***이를 개선 →***    

**인터넷, HTTP 통신의 등장** (단방향 통신)  
Request, Response의 방식 

---

안드로이드 레이아웃 파일 ( XML ) 규격  
***상향단계 →***   
JSON (JavaScript Object Notation), Map  
  
**JSON: 이름, 값이 쌍으로 이루어짐.**  
( 이름 **/** (문자,숫자, boolean, List[ ], 객체{ }) )   
  
**JSON Object, JSON ARRAY: 어떠한 데이터간의 형식을 맞춰 조합이 가능.**    
 
**JSON Object :** { "이름" : "값", "이름1" : "값1" }   
**JSON ARRAY :** [ {"이름" : "값"}, {"이름1" , "값1"} ] // Json Array 안에 Json Object  

---

**Point :**  
http url 컬렉션을 이용해 안드로이드 http Restful API 통신을 하려면 비동기 통신을 해야됨.     

**기존 :**  
하나의 어플리케이션이 하나의 스레드로 이루어짐. (즉, 메인 스레드가 존재)  
메인스레드는 ui를 담당.    

**기존 문제 :**  
통신 때문에 화면이 멈추는 때가 있었음. (메인스레드에서 통신을 해버리면 응답을 받을때까지 대기하면서 화면이 멈췄음)  

**해결 :**  
멀티스레드를 띄어서 각 통신을 역할 제공.   

----  

**Restful Api ( HTTP, HTTPS 통신 )**  
port ( Request, Response )   
< Header > < Method > < Body >   

**Restful Api에서 사용하는 Retrofit을 많이 사용**(맨 아래 Retrofit 사용예제)  

**이유:**  
* RestApi 통신  
* 기본적으로 받는 정보를 JSON으로 인식
* 가장 쉽게 Data 처리

  
---

**Spring :**
- C 개발자가 사전에 환경을 맞춰줘야됨, 무거움
- P 대용량 서버에 적합    

***하드웨어 성능이 좋아지면서 Spring Boot로 전환하는 추세 →***     

**Spring Boot :**  
- C 대용량 처리가 Spring 보다는 낮음
- P 환경설정이 알아서 맞춰짐, 가벼움
  
**DB 쿼리문과 매우 흡사**  
* Get == select  
* Post == insert  
* Put, Patch == update  
* Delete == delete  

---
    
#### Retrofit 사용 예제
1. Retrofit 라이브러리 gradle에 추가 ( 추가 ...retrofit2:converter-json: 0.0.0 )
2. Permission 추가
3. JSON 형태의 모델 제작 ( DTO )
4. interface 작성 ( 의미: 서버랑 통신 가능한 api들이 있다. 받아올때 쓰는 경로, 어떤 기능을 쓰기 위해 함수를 작성하는데에 이름들 )
5. Retrofit 객체 초기화
6. enquene() 함수 사용으로 (서버의 callback 받기) (onSucess... , onFailed... )





