package io.smalldata.newbeehivesurveys;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import io.smalldata.newbeehivesurveys.studyManagement.RSActivity;
import io.smalldata.newbeehivesurveys.studyManagement.RSActivityManager;

public class MainActivity extends RSActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activateSurveyButton();
        activatePAMButton();
    }

    private void activateSurveyButton() {
        Button btnSurvey = findViewById(R.id.btn_launch_survey);
        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RSActivityManager.get().queueActivity(getApplicationContext(), "notificationDate", true);
            }
        });
    }

    private void activatePAMButton() {
        Button btnSurvey = findViewById(R.id.btn_launch_pam);
        btnSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RSActivityManager.get().queueActivity(getApplicationContext(), "RSpam", true);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
