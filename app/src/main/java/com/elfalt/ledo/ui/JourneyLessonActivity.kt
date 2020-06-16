package com.elfalt.ledo.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.elfalt.ledo.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_journey_lesson.*

class JourneyLessonActivity : YouTubeBaseActivity(), YouTubePlayer.OnInitializedListener,
    YouTubePlayer.PlaybackEventListener, YouTubePlayer.PlayerStateChangeListener  {

    private val API_KEY  : String = com.elfalt.ledo.BuildConfig.API_KEY
    private val VIDEO_ID : String = "9YlRIvdokMg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journey_lesson)


        videoFrame.initialize(API_KEY,this)

    }

    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {

        p1?.setPlayerStateChangeListener(this)
        p1?.setPlaybackEventListener(this)

        if(!p2){
            p1?.cueVideo(VIDEO_ID)
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        Toast.makeText(this,"Initializations failed", Toast.LENGTH_SHORT).show()
        Log.e("failed", p1.toString())
    }

    override fun onAdStarted() {
        //Toast.makeText(this,"Ad started", Toast.LENGTH_SHORT).show()
    }

    override fun onLoading() {
        Toast.makeText(this,"video loading", Toast.LENGTH_SHORT).show()
    }

    override fun onVideoStarted() {
        //Toast.makeText(this,"video started", Toast.LENGTH_SHORT).show()
    }

    override fun onLoaded(p0: String?) {
        //Toast.makeText(this,"video loaded", Toast.LENGTH_SHORT).show()
    }

    override fun onVideoEnded() {
        //Toast.makeText(this,"video Ended", Toast.LENGTH_SHORT).show()
    }

    override fun onError(p0: YouTubePlayer.ErrorReason?) {
        Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show()
        Log.e("error", p0.toString())
    }

    override fun onSeekTo(p0: Int) {
        Toast.makeText(this, "Seeked to$p0", Toast.LENGTH_SHORT).show()
    }

    override fun onBuffering(p0: Boolean) {
        Toast.makeText(this,"Buffering", Toast.LENGTH_SHORT).show()
    }

    override fun onPlaying() {
        Toast.makeText(this,"video playing", Toast.LENGTH_SHORT).show()
    }

    override fun onStopped() {
        //Toast.makeText(this,"video stopped", Toast.LENGTH_SHORT).show()
    }

    override fun onPaused() {
        //Toast.makeText(this,"video paused", Toast.LENGTH_SHORT).show()
    }

}
