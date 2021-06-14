package ru.startandroid.p0161dynamiclayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        ViewGroup.LayoutParams linLayoutParams= new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setContentView(linearLayout, linLayoutParams);

        ViewGroup.LayoutParams lpView = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView tv = new TextView(this);
        tv.setText("Hello World!");
        tv.setLayoutParams(lpView);
        linearLayout.addView(tv);

        Button bt = new Button(this);
        bt.setText("OK Button");
        linearLayout.addView(bt, lpView);

        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;

        Button bt2 = new Button(this);
        bt2.setText("Button 2");
        linearLayout.addView(bt2, leftMarginParams);

        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;

        Button bt3 = new Button(this);
        bt3.setText("Button 3");
        linearLayout.addView(bt3, rightGravityParams);
    }
}