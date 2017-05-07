package com.example.hasneetsingh.angelhackproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class AfterVideoFragment extends Fragment {
    View view;

    public AfterVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_after_video, container, false);
        view.setBackground(ContextCompat.getDrawable(getContext(),android.R.color.transparent));
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton nextVideoButton = (ImageButton) view.findViewById(R.id.imageButton);
        ImageButton cancel_action = (ImageButton) view.findViewById(R.id.cancel_action);
        cancel_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onPause() {
        super.onPause();

    }
}
