package com.krevoe.excercise.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.krevoe.excercise.GalleryItem
import com.krevoe.excercise.data.Movie

class SlideFragmentPagerAdapter(
    fragmentManager: FragmentManager,
    private val movieList: List<Movie>
) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment? {
        val movie = when {
            movieList.isNotEmpty() && position <= count - 1 -> movieList[position]
            else -> null
        }

        return movie?.run { GalleryItem.newInstance(this) }
    }

    override fun getCount(): Int {
        return movieList.size
    }
}
