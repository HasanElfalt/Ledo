package com.elfalt.ledo

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_journey_lesson.*

class JourneyLessonActivity : AppCompatActivity() {

    private var playBackPosition = 0
    private val videoPath : String = "android.resource://com.elfalt.ledo/${R.raw.kuka}"
    private lateinit var mediaController : MediaController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_lesson)


        video.setOnPreparedListener {
            mediaController.setAnchorView(video)
            video.setMediaController(mediaController)

            video.seekTo(playBackPosition)
            video.start()
        }
        
        video.setOnInfoListener { _, what, _ ->
            if(what == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START)
            progressBar.visibility = View.INVISIBLE
            true
        }

        //Toast.makeText(this,"Duration is ${video.duration}, ${R.raw.kuka}",Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()

        mediaController = MediaController(this)
        val uri = Uri.parse(videoPath)
        video.setVideoURI(uri)
        
        progressBar.visibility = View.VISIBLE
    }

    override fun onPause() {
        super.onPause()

        video.pause()
        playBackPosition = video.currentPosition
    }

    override fun onStop() {
        video.stopPlayback()
        super.onStop()
    }
}
