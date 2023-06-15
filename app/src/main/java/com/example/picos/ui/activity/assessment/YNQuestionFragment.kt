package com.example.picos.ui.activity.assessment

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.picos.R
import com.example.picos.databinding.FragmentQuestionBinding
import com.example.picos.databinding.FragmentYNQuestionBinding

class YNQuestionFragment : Fragment(),View.OnClickListener {
    lateinit var binding: FragmentYNQuestionBinding

    lateinit var yNQuestList: ArrayList<YnQuestion>

    private var selectedQuest : Int =  0
    private var currentQuest : Int = 1



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYNQuestionBinding.inflate(layoutInflater)

        yNQuestList = YnQuest.getYnQuestion()

        binding.btnYnNext.setOnClickListener(this)

        setYnQuestion()

        return binding.root
    }

    private fun setYnQuestion() {
        var question: YnQuestion = yNQuestList[currentQuest-1]
        binding.tvYnquestion.text = question.questionYn
        binding.tvYndesc.text = question.descYn
        binding.tvOptOneYn.text = question.optiOneYn
        binding.tvOptTwoYn.text = question.optiTwoYn


    }

    override fun onClick (v: View?) {
    }
}


