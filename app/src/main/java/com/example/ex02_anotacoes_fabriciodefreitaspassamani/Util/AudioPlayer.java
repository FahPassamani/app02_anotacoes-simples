package com.example.ex02_anotacoes_fabriciodefreitaspassamani.Util;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    public static MediaPlayer mediaPlayer;


    public static void playAudio(Context contexto, int resId){
        try
        {
            mediaPlayer = MediaPlayer.create(contexto, resId );
        } catch (Exception e){

        } finally {
            if(mediaPlayer != null){
                mediaPlayer.start();
            }
        }
    }

    public static void stopAudio(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
}
