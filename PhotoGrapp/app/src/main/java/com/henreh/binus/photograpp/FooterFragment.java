package com.henreh.binus.photograpp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;

public class FooterFragment extends Fragment {
    private footerListener currActivity;

    public interface footerListener{
        void homeOnClick();
        void profileOnClick();
        void historyOnClick();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof footerListener){
            currActivity = (footerListener) getActivity();
        }
    }

    public void homeOnClick(View view){
        if(currActivity!=null)
            currActivity.homeOnClick();
    }
    public void profileOnClick(View view){
        if(currActivity!=null)
            currActivity.profileOnClick();
    }
    public void historyOnClick(View view){
        if(currActivity!=null)
            currActivity.historyOnClick();
    }
}