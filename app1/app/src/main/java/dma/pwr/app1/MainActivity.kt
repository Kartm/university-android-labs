package dma.pwr.app1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent1 = Intent(this, MainActivity2::class.java)
        val button1 = findViewById<Button>(R.id.button)

        button1.setOnClickListener(View.OnClickListener {
            startActivity(intent1)
        })

        val intent3 = Intent(this, MainActivity3::class.java);
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener(View.OnClickListener {
            startActivity(intent3)
        })
    }

    fun openSecond(view: View) {
        val intent2 = Intent(this, MainActivity2::class.java);
        startActivity(intent2)
    }
}