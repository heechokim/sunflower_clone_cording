package com.example.sunflowerclone.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sunflowerclone.Fragment1
import com.example.sunflowerclone.PlantListFragment

const val MY_GARDEN_PAGE_INDEX = 0
const val PLANT_LIST_PAGE_INDEX = 1

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    // Init map that match fragment to index
    private val fragmentsCreator: Map<Int, () -> Fragment> = mapOf(
        // TODO(Fragment1(), Fragment2()는 임시 프래그먼트므로 제대로된 프래그먼트 생성 후 이름 변경해야)
        MY_GARDEN_PAGE_INDEX to { Fragment1() },
        PLANT_LIST_PAGE_INDEX to { PlantListFragment() }
    )

    override fun getItemCount(): Int {
        return fragmentsCreator.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsCreator[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}