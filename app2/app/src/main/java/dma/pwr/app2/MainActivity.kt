package dma.pwr.app2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listview);
        val valuesArray = arrayOf(
            DataEntry("Anthony", "Jackson"),
            DataEntry("Harold", "Aiello"),
            DataEntry("Donald", "Adams"),
            DataEntry("Lori", "Bartlett"),
            DataEntry("Ernest", "Harrison"),
            DataEntry("James", "Tillis"),
            DataEntry("James", "Wilson"),
            DataEntry("Joe", "Moss"),
            DataEntry("Tracy", "Stone"),
            DataEntry("Rosa", "Edgar"),
            DataEntry("Earl", "Mayo"),
            DataEntry("Jan", "Gilman"),
            DataEntry("Donald", "Jackson"),
            DataEntry("Christian", "Towle"),
            DataEntry("Gerda", "Cavanaugh"),
            DataEntry("Cheryl", "Greene"),
            DataEntry("James", "Davis"),

        )

        val valuesList = ArrayList<String>()
        for (element in valuesArray) {
            // converts complex data to a single string
            valuesList.add("${element.firstName} ${element.lastName}")
        }

        val adapter = MyArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, valuesList
        )

        listView.adapter = adapter
    }

    private class DataEntry(firstName: String, lastName: String) {
        val firstName: String = firstName;
        val lastName: String = lastName;
    }

    private class MyArrayAdapter(
        context: Context, textViewResourceId: Int,
        objects: List<String?>
    ) : ArrayAdapter<String?>(context, textViewResourceId, objects) {
        var idsHashMap = HashMap<String?, Long>()

        // generate item ids
        init {
            for (i in objects.indices) {
                idsHashMap[objects[i]] = i.toLong();
            }
        }

        // will ids stay the same if we update the list of items?
        // yes, because we generate it in init{}
        override fun hasStableIds(): Boolean {
            return true
        }

        override fun getItemId(position: Int): Long {
            val item = getItem(position)
            return idsHashMap[item]!!;
        }
    }
}