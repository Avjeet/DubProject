package com.example.hasneetsingh.angelhackproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by hasneetsingh on 06/05/17.
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    ArrayAdapter<String> arrayAdapter =null;


    ArrayList<WallContent> arrayList=null;
    Context context;

    public RecyclerAdapter(ArrayList<WallContent> arraylist,Context context){
        this.arrayList=arraylist;
        this.context=context;
        arrayAdapter= new ArrayAdapter<>(context, android.R.layout.select_dialog_multichoice);
        arrayAdapter.add("Donate by E-Cash");
        arrayAdapter.add("Donate by watching Ads");

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.mTitle.setText(arrayList.get(position).getTitle());
        holder.mNgoName.setText(arrayList.get(position).getNgoName());
        holder.mRaised.setText("Raised : "+String.valueOf(arrayList.get(position).getRaised()) + "lakhs");
        holder.mTarget.setText("Target : " + String.valueOf(arrayList.get(position).getTarget()) + "lakhs");
        holder.mNgoImage.setImageResource(arrayList.get(position).getImageId());
        holder.mPostImage.setImageResource(arrayList.get(position).getNgoImageId());
        holder.mPostImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,StoryActivity.class);
                intent.putExtra(IntentConstants.titleIntentConstant,arrayList.get(position).getTitle());
                intent.putExtra(IntentConstants.raisedIntentConstant,arrayList.get(position).getRaised());
                intent.putExtra(IntentConstants.targetIntentConstant,arrayList.get(position).getTarget());
                intent.putExtra(IntentConstants.storyImageConstant,arrayList.get(position).getImageId());
                intent.putExtra(IntentConstants.position,position);
                context.startActivity(intent);
            }
        });
        holder.upVoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                b.setTextColor(ContextCompat.getColor(context,android.R.color.holo_green_dark));
            }
        });

        holder.donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position) {
                        if(position==0){
                            //do nothing
                        }
                        else{
                            Intent videoIntent = new Intent(context,VideoActivity.class);
                            context.startActivity(videoIntent);
                        }
                    }
                });
            }
        });


        float temp = arrayList.get(position).getRaised()/arrayList.get(position).getTarget();
        holder.mProgressBar.setProgress(Math.round(temp*100));
        Log.e("myTag", "onBindViewHolder: " + Math.round(temp*100));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mNgoName;
        private TextView mRaised;
        private TextView mTarget;
        private ImageView mPostImage;
        private ImageView mNgoImage;
        private ProgressBar mProgressBar;
        private Button donateButton;
        private Button upVoteButton;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title_id);
            mNgoName = (TextView) itemView.findViewById(R.id.ngo_name_id);
            mRaised = (TextView) itemView.findViewById(R.id.raised_id);
            mTarget = (TextView) itemView.findViewById(R.id.target_id);
            mPostImage = (ImageView) itemView.findViewById(R.id.image_view_post);
            mNgoImage = (ImageView) itemView.findViewById(R.id.image_view_ngo);
            mProgressBar = (ProgressBar) itemView.findViewById(R.id.progressBar);
            donateButton = (Button) itemView.findViewById(R.id.button2);
            upVoteButton = (Button) itemView.findViewById(R.id.button);
        }
    }
}