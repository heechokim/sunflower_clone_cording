package com.example.sunflowerclone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sunflowerclone.adapters.ViewPagerAdapter
import com.example.sunflowerclone.databinding.FragmentViewPagerBinding

class HomeViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate view object
        val binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        // Initialize view objects
        val tabs = binding.tabLayout
        val viewPager = binding.viewPager

        // Set viewPager adapter
        viewPager.adapter = ViewPagerAdapter(this)

        return binding.root
    }
}