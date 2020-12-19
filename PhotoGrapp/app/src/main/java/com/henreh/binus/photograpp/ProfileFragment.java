package com.henreh.binus.photograpp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class ProfileFragment extends Fragment {
    private View v;

    public interface headerListener{
        void sideBarOnClick();
    }
    private headerListener currActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof headerListener){
            currActivity = (headerListener) getActivity();
        }
    }

    public ProfileFragment() {
        // Required empty public constructor
    }
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v=inflater.inflate(R.layout.fragment_profile, container, false);

        ImageButton navBarIcon = v.findViewById(R.id.navBarIcon);
        navBarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currActivity.sideBarOnClick();
            }
        });

        return v;
    }
}