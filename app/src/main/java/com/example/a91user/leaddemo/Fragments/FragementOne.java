package com.example.a91user.leaddemo.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a91user.leaddemo.Adapter.RecyclerAdpater;
import com.example.a91user.leaddemo.Model.Unit;
import com.example.a91user.leaddemo.R;
import com.example.a91user.leaddemo.UnitOnClickActivity;

import java.util.ArrayList;

public class FragementOne extends Fragment implements RecyclerAdpater.OnUnitListener {

    RecyclerView recyclerViewOne;
    RecyclerAdpater adapter;
    ArrayList<Unit> unitList = new ArrayList<>();

    //empty constructor
    public FragementOne() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragement_one, container, false);

        //Recycler Settings
        recyclerViewOne = view.findViewById(R.id.recycler_one);
        recyclerViewOne.setHasFixedSize(true);
        recyclerViewOne.setLayoutManager(new LinearLayoutManager(getActivity()));

        //data
        unitList.add(new Unit("hey", "heeeeeee"));
        unitList.add(new Unit("Unit : Science", "One"));
        unitList.add(new Unit("Unit : Maths", "One"));
        unitList.add(new Unit("Unit : History", "One"));
        unitList.add(new Unit("yo", "nnnsnn"));

        adapter = new RecyclerAdpater(getActivity(), unitList, this);

        recyclerViewOne.setAdapter(adapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public void onUnitClick(int position) {
        Intent intent = new Intent(getActivity(), UnitOnClickActivity.class);
        intent.putExtra("click", unitList.get(position));
        startActivity(intent);
    }
}