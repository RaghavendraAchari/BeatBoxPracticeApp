package com.raghav.android.beatbox;

/**
 * Created by Vighnesh on 14-08-2018.
 */

public class Sound {
    public String getAssetPath() {
        return mAssetPath;
    }

    public String getName() {
        return mName;
    }

    private String mAssetPath;
    private String mName;
    private Integer mSoundId;

    public Sound(String path){
        mAssetPath = path;
        String[] componentsOfPath = path.split("/");
        String fileName = componentsOfPath[componentsOfPath.length - 1];
        mName = fileName.replace(".wav","");
    }

    public Integer getSoundId() {
        return mSoundId;
    }

    public void setSoundId(Integer soundId) {
        mSoundId = soundId;
    }
}
