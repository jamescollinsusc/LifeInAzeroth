package fanative.com.lifeinazeroth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mNameEdit;
    private Button mStartAdventure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEdit = (EditText) findViewById(R.id.nameEditText);
        mStartAdventure = (Button) findViewById(R.id.startAdventureButton);

        mStartAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mNameEdit.getText().toString();
                //Toast.makeText(MainActivity.this, name, Toast.LENGTH_SHORT).show();
                startStory(name);
            }
        });
    }
    private void startStory(String name){
        Intent intent = new Intent(this, StoryOneActivity.class);
        intent.putExtra(getString(R.string.key_name), name);
        startActivity(intent);
    }

}
