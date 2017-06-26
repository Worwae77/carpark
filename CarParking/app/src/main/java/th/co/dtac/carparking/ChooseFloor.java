package th.co.dtac.carparking;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ChooseFloor extends AppCompatActivity {


    private LinearLayout vLLContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_floor);
        binding();
        mockData(8);
    }

    public void binding() {
        vLLContent = (LinearLayout) findViewById(R.id.ll_content);
    }


    public void mockData(int count) {
        for (int i = 0; i < count; i++) {
            vLLContent.addView(createView(i+1));
        }
    }

    public View createView(final int number) {

        View view = getLayoutInflater().inflate(R.layout.adapter_floor, null);
        ((TextView) view.findViewById(R.id.tv_floor_available)).setText(String.valueOf(new Random().nextInt(10)));
        ((TextView) view.findViewById(R.id.tv_floor_name)).setText("Floor : " + number);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChooseFloor.this, ShowAvalible.class);
                intent.putExtra("floor", "Floor : " + number);
                startActivity(intent);
            }
        });
        return view;

    }


}
