package com.myexample.navigationfragment

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.findNavController
import com.myexample.navigationfragment.databinding.FragmentRootBinding

class RootFragment: Fragment(R.layout.fragment_root) {
    private lateinit var binding: FragmentRootBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRootBinding.bind(view)
        binding.openGreeboxbutton.setOnClickListener{
            openBox(R.color.Green)
        }
        binding.openYellowBoxButton.setOnClickListener{
            openBox(R.color.Yellow)
        }
        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE,viewLifecycleOwner)
            { _, data ->
                val value = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
                Toast.makeText(requireContext(), "Generated number $value", Toast.LENGTH_LONG)
                    .show()
            }
    }
    private fun openBox(color: Int){
        findNavController().navigate(R.id.action_rootFragment_to_boxFragment
            , bundleOf(BoxFragment.ARG_COLOR to color))
    }

}