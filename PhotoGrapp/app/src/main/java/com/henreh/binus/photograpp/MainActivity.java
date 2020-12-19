package com.henreh.binus.photograpp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FooterFragment.footerListener, ProfileFragment.headerListener, SidemenuFragment.SideMenuListener {
    private HomeFragment homeFragment = new HomeFragment();
    private SidemenuFragment sidemenuFragment = new SidemenuFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, homeFragment).commit();
    }

    @Override
    public void homeOnClick() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, homeFragment).addToBackStack(null).commit();
    }

    @Override
    public void profileOnClick() {
        UserDetailFragment fragment = new UserDetailFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).addToBackStack(null).commit();
    }

    @Override
    public void historyOnClick() {
//        History fragment = new ProfileFragment();
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).addToBackStack(null).commit();
    }

    public void lookFor_Photographer(){
//        HomeFragment fragment = new HomeFragment(); //TODO: change this
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).addToBackStack(null).commit();
    }

    public void lookFor_PendingRequests(){
//        HomeFragment fragment = new HomeFragment(); //TODO: change this
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).addToBackStack(null).commit();
    }

    public void lookFor_ActiveRequests(){
//        HomeFragment fragment = new HomeFragment(); //TODO: change this
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(R.id.mainFragment, fragment).addToBackStack(null).commit();
    }
    
    @Override
    public void sideBarOnClick() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.sideMenu, sidemenuFragment).commit();
        fragmentManager.beginTransaction().remove(homeFragment).commit();
    }

    @Override
    public void SideMenuBackOnClick() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainFragment, homeFragment).commit();
        fragmentManager.beginTransaction().remove(sidemenuFragment).commit();
    }
}