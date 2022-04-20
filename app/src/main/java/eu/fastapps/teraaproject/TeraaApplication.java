package eu.fastapps.teraaproject;

import android.app.Application;
import android.media.MediaPlayer;

public class TeraaApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        //SettingsLoader settingsLoader = AndroidSettingsLoader(this)
        //settings = Settings(settingsLoader)

        loadSounds();



//        if (mediaPlayers[0] != null) {
//            mediaPlayers[0].seekTo(0);
//            mediaPlayers[0].setLooping(true);
//            mediaPlayers[0].start();
//        }

    }

    MediaPlayer mediaPlayers[];
    private void loadSounds() {
        mediaPlayers = new MediaPlayer[2];

        MediaPlayer sound0 = MediaPlayer.create(this, R.raw.nature_sound);
        //mediaPlayer.setVolume
        mediaPlayers[0] = sound0;

    }
}