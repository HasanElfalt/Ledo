package com.elfalt.ledo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_journey_lesson.*

class JourneyLessonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_lesson)

        val videoPath : String = "android.resource://$packageName/${R.raw.americans_are_specific}"
        val uri = Uri.parse(videoPath)
        video.setVideoURI(uri)

        val medianController = MediaController(this)
        video.setMediaController(medianController)
        medianController.setAnchorView(video)

        video.requestFocus()
        video.start()

        Toast.makeText(this,"Duration is ${video.duration}, ${R.raw.americans_are_specific}",Toast.LENGTH_SHORT).show()
    }
}
