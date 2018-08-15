package com.raghav.android.beatbox;

import org.hamcrest.MatcherAssert;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Vighnesh on 15-08-2018.
 */
public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setSound(mSound);

    }
    @Test
    public void exposeSoundNameAsTitle(){
        assertThat(mSubject.getTitle(), is(mSound.getName()));
    }
    @Test
    public void callsOnButtonClicked(){
        mSubject.onButtonClicked();
        verify(mBeatBox).play(mSound);
    }

}