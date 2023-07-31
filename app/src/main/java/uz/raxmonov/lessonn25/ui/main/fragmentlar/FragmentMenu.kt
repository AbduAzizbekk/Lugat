package uz.raxmonov.lessonn25.ui.main.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.raxmonov.lessonn25.core.adapter.WordsAdapter
import uz.raxmonov.lessonn25.core.db.WordsDb
import uz.raxmonov.lessonn25.databinding.FragmentMenuBinding

class FragmentMenu : Fragment() {
    private val binding by lazy {
        FragmentMenuBinding.inflate(layoutInflater)
    }

    private lateinit var adapter: WordsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cursor = WordsDb.getInstance()!!.getEngUzb()
        adapter = WordsAdapter(requireContext(), cursor)
        binding.menuList.adapter = adapter

    }

}