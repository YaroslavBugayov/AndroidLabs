package com.bugayov.labs.lab4

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import com.bugayov.labs.R


class AudioFragment : Fragment() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inf = inflater.inflate(R.layout.fragment_audio, container, false)
        val buttonPlay = inf.findViewById<ImageButton>(R.id.buttonPlay)
        val buttonStop = inf.findViewById<ImageButton>(R.id.buttonStop)

        buttonPlay.setOnClickListener {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(context, R.raw.sexyback)
                mediaPlayer!!.isLooping = true
                mediaPlayer!!.start()
                buttonPlay.setImageResource(R.drawable.pause)
            } else {
                if (mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.pause()
                    buttonPlay.setImageResource(R.drawable.play)
                } else {
                    mediaPlayer!!.start()
                    buttonPlay.setImageResource(R.drawable.pause)
                }
            }
        }

        buttonStop.setOnClickListener {
            if (mediaPlayer != null) {
                mediaPlayer!!.stop()
                mediaPlayer = null
                buttonPlay.setImageResource(R.drawable.play)
            }
        }

        return inf
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer!!.stop()
            mediaPlayer = null
        }
    }
}