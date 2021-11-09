package dma.pwr.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = createCardAdapter()
    }

    private fun createCardAdapter(): ViewPagerAdapter? {
        return ViewPagerAdapter(this)
    }
}