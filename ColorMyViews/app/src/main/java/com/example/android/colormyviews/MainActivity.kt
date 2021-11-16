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
    private lateinit var red_button: View;
    private lateinit var green_button: View;
    private lateinit var blue_button: View;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        box_one_text = findViewById<View>(R.id.box_one_text)
        box_two_text = findViewById<View>(R.id.box_two_text)
        box_three_text = findViewById<View>(R.id.box_three_text)
        box_four_text = findViewById<View>(R.id.box_four_text)
        box_five_text = findViewById<View>(R.id.box_five_text)
        red_button = findViewById<View>(R.id.red_button)
        green_button = findViewById<View>(R.id.green_button)
        blue_button = findViewById<View>(R.id.blue_button)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(box_one_text, box_two_text, box_three_text,
            box_four_text, box_five_text, red_button, green_button, blue_button)

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

            R.id.red_button -> box_three_text.setBackgroundResource(R.color.my_red)
            R.id.blue_button -> box_four_text.setBackgroundResource(R.color.my_blue)
            R.id.green_button -> box_five_text.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}