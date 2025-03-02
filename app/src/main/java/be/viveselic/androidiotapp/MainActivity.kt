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
    }
}