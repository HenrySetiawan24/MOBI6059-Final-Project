package com.henreh.binus.photograpp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    public interface homeListener{

        public void lookFor_Photographer();
        public void lookFor_PendingRequests();
        public void lookFor_ActiveRequests();

    }

    private homeListener currActivity;

    public void lookFor_Photographer(){
        if(currActivity != null){
            currActivity.lookFor_Photographer();
        }
    }
    public void lookFor_PendingRequests(){
        if(currActivity != null){
            currActivity.lookFor_PendingRequests();
        }
    }
    public void lookFor_ActiveRequests(){
        if(currActivity != null){
            currActivity.lookFor_ActiveRequests();
        }
    }

    RelativeLayout lookForPhotographer;
    RelativeLayout pendingRequestsBtn;
    RelativeLayout activeRequestsBtn;

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof FooterFragment.footerListener){
            currActivity = (HomeFragment.homeListener) getActivity();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        lookForPhotographer = rootView.findViewById(R.id.lookForPhotographerBtn);
        pendingRequestsBtn = rootView.findViewById(R.id.pendingRequestBtn);
        activeRequestsBtn = rootView.findViewById(R.id.activeRequestsBtn);

        lookForPhotographer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                lookFor_Photographer();
            }
        });

        pendingRequestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookFor_PendingRequests();
            }
        });

        activeRequestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookFor_ActiveRequests();
            }
        });
        return rootView;
    }



}