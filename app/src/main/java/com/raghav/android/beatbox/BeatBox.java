package com.raghav.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
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



    public List<Sound> getSoundList() {
        return mSoundList;
    }


    //assetMannager to access asets...present in Context
    private AssetManager mAssets;
    public BeatBox(Context context){
        mAssets = context.getAssets();
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
            String assetPath = SOUND_FOLDER +"/"+fileName;
            Sound mSound = new Sound(assetPath);
            mSoundList.add(mSound);
        }
    }
}
