package com.henreh.binus.photograpp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class SidemenuFragment extends Fragment {
    private View v;

    public interface SideMenuListener{
        void SideMenuBackOnClick();
    }
    private SideMenuListener currActivity;

    public SidemenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof SideMenuListener){
            currActivity = (SideMenuListener) getActivity();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_sidemenu, container, false);
        ImageButton leftArrow = v.findViewById(R.id.leftArrow);
        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currActivity.SideMenuBackOnClick();
            }
        });
        return v;
    }
}