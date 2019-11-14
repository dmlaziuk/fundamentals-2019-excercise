package com.krevoe.excercise

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import com.krevoe.excercise.data.Movie

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val movie = intent?.getParcelableExtra<Movie>(ARGS_MOVIE)
            ?: throw IllegalArgumentException("Missing movie argument")

        findViewById<ImageView>(R.id.banner_image).setImageResource(movie.backdropRes)
        findViewById<ImageView>(R.id.thumbnail_image).setImageResource(movie.posterRes)
        findViewById<TextView>(R.id.film_title_text).text = movie.title
        findViewById<TextView>(R.id.release_date_text).text = movie.releaseDate
        findViewById<TextView>(R.id.overview_text).text = movie.overview

        val movieButton: Button = findViewById(R.id.show_trailer_button)
        movieButton.setOnClickListener {
            openMovieTrailer(movie.trailerUrl)
        }
    }

    private fun openMovieTrailer(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    companion object {

        private const val ARGS_MOVIE = "ARGS_MOVIE"

        fun createIntent(context: Context, movie: Movie): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(ARGS_MOVIE, movie)
            return intent
        }
    }
}
