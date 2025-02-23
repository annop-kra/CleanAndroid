package com.ankn.cleanandroidtemplate.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ankn.cleanandroidtemplate.databinding.FragmentDetailBinding
import com.ankn.cleanandroidtemplate.databinding.FragmentHomeBinding

class DetailFragment : Fragment() {

    // ViewBinding
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textview.text = args.itemTitle
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
