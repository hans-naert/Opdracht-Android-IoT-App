package com.example.opdrachtandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.opdrachtandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView1.setOnClickListener(){
            binding.imageView1.setImageResource(R.drawable.hans_naert)
        }

        binding.imageView2.setOnClickListener(){
            binding.imageView2.setImageResource(R.drawable.hans_naert)
        }

        binding.imageView3.setOnClickListener(){
            binding.imageView3.setImageResource(R.drawable.hans_naert)
        }

        binding.imageView4.setOnClickListener(){
            binding.imageView4.setImageResource(R.drawable.hans_naert)
        }

    }
}