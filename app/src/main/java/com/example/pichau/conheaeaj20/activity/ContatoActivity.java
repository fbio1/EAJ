package com.example.pichau.conheaeaj20.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.pichau.conheaeaj20.R;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        ActionBar ab = getSupportActionBar();

        ab.setTitle("Contato");
        ab.setDisplayHomeAsUpEnabled(true);

    }
}
