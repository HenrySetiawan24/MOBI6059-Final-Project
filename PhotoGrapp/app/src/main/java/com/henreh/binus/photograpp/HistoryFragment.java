package com.henreh.binus.photograpp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.henreh.binus.photograpp.adapter.HistoryAdapter;
import com.henreh.binus.photograpp.controller.PhotographerHandler;
import com.henreh.binus.photograpp.controller.RequestHandler;
import com.henreh.binus.photograpp.model.Request;

import java.util.Vector;

public class HistoryFragment extends Fragment {
    private View v;
    private RecyclerView historyList;
    private RequestHandler requestHandler = new RequestHandler(getActivity());
    private PhotographerHandler photographerHandler = new PhotographerHandler(getActivity());
    private HistoryAdapter historyAdapter;
    private Vector<Request> requests;

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_history, container, false);
        requests = new Vector<>();
        for(int i=0;i<10;i++)
            requests.add(new Request());

        historyList = v.findViewById(R.id.historyList);

        historyAdapter = new HistoryAdapter(requests, getActivity());

        historyList.setAdapter(historyAdapter);
        historyList.setLayoutManager(new LinearLayoutManager(getActivity()));
        historyList.hasFixedSize();
        return v;
    }
}