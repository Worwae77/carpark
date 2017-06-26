package th.co.dtac.carparking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowAvalible extends AppCompatActivity {

    private int[] ids = {R.id.block_1_1, R.id.block_1_2, R.id.block_1_3, R.id.block_1_4, R.id.block_1_5, R.id.block_1_6,
            R.id.block_2_1, R.id.block_2_2, R.id.block_2_3, R.id.block_2_4, R.id.block_2_5, R.id.block_2_6,
            R.id.block_3_1, R.id.block_3_2, R.id.block_3_3, R.id.block_3_4, R.id.block_3_5, R.id.block_3_6,
            R.id.block_4_1, R.id.block_4_2, R.id.block_4_3, R.id.block_4_4, R.id.block_4_5, R.id.block_4_6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_avalible);
        binding();
    }

    void binding(){
        int floor = getIntent().getIntExtra("floor", 1);
        ((TextView)findViewById(R.id.tv_floor_name)).setText("Floor "+floor);
        for(int id : ids){
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String postion = ((TextView) v).getText().toString();
                    Intent intent = new Intent(ShowAvalible.this, SummaryActivity.class);
                    intent.putExtra("floor",getIntent().getStringExtra("floor"));
                    intent.putExtra("position","ช่อง : "+postion);
                    startActivity(intent);
                }
            });
        }

    }
}
