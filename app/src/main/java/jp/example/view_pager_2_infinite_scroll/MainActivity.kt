package jp.example.view_pager_2_infinite_scroll

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import jp.example.view_pager_2_infinite_scroll.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val sampleList: List<SampleData> = listOf(
        SampleData(3, "#FF7B7B"), // フェイク用
        SampleData(1, "#91C555"),
        SampleData(2, "#F48E37"),
        SampleData(3, "#FF7B7B"),
        SampleData(1, "#91C555"), // フェイク用
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.infiniteViewPager.adapter = NumberAdapter(this, sampleList)
        binding.infiniteViewPager.currentItem = 1
        binding.infiniteViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (binding.infiniteViewPager.currentItem) {
                        sampleList.size - 1 -> binding.infiniteViewPager.setCurrentItem(1, false)
                        0 -> binding.infiniteViewPager.setCurrentItem(sampleList.size - 2, false)
                    }
                }
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

            }
        })
    }
}

data class SampleData(
    val number: Int,
    val color: String,
)