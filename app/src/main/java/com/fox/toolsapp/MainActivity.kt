package com.fox.toolsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.fox.toolsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding:ActivityMainBinding? = null
    private val binding get() = _binding?: throw RuntimeException("ActivityMainBinding = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.listViewTools.setOnItemClickListener { parent, view, position, id ->
            when(position) {
                0 -> {val intent = Intent(this, ToolCategoryActivity::class.java)
                    startActivity(intent)
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}