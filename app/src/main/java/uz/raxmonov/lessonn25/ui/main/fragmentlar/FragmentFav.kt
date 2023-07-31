package uz.raxmonov.lessonn25.ui.main.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.raxmonov.lessonn25.core.adapter.FavAdapter
import uz.raxmonov.lessonn25.core.db.WordsDb
import uz.raxmonov.lessonn25.databinding.FragmentFavouriteBinding

class FragmentFav : Fragment() {
    private lateinit var adapter: FavAdapter
    private val binding by lazy {
        FragmentFavouriteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cursor = WordsDb.getInstance()!!.getFav()
        adapter = FavAdapter(requireContext(), cursor)
        binding.favList.adapter = adapter
    }
}