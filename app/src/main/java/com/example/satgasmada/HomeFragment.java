 package com.example.satgasmada;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View viewReport;
    private FloatingActionButton mActionButton;
    private RecyclerView mRecyclerView;
    private List<ReportModel> listReport;


    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listReport = new ArrayList<>();
        listReport.add(new ReportModel("Report 1","Danger", "March 15 2021  13:23:10", "Sent By : John",R.drawable.ic_round_description_24));
        listReport.add(new ReportModel("Report 2","Danger", "March 18 2021  15:23:20", "Sent By : John",R.drawable.ic_round_description_24));
        listReport.add(new ReportModel("Report 3","Safe", "March 24 2021  23:29:10", "Sent By : John",R.drawable.ic_round_description_24));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewReport = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView = (RecyclerView) viewReport.findViewById(R.id.recyclerViewReport);
        mActionButton = (FloatingActionButton) viewReport.findViewById(R.id.btn_float);

        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewReport) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,new ReportAddFragment());
                fragmentTransaction.commit();
            }
        });

        ReportAdapter reportAdapter = new ReportAdapter(getContext(),listReport);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(reportAdapter);

        return viewReport;
    }
}