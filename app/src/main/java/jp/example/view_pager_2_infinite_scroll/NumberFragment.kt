package jp.example.view_pager_2_infinite_scroll

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import jp.example.view_pager_2_infinite_scroll.databinding.FragmentNumberBinding

class NumberFragment: Fragment() {

    private lateinit var binding: FragmentNumberBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_number, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sampleData = arguments?.getSerializable(SAMPLE_DATA) as? SampleData
        binding.numberTextView.text = sampleData?.number.toString()
        binding.constraintLayout.setBackgroundColor(Color.parseColor(sampleData?.color ?: return))
    }

    companion object {
        private const val SAMPLE_DATA = "sample_data"

        fun newInstance(sampleData: SampleData): NumberFragment {
            return NumberFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(SAMPLE_DATA, sampleData)
                }
            }
        }
    }
}