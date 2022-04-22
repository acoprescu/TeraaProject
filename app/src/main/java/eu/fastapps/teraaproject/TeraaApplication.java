package eu.fastapps.teraaproject;

import android.app.Application;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.io.IOException;

public class TeraaApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        loadSounds();

    }

    private MediaPlayer mediaPlayers[];
    private void loadSounds() {
        mediaPlayers = new MediaPlayer[2];

        MediaPlayer sound0 = MediaPlayer.create(this, R.raw.record_audio);
        //mediaPlayer.setVolume
        MediaPlayer sound1 = MediaPlayer.create(this, R.raw.nature_sound);

        mediaPlayers[0] = sound0;
        mediaPlayers[1] = sound1;
    }


    /** Plays a sound
     * @param id
     * 0: Record audio
     * 1: Nature Sound
     *
     */
    public void playSound(int id){
        if(id >= 0 && id <= 1 ){
            MediaPlayer mediaPlayer = mediaPlayers[id];

            if (mediaPlayer != null) {
                mediaPlayer.seekTo(0);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

            }
        }
    }

    public void stopSound(){
        for (MediaPlayer mediaPlayer: mediaPlayers) {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
    }

}