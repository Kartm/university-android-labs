package dma.pwr.app1

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity3 : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
    }

    fun goBackTo1(view: View) {
        onBackPressed()
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(applicationContext, "Activity 3 - stopped", Toast.LENGTH_SHORT).show()
    }
}