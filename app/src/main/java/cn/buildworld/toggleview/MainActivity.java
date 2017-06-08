package cn.buildworld.toggleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cn.buildworld.toggleview.ui.ToggleView;

public class MainActivity extends AppCompatActivity {

    private ToggleView toggleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleView = (ToggleView) findViewById(R.id.toggle);

        toggleView.setSwitchBackgroundResouce(R.drawable.switch_background);

        toggleView.setSlideButtonResouce(R.drawable.slide_button);

        toggleView.setSwitchState(true);

        //状态监听
        toggleView.setOnSwitchStateUpdateListener(new ToggleView.OnSwitchStateUpdateListener() {
            @Override
            public void onStateUpdate(boolean staet) {
                if (staet){
                    Toast.makeText(MainActivity.this, "开关打开", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "开关关闭", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
