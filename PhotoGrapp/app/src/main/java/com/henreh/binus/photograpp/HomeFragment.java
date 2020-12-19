package com.henreh.binus.photograpp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class HomeFragment extends Fragment {

    interface HomeFragmentListener{
        public void lookForPhotographerOnClick();
        public void activeRequestsOnClick();
        public void pendingRequestsOnClick();
    }

    private HomeFragmentListener currView;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(getActivity() instanceof HomeFragmentListener){
            currView = (HomeFragmentListener) getActivity();
        }
    }

    public HomeFragment() {
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
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        RelativeLayout lookForPhotographerBtn = rootView.findViewById(R.id.lookForPhotographerBtn);
        lookForPhotographerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currView.lookForPhotographerOnClick();
            }
        });

        RelativeLayout activeRequestsBtn = rootView.findViewById(R.id.activeRequestsBtn);
        activeRequestsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currView.activeRequestsOnClick();
            }
        });

        RelativeLayout pendingRequestBtn = rootView.findViewById(R.id.pendingRequestBtn);
        pendingRequestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currView.pendingRequestsOnClick();
            }
        });
        return rootView;
    }
}