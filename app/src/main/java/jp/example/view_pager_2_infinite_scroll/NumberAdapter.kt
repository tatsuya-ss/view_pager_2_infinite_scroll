package jp.example.view_pager_2_infinite_scroll

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.example.view_pager_2_infinite_scroll.databinding.AdapterNumberBinding

class NumberAdapter(
    private val context: Context,
    private val originalList: List<SampleData>
) : RecyclerView.Adapter<NumberAdapter.NumberViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = AdapterNumberBinding.inflate(layoutInflater, parent, false)
        return NumberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NumberViewHolder, position: Int) {
        holder.setData(originalList[position])
    }

    override fun getItemCount(): Int {
        return originalList.size
    }

    class NumberViewHolder(
        private val binding: AdapterNumberBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun setData(sampleData: SampleData) {
            binding.numberText.text = sampleData.number.toString()
            binding.constraintLayout.setBackgroundColor(Color.parseColor(sampleData.color))
        }
    }
}