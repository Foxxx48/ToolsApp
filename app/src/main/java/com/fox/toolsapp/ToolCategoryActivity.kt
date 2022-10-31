package com.fox.toolsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.fox.toolsapp.databinding.ActivityMainBinding
import com.fox.toolsapp.databinding.ActivityToolCategoryBinding

class ToolCategoryActivity : AppCompatActivity() {
    private var _binding: ActivityToolCategoryBinding? = null
    private val binding get() = _binding?: throw RuntimeException("ActivityToolCategoryBinding = null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityToolCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val drills = arrayListOf<Drill>()

        drills.add(Drill(getString(R.string.drill_dewalt_title), getString(R.string.drill_dewalt_info), R.drawable.dewalt))
        drills.add(Drill(getString(R.string.drill_interskol_title), getString(R.string.drill_interskol_info), R.drawable.interskol))
        drills.add(Drill(getString(R.string.drill_makita_title), getString(R.string.drill_makita_info), R.drawable.makita))

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, drills)
        binding.listViewDrills.adapter = adapter


        binding.listViewDrills.setOnItemClickListener { parent, view, position, id ->
            val drill = drills[position]
            val intent = Intent(this, ToolDetailActivity::class.java).apply {
                putExtra("title", drill.title)
                putExtra("info", drill.info)
                putExtra("resId", drill.imageResourceId)
                myLog("Title ${drill.title} Info ${drill.info} resId ${drill.imageResourceId}")
            }
            startActivity(intent)
        }


    }

    fun myLog(message: String) {
        Log.d(TAG, "ToolCategoryActivity $message")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val TAG = "myApp"
    }
}