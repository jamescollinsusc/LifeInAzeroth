package fanative.com.lifeinazeroth.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fanative.com.lifeinazeroth.R;
import fanative.com.lifeinazeroth.model.Page;

public class StoryOneActivity extends AppCompatActivity {

    public static final String TAG  = StoryOneActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one);

        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        if(name == null){
            name = "there was a problem";
        }
        Log.d(TAG, name);
    }

}
