package jp.example.view_pager_2_infinite_scroll

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

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