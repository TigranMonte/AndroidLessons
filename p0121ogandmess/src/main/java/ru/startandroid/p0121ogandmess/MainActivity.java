package ru.startandroid.p0121ogandmess;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static ru.startandroid.p0121ogandmess.R.drawable.logo;

public class MainActivity extends Activity {

    TextView tvOut;
    Button btnOk;
    Button btnCancel;

    private static final String TAG = "myLogs";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Найдем View элементы");
        // найдем View-элементы
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        // создаем обработчик нажатия
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)

                    tvOut.setText("Обработаем нажатие кнопки OK");
                Toast toast = Toast.makeText(MainActivity.this, "Нажата кнопка OK", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.RIGHT, 0, 0);
                //LinearLayout toastImage = (LinearLayout) toast.getView();
                //ImageView imageView = new ImageView(MainActivity.this);
                //imageView.setImageResource(logo);
                //toastImage.addView(imageView, 0);
                toast.show();
            }
        };

        // присвоим обработчик кнопке OK (btnOk)
        btnOk.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Меняем текст в TextView (tvOut)
                tvOut.setText("Нажата кнопка Cancel");
                Log.d(TAG, "Обработаем нажатие кнопки Cancel");
            }
        };

        btnCancel.setOnClickListener(oclBtnCancel);

    }
}