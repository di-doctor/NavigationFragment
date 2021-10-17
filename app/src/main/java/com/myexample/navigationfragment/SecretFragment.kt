package com.myexample.navigationfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myexample.navigationfragment.databinding.FragmentSecretBinding

class SecretFragment : Fragment(R.layout.fragment_secret) {
    private lateinit var binding: FragmentSecretBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecretBinding.bind(view)
        binding.closeSecret.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
            findNavController().navigateUp()
        }
        binding.closeWhole.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}