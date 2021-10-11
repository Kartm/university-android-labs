package dma.pwr.app1

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val window2 = findViewById<View>(R.id.window2)
        window2.setOnLongClickListener(View.OnLongClickListener {
            finish()
            return@OnLongClickListener false
        })
    }
}