package com.fox.toolsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fox.toolsapp.databinding.ActivityToolCategoryBinding
import com.fox.toolsapp.databinding.ActivityToolDetailBinding

class ToolDetailActivity : AppCompatActivity() {
    private var _binding: ActivityToolDetailBinding? = null
    private val binding get() = _binding?: throw RuntimeException("ActivityToolDetailBinding = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityToolDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        if (intent.hasExtra("title") && intent.hasExtra("info") && intent.hasExtra("resId")) {
            binding.textViewTitle.text = intent.getStringExtra("title")
            binding.textViewInfo.text = intent.getStringExtra("info")
            val resId = intent.getIntExtra("resId", -1)
            binding.imageViewDrill.setImageResource(resId)
        } else {
            val backToCategory = Intent(this, ToolCategoryActivity::class.java)
            startActivity(backToCategory)
        }
    }



    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}