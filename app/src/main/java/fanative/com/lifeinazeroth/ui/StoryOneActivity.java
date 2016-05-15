package fanative.com.lifeinazeroth.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import fanative.com.lifeinazeroth.R;
import fanative.com.lifeinazeroth.model.Choice;
import fanative.com.lifeinazeroth.model.Page;
import fanative.com.lifeinazeroth.model.Story;

public class StoryOneActivity extends AppCompatActivity {

    public static final String TAG  = StoryOneActivity.class.getSimpleName();
    private Story mStory = new Story();
    private ImageView mImageView;
    private TextView mTextView;
    private Button mButton1;
    private Button mButton2;
    private String mName;
    private Page mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one);

        Intent intent = getIntent();
        mName = intent.getStringExtra(getString(R.string.key_name));
        if(mName == null){
            mName = "there was a problem";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.storyImageView);
        mTextView = (TextView) findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.choice1Button);
        mButton2 = (Button) findViewById(R.id.choice2Button);

        loadPage(0);

    }

    private void loadPage(int ID){
        mCurrentPage = mStory.getPage(ID);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), mCurrentPage.getIntId(), null);

        mImageView.setImageDrawable(drawable);
        String pageText = mCurrentPage.getText();
        // adds name if placeholder included, does nothing if it is not included
        pageText = String.format(pageText, mName);
        mTextView.setText(pageText);
        if(!mCurrentPage.isFinal()){
            Choice choice1 = mCurrentPage.getChoice1();
            Choice choice2 = mCurrentPage.getChoice2();
            mButton1.setText(choice1.getText());
            mButton2.setText(choice2.getText());
            mButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice1().getPageNumber());

                }
            });
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    loadPage(mCurrentPage.getChoice2().getPageNumber());

                }
            });
        }
        else{
            mButton1.setVisibility(View.INVISIBLE);
            mButton2.setText("Play Again");
            mButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
