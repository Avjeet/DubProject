package com.example.hasneetsingh.angelhackproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StoryActivity extends AppCompatActivity {

    TextView storyRaisedValue;
    TextView storyTargetValue;
    TextView storyContent;
    TextView storyTitle;
    ImageView storyImage;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        storyRaisedValue = (TextView) findViewById(R.id.raised_value_id);
        storyTargetValue = (TextView) findViewById(R.id.target_value_id);
        storyContent = (TextView) findViewById(R.id.story_content_id);
        storyTitle = (TextView) findViewById(R.id.story_title_id);
        storyImage = (ImageView) findViewById(R.id.story_image_id);
        Intent intent = getIntent();
        storyRaisedValue.setText(String.valueOf(intent.getFloatExtra(IntentConstants.raisedIntentConstant,0)));
        storyTargetValue.setText(String.valueOf(intent.getFloatExtra(IntentConstants.targetIntentConstant,0)));
        storyTitle.setText(intent.getStringExtra(IntentConstants.titleIntentConstant));
        storyImage.setImageResource(intent.getIntExtra(IntentConstants.storyImageConstant,0));
        position = intent.getIntExtra(IntentConstants.position,0);
        storyContent.setText(getResources().getStringArray(R.array.story_array)[position]);

    }
}
