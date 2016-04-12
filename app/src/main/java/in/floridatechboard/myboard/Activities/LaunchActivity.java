package in.floridatechboard.myboard.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import in.floridatechboard.myboard.R;

public class LaunchActivity extends AppCompatActivity {

    TextView title,subTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        title=(TextView)findViewById(R.id.textViewTitle);
        subTitle=(TextView)findViewById(R.id.textViewSubTitle);

        String fontPath = "fonts/Caviar_Dreams_Bold.ttf";
        Typeface tf = Typeface.createFromAsset(getAssets(), fontPath);
        title.setTypeface(tf);
        title.setText("FLORIDA TECH");

        subTitle.setTypeface(tf);
        subTitle.setText("BOARD");
        addDelay();
    }

    public void addDelay(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent in = new Intent(LaunchActivity.this, HomeActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(in);
            }
        }, 5000);
    }
}
