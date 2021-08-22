package ru.startandroid.p0711preferencessimple;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;


public class PrefActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}
