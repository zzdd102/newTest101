package com.example.yinyueyyy.test101;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class YuceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yuce);

        final Button button5 = (Button)findViewById(R.id.button5);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
