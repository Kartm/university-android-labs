package dma.pwr.app2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview = findViewById<ListView>(R.id.listview);
        val values = arrayOf(
            "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
            "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
            "Android", "iPhone", "WindowsMobile"
        )

        val list = ArrayList<String>()
        for (element in values) {
            list.add(element)
        }
        val adapter = StableArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, list
        )
        listview.adapter = adapter

        listview.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position) as String
                view.animate().setDuration(2000).alpha(0F)
                    .withEndAction {
                        list.remove(item)
                        adapter.notifyDataSetChanged()
                        view.alpha = 1F
                    }
            }
    }

    private class StableArrayAdapter(
        context: Context, textViewResourceId: Int,
        objects: List<String?>
    ) : ArrayAdapter<String?>(context, textViewResourceId, objects) {
        var mIdMap = HashMap<String?, Int>()
        override fun getItemId(position: Int): Long {
            val item = getItem(position)
            return mIdMap[item]!!.toLong();
        }

        override fun hasStableIds(): Boolean {
            return true
        }

        init {
            for (i in objects.indices) {
                mIdMap[objects[i]] = i
            }
        }
    }
}