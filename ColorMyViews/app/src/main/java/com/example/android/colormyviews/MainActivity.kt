package com.example.android.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var box_one_text: View;
    private lateinit var box_two_text: View;
    private lateinit var box_three_text: View;
    private lateinit var box_four_text: View;
    private lateinit var box_five_text: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        box_one_text = findViewById<View>(R.id.box_one_text)
        box_two_text = findViewById<View>(R.id.box_two_text)
        box_three_text = findViewById<View>(R.id.box_three_text)
        box_four_text = findViewById<View>(R.id.box_four_text)
        box_five_text = findViewById<View>(R.id.box_five_text)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text, box_four_text, box_five_text)

        for(item in clickableViews) {
            item.setOnClickListener {makeColored(it)}
        }
    }

    private fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}