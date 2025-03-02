package be.viveselic.androidiotapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            if (imageView.tag == "lamp") {
                imageView.tag = "lampoff"
                imageView.setImageResource(R.drawable.lampoff)
            } else {
                imageView.tag = "lamp"
                imageView.setImageResource(R.drawable.lamp)
            }
        }

        val textView = findViewById<TextView>(R.id.textView)

        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOf("Lamp 1", "Lamp 2", "Lamp 3"))
        listView.setOnItemClickListener { _, _, position, _ ->
            textView.text = "You clicked on ${listView.getItemAtPosition(position)}"
        }

        val listViewImage = findViewById<ListView>(R.id.listViewImage)

        data class ListItem(var imageResId: Int, val text: String)

        val listItems = mutableListOf(
            ListItem(R.drawable.lamp, "Lamp 1"),
            ListItem(R.drawable.lampoff, "Lamp 2"),
            ListItem(R.drawable.lamp, "Lamp 3")
        )

        listViewImage.adapter = object : ArrayAdapter<ListItem>(this, android.R.layout.simple_list_item_1, listItems) {
            override fun getView(position: Int, convertView: android.view.View?, parent: android.view.ViewGroup): android.view.View {
                val view = convertView ?: layoutInflater.inflate(R.layout.list_item, parent, false)
                val listItem = getItem(position)!!

                val imageView = view.findViewById<ImageView>(R.id.item_image)
                val textView = view.findViewById<TextView>(R.id.item_text)

                val item = listItems[position]
                imageView.setImageResource(item.imageResId)
                textView.text = item.text
                return view
            }
        }

        listViewImage.setOnItemClickListener { _, view, position, _ ->
            val imageView = view.findViewById<ImageView>(R.id.item_image)

            val item = listItems[position]
            item.imageResId = if (item.imageResId == R.drawable.lamp) {
                R.drawable.lampoff
            } else {
                R.drawable.lamp
            }
            imageView.setImageResource(item.imageResId)

        }



    }
}