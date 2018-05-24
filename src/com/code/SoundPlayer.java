package com.code;



import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

class SoundPlayer {

    SoundPlayer(String path) {
        InputStream inputStream;
        try {
            inputStream = getClass().getResourceAsStream(path);
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        } catch (Exception ex) {
            Logger.getLogger(KeyBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}