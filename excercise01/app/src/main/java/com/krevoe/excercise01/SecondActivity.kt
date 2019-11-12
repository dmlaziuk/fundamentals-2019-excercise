package com.krevoe.excercise01

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.i("INFO", "SecondActivity.onCreate")

        val textView: TextView = findViewById(R.id.second_activity_text)
        textView.setOnClickListener {
            openBrowser()
        }
    }

    private fun openBrowser() {
        val url = "https://www.tut.by"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
