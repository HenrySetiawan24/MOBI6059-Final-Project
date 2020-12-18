package com.henreh.binus.photograpp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }
<<<<<<< HEAD
=======

>>>>>>> 027781887a6cb983391703efe4ae0ed3130c8ea6
    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
}