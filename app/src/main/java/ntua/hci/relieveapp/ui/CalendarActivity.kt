package ntua.hci.relieveapp.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import ntua.hci.relieveapp.MainActivity
import ntua.hci.relieveapp.R
import java.util.*


class CalendarActivity : AppCompatActivity()  {

    var btnDatePicker: Button? = null
    var txtDate: EditText? = null
    private var mYear = 0
    private var mMonth = 0
    private var mDay = 0
    var mycalendar: CalendarView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var database = FirebaseDatabase.getInstance().reference

        var event_name: TextInputLayout? = null
        var btnAdd: Button? = null

        mycalendar = findViewById(R.id.calendarView) as CalendarView?

        setContentView(R.layout.activity_calendar)
        supportActionBar!!.setTitle("Calendar")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        btnDatePicker = findViewById(R.id.btn_date) as Button?
        val todaysEvents: TextView = findViewById(R.id.todays_events1) as TextView

        txtDate = findViewById(R.id.in_date) as EditText?
        btnAdd = findViewById(R.id.btn_add) as Button?
        event_name = findViewById(R.id.event_name) as TextInputLayout?




        btnDatePicker!!.setOnClickListener {
            // your code to perform when the user clicks on the button
            val c = Calendar.getInstance()
            mYear = c[Calendar.YEAR]
            mMonth = c[Calendar.MONTH]
            mDay = c[Calendar.DAY_OF_MONTH]
            Toast.makeText(this, "You clicked me.", Toast.LENGTH_SHORT).show()
            val datePickerDialog = DatePickerDialog(this,
                    DatePickerDialog.OnDateSetListener {view, year, monthOfYear, dayOfMonth -> txtDate!!.setText(dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year) }, mYear, mMonth, mDay)
            datePickerDialog.show()

        }

        btnAdd!!.setOnClickListener {
            val eventName = event_name?.editText!!.text.toString()
            val eventDate: String = txtDate!!.getText().toString()
            val calendarHelper = CalendarHelper(eventDate)
            database!!.child(eventName.toString()).setValue(calendarHelper)
        }

        var getdata = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            override fun onDataChange(snapshot: DataSnapshot) {

               /* val myCalendar = Calendar.getInstance()

                mycalendar!!.setOnDateChangeListener { view, year, month, dayOfMonth ->
                    // set the calendar date as calendar view selected date
                    myCalendar.set(year, month, dayOfMonth)
                    val dateString = (dayOfMonth.toString() + "-" + (month + 1) + "-" + year)
                }*/
                var sb = StringBuilder()
                for (i in snapshot.children) {
                    //var eventName1 = i.child("eventName").getValue()
                    var eventDate1 = i.child("eventDate").getValue()
                    sb.append("${i.key} $eventDate1\n")
                }
                todaysEvents.setText(sb)
            }
        }
        database!!.addValueEventListener(getdata)
        database!!.addListenerForSingleValueEvent(getdata)

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val myIntent = Intent(applicationContext, MainActivity::class.java)
        startActivityForResult(myIntent, 0)
        return true
    }

    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }*/



}