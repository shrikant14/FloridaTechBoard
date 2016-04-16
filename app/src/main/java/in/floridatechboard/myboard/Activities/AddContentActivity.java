package in.floridatechboard.myboard.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import in.floridatechboard.myboard.R;

public class AddContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_content);
        Intent intent=getIntent();

        int val = intent.getIntExtra("val", 0);

        if(val==1){
            getSupportActionBar().setTitle("Post your UNOFFICIAL story");
        }


       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
