package th.co.dtac.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        binding();
    }

    void binding(){
        String floorName = getIntent().getStringExtra("floor");
        String position = getIntent().getStringExtra("position");
        String time = getIntent().getStringExtra("time");

        ((TextView)findViewById(R.id.tv_floor_name)).setText(floorName);
        ((TextView)findViewById(R.id.tv_floor_position)).setText(position);
        ((TextView)findViewById(R.id.tv_time)).setText(time);



        findViewById(R.id.bt_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

    }
}
