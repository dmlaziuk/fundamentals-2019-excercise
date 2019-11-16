package com.krevoe.excercise

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.krevoe.excercise.data.Movie

class GalleryItem : Fragment() {

    companion object {
        private const val ARGS_MOVIE = "ARGS_MOVIE"

        fun newInstance(movie: Movie): GalleryItem {
            val fragment = GalleryItem()
            val bundle = Bundle()

            bundle.putParcelable(ARGS_MOVIE, movie)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.gallery_item, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Movie>(ARGS_MOVIE)?.run {
            view.findViewById<ImageView>(R.id.banner_image).setImageResource(backdropRes)
            view.findViewById<ImageView>(R.id.thumbnail_image).setImageResource(posterRes)
            view.findViewById<TextView>(R.id.film_title_text).text = title
            view.findViewById<TextView>(R.id.release_date_text).text = releaseDate
            view.findViewById<TextView>(R.id.overview_text).text = overview

            val movieButton: Button = view.findViewById(R.id.show_trailer_button)
            movieButton.setOnClickListener {
                openMovieTrailer(trailerUrl)
            }
        }
    }

    private fun openMovieTrailer(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
