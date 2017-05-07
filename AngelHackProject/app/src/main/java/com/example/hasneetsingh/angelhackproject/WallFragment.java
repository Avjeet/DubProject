package com.example.hasneetsingh.angelhackproject;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



/**
 * A simple {@link Fragment} subclass.
 */
public class WallFragment extends Fragment {

    ArrayList<WallContent> arrayList;
    View view;
    public WallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_wall, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        arrayList = new ArrayList<>();
        arrayList.add(new WallContent("Landslide in kashmir","ASSIST",2,15,R.mipmap.ic_launcher,R.drawable.assist_ngo_image));
        arrayList.add(new WallContent("Floods in Kerela","ASSIST",2,15,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        arrayList.add(new WallContent("Fund raising for family of soldier martyred in attacks","Atrang Foundation",5,10,R.mipmap.ic_launcher,R.mipmap.ic_launcher));
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        RecyclerAdapter mAdapter = new RecyclerAdapter(arrayList,getContext());
        mRecyclerView.setAdapter(mAdapter);
//        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(),mRecyclerView, new RecyclerItemClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                //Intent intent =
//                startActivity(new Intent(getActivity(),StoryActivity.class));
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        }));

    }
}
