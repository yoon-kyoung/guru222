package com.example.myapplication

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MemoryReg:AppCompatActivity() {

    lateinit var dbManager: DBManager
    lateinit var sqlitedb:SQLiteDatabase

    lateinit var regbtn:androidx.appcompat.widget.AppCompatButton
    lateinit var edtSubject:EditText
    lateinit var edtNation:EditText
    lateinit var edtFriend:EditText
    lateinit var edtRecord:EditText

    lateinit var calendarView: CalendarView
    lateinit var startDateTextView: TextView

    //lateinit var endDateTextView: TextView

    // 선택된 시작 날짜와 종료 날짜를 저장하는 변수
    //var startDate: String? = null
    //var endDate: String? = null
    //var date: String = "" // 빈 문자열로 초기화

    private var selectedButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tripmemory)

        val buttonMT10 = findViewById<Button>(R.id.mt10)
        val buttonMT11 = findViewById<Button>(R.id.mt11)
        val buttonMT12 = findViewById<Button>(R.id.mt12)
        val buttonMT13 = findViewById<Button>(R.id.mt13)
        val buttonMT14 = findViewById<Button>(R.id.mt14)
        // 새로운 버튼 클릭 이벤트 처리 코드
        val buttons = listOf(buttonMT10, buttonMT11, buttonMT12, buttonMT13, buttonMT14)
        buttons.forEach { button ->
            button.setOnClickListener { onMemoryButtonClick(button) }
        }


        regbtn=findViewById(R.id.mtbtn1)
        edtSubject=findViewById(R.id.mt3)
        edtNation=findViewById(R.id.mt5)
        edtFriend=findViewById(R.id.mt8)
        edtRecord=findViewById(R.id.mt15)

        calendarView = findViewById(R.id.calendarView)
        startDateTextView = findViewById(R.id.startDateTextView)
        //endDateTextView = findViewById(R.id.endDateTextView)
        // 시작 날짜와 종료 날짜 텍스트뷰 초기 설정
        startDateTextView.text = "YYYY.MM.DD"
        //endDateTextView.text = " YYYY.MM.DD"


        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            //val selectedDate = "$year.${month + 1}.$dayOfMonth"
            //startDateTextView.text = selectedDate
            startDateTextView.text ="$year.${month + 1}.$dayOfMonth"
            /*if (startDate == null || endDate != null) {
                // 시작 날짜를 선택한 경우 또는 시작 날짜와 종료 날짜 모두 선택한 경우
                startDate = selectedDate
                endDate = null // 종료 날짜 초기화
                startDateTextView.text = "     $startDate    ~"
                endDateTextView.text = " YYYY.MM.DD"
                date = "$startDate ~ $endDate"
            } else {
                // 종료 날짜를 선택한 경우
                endDate = selectedDate
                endDateTextView.text = " $endDate"
                date = "$startDate ~ $endDate"
            }*/
        }


        dbManager= DBManager(this,"memoryDB",null,1)

        regbtn.setOnClickListener{
            var str_subject:String=edtSubject.text.toString()
            var str_nation:String=edtNation.text.toString()
            var str_friend:String=edtFriend.text.toString()
            var str_record:String=edtRecord.text.toString()
            var str_startdate:String=startDateTextView.text.toString()
            str_startdate = str_startdate.replace(".", "-")
            //var str_enddate:String=endDateTextView.text.toString()

            // 색 정보도 DB에 저장
            val selectedColor = if (selectedButton?.isSelected == true) {
                Color.parseColor("#F3F7DE") // 연두색
            } else {
                Color.parseColor("#F4F4F4") // 회색
            }

            //subject와 color를 memory_color 테이블에 저장 //setlected color 확이ㄴ하기
            //sqlitedb.execSQL("INSERT INTO memory_color VALUES ('$str_subject', $selectedColor)")
            //sqlitedb.execSQL("INSERT OR REPLACE INTO memory_color VALUES ('$str_subject', $selectedColor)")


            sqlitedb=dbManager.writableDatabase
            //sqlitedb.execSQL("INSERT INTO memory VALUES('"+str_subject+"','"+str_nation+"','"+str_friend+"','"+str_record+"')")
            sqlitedb.execSQL("INSERT INTO memory VALUES('"+str_subject+"','"+str_nation+"','"+str_friend+"','"+str_record+"','"+str_startdate+"')")
            // 로그로 확인
            //Log.d("MemoryReg", "Inserted data: $str_subject, $str_nation, $str_friend, $str_record, $str_startdate")
            //sqlitedb.execSQL("INSERT INTO memory VALUES('"+str_subject+"','"+str_nation+"','"+str_friend+"','"+str_record+"')")
            //sqlitedb.execSQL("INSERT INTO memory VALUES('"+str_subject+"','"+str_nation+"','"+str_friend+"','"+str_record+"','"+str_startdate+"','"+str_enddate+"')")
            sqlitedb.close()

            val intent= Intent(this,MemoryInfo::class.java)
            intent.putExtra("intent_subject",str_subject)
            startActivity(intent)
        }
    }

    private fun onMemoryButtonClick(button: Button) {
        if (selectedButton == button) {
            // 같은 버튼을 누르면 선택 해제
            selectedButton?.isSelected = false
            selectedButton?.setBackgroundColor(Color.parseColor("#F4F4F4"))
            selectedButton = findViewById<Button>(R.id.mt14) // 빈 버튼으로 초기화
        } else {
            // 이전에 선택된 버튼은 선택 해제
            selectedButton?.isSelected = false
            selectedButton?.setBackgroundColor(Color.parseColor("#F4F4F4"))

            // 새로운 버튼을 선택
            selectedButton = button
            selectedButton?.isSelected = true
            selectedButton?.setBackgroundColor(Color.parseColor("#F3F7DE"))
        }
    }
}
