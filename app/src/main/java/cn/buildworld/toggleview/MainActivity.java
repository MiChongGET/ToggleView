package cn.buildworld.toggleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
    }

}
