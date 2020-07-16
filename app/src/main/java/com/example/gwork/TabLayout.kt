package com.example.gwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.example.gwork.databinding.ActivityTabLayoutBinding
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_tab_layout.*

class TabLayout : AppCompatActivity() {
    private lateinit var binding: ActivityTabLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = PageAdapter(supportFragmentManager)
        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(FavouritesFragment(), "Favourites")
        adapter.addFragment(HistoryFragment(), "History")
        viewPager.adapter = adapter
        tabLayout2.setupWithViewPager(viewPager)
        setTabIcons()
    }

    private fun setTabIcons() {
        tabLayout2.getTabAt(0)?.setIcon(R.drawable.ic_baseline_home_24)
        tabLayout2.getTabAt(1)?.setIcon(R.drawable.ic_baseline_favorite_24)
        tabLayout2.getTabAt(2)?.setIcon(R.drawable.ic_baseline_history_24)

        // Get badge from tab (or create one if none exists)
        val badge = tabLayout2.getTabAt(2)?.orCreateBadge
        // Customize badge
        badge?.number = 6
    }
}