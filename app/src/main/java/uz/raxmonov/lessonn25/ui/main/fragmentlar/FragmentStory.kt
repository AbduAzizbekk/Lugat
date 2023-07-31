package uz.raxmonov.lessonn25.ui.main.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.raxmonov.lessonn25.databinding.FragmentStoryBinding

class FragmentStory : Fragment() {
    private val binding by lazy {
        FragmentStoryBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }
}