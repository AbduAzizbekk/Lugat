package uz.raxmonov.lessonn25.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import uz.raxmonov.lessonn25.R
import uz.raxmonov.lessonn25.core.adapter.WordsAdapter
import uz.raxmonov.lessonn25.core.db.WordsDb
import uz.raxmonov.lessonn25.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: WordsAdapter
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.menuNavigation.setupWithNavController(findNavController(R.id.navig))
        val cursor = WordsDb.getInstance()!!.getUzbEng()
        adapter = WordsAdapter(this, cursor)
        binding.dictionary.adapter = adapter

        binding.change.setOnClickListener {
            count++
            if (count % 2 == 0) {
                binding.change.text = "Uzb Eng"
                val cursor = WordsDb.getInstance()!!.getUzbEng()
                adapter.changeCursor(cursor)
                adapter = WordsAdapter(this, cursor)
                binding.dictionary.adapter = adapter

            } else {
                binding.change.text = "Eng Uzb"
                val cursor = WordsDb.getInstance()!!.getEngUzb()
                adapter.changeCursor(cursor)
                adapter = WordsAdapter(this, cursor)
                binding.dictionary.adapter = adapter
            }
        }
    }
}