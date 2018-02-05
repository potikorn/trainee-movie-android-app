package com.example.potikorn.testcoopapp.ui.main.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.potikorn.testcoopapp.R
import com.example.potikorn.testcoopapp.ui.main.home.movie.HomeDetailFragment
import com.example.potikorn.testcoopapp.ui.main.home.tv.HomeSeriesFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance(bundle: Bundle? = null) = HomeFragment().apply {
            val homeFragment = HomeFragment()
            homeFragment.arguments = bundle
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vpHome.adapter = HomeViewPagerAdapter(fragmentManager)
        tabMenu.setupWithViewPager(vpHome)
    }

    inner class HomeViewPagerAdapter(supportFragment: FragmentManager) : FragmentPagerAdapter(supportFragment) {
        override fun getItem(position: Int): Fragment = when (position) {
            0 -> HomeDetailFragment.newInstance()
            else -> HomeSeriesFragment.newInstance()
        }

        override fun getCount(): Int = 2
        override fun getPageTitle(position: Int): CharSequence = when (position) {
            0 -> getString(R.string.title_home)
            else -> getString(R.string.title_series)
        }
    }
}