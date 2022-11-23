package jp.example.view_pager_2_infinite_scroll

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import jp.example.view_pager_2_infinite_scroll.databinding.AdapterNumberBinding

class NumberAdapterForFragment(
    fragment: FragmentActivity,
    private val originalList: List<SampleData>,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return originalList.size
    }

    override fun createFragment(position: Int): Fragment {
        return NumberFragment.newInstance(originalList[position])
    }

}