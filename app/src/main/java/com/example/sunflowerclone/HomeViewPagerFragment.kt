package com.example.sunflowerclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.sunflowerclone.adapters.MY_GARDEN_PAGE_INDEX
import com.example.sunflowerclone.adapters.PLANT_LIST_PAGE_INDEX
import com.example.sunflowerclone.adapters.ViewPagerAdapter
import com.example.sunflowerclone.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_view_pager.view.*

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view object
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize view objects
        val tabLayout = view.tab_layout
        val viewPager = view.view_pager

        // Set viewPager adapter
        viewPager.adapter = ViewPagerAdapter(this)

        // Set the icon and text for each tab
        TabLayoutMediator(tabLayout, viewPager) { tab: TabLayout.Tab, position: Int ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        // Set activity's action bar
        (activity as AppCompatActivity).setSupportActionBar(view.material_toolbar)
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> R.drawable.selector_my_garden_tab
            PLANT_LIST_PAGE_INDEX -> R.drawable.selector_plant_list_tab
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            MY_GARDEN_PAGE_INDEX -> getString(R.string.title_my_garden_page)
            PLANT_LIST_PAGE_INDEX -> getString(R.string.title_plant_list_page)
            else -> throw IndexOutOfBoundsException()
        }
    }
}