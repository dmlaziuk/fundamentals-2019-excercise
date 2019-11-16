package com.krevoe.excercise

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.krevoe.excercise.adapters.SlideFragmentPagerAdapter
import com.krevoe.excercise.data.Movie

class Gallery : Fragment() {

    companion object {

        private const val ARGS_MOVIE = "ARGS_MOVIE"
        private const val ARGS_POSITION = "ARGS_POSITION"

        fun newInstance(movies: List<Movie>, position: Int): Gallery {
            val fragment = Gallery()
            val bundle = Bundle()

            bundle.run {
                putParcelableArrayList(ARGS_MOVIE, ArrayList(movies))
                putInt(ARGS_POSITION, position)
            }

            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.gallery, container, false)
        val position = arguments?.getInt(ARGS_POSITION) ?:0
        val movies = arguments?.getParcelableArrayList<Movie>(ARGS_MOVIE)
            ?: throw IllegalArgumentException("Missing movie argument")

        view.findViewById<ViewPager>(R.id.vp_pager).run {
            adapter = SlideFragmentPagerAdapter(childFragmentManager, movies)
            currentItem = position
        }

        return view
    }
}
