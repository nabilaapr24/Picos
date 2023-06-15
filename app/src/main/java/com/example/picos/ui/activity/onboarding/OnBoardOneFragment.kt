package com.example.picos.ui.activity.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.picos.R
import com.example.picos.databinding.FragmentOnBoardOneBinding

class OnBoardOneFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardOneBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_on_board_one, container, false)
        binding.btnOb1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_onBoardOneFragment_to_onBoardTwoFragment2)
        }
        return binding.root
    }
}

