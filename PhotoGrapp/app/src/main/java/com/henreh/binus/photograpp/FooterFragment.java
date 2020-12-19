package com.henreh.binus.photograpp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class FooterFragment extends Fragment {
    private View v;
    public FooterFragment(){

    }

    public interface footerListener{
        void homeOnClick();
        void profileOnClick();
        void historyOnClick();
    }

    private footerListener currActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof footerListener){
            currActivity = (footerListener) getActivity();
        }
    }

    public void homeOnClick(){
        if(currActivity!=null)
            currActivity.homeOnClick();
    }
    public void profileOnClick(){
        if(currActivity!=null)
            currActivity.profileOnClick();
    }
    public void historyOnClick(){
        if(currActivity!=null)
            currActivity.historyOnClick();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_footer, container, false);

        ImageButton hBtn = v.findViewById(R.id.homeIcon);
        hBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                homeOnClick();
            }
        });
        ImageButton pBtn = v.findViewById(R.id.profileIcon);
        pBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                profileOnClick();
            }
        });
        ImageButton hsBtn = v.findViewById(R.id.historyIcon);
        hsBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                historyOnClick();
            }
        });
        return v;
    }
}