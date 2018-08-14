package com.raghav.android.beatbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raghav.android.beatbox.databinding.FragmentBeatBoxBinding;
import com.raghav.android.beatbox.databinding.SoundItemListBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vighnesh on 14-08-2018.
 */

public class BeatBoxFragment extends Fragment {
    private BeatBox mBeatBox;




    public static BeatBoxFragment newInstance(){
        return new BeatBoxFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_beat_box,container,false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        binding.recyclerView.setAdapter(new Adapter(mBeatBox.getSoundList()));

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         mBeatBox = new BeatBox(getActivity());
    }

    private class SoundHolder extends RecyclerView.ViewHolder{
        private SoundItemListBinding mBinding;

        public SoundHolder(SoundItemListBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }

    private class Adapter extends RecyclerView.Adapter<SoundHolder>{
        private List<Sound> mSoundsList = new ArrayList<>();

        public Adapter(List<Sound> list){
            mSoundsList = list;
        }

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            SoundItemListBinding binding = DataBindingUtil.inflate(inflater,R.layout.sound_item_list,parent,false);
            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return mSoundsList.size();
        }
    }
}
