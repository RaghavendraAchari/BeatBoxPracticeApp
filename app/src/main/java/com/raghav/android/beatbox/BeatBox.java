package com.raghav.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vighnesh on 14-08-2018.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUND_FOLDER = "sample_sounds";
    private List<Sound> mSoundList = new ArrayList<>();
    private AssetManager mAssets;

    private static  final int MAX_SOUNDS = 3;

    private SoundPool mSoundPool;


    public List<Sound> getSoundList() {
        return mSoundList;
    }


    //assetMannager to access asets...present in Context

    public BeatBox(Context context){
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC,0);
        loadSounds();
    }

    private void loadSounds(){
        String[] sounds;
        try{
            sounds = mAssets.list(SOUND_FOLDER);
            Log.i(TAG,"Found "+sounds.length+" sounds");
        }catch (IOException e){
            Log.e(TAG,"Could not load assets",e);
            return;
        }

        for (String fileName : sounds){
            try {
                String assetPath = SOUND_FOLDER + "/" + fileName;
                Sound mSound = new Sound(assetPath);
                load(mSound);
                mSoundList.add(mSound);
            }catch (IOException e){
                Log.e(TAG,"Could not load Sound "+fileName,e);
            }
        }


    }

    public void play(Sound sound){
        Integer soundId = sound.getSoundId();
        if(soundId == null ){
            return;
        }
        mSoundPool.play(soundId,1.0f,1.0f,1,0,1.0f);
    }

    private void load(Sound sound)throws IOException{
        AssetFileDescriptor afd = mAssets.openFd(sound.getAssetPath());
        int soundId = mSoundPool.load(afd,1);
        sound.setSoundId(soundId);


    }

    public void release() {
        mSoundPool.release();
    }
}
