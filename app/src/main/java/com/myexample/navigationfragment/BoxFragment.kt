package com.myexample.navigationfragment

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.myexample.navigationfragment.databinding.FragmentBoxBinding
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random

class BoxFragment:Fragment(R.layout.fragment_box) {
    private lateinit var binding: FragmentBoxBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBoxBinding.bind(view)
        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(ResourcesCompat.getColor(resources,color,null))

        binding.goBackButton.setOnClickListener{
            findNavController().popBackStack()
        }
        binding.openSecret.setOnClickListener{
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
        binding.generateNumber.setOnClickListener{
            val number = Random.nextInt(100)
            parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(EXTRA_RANDOM_NUMBER to number))
            findNavController().popBackStack()
        }
    }

    companion object{
        const val ARG_COLOR = "color"
        const val REQUEST_CODE = "RC"
        const val EXTRA_RANDOM_NUMBER = "E_R_N"
    }
}