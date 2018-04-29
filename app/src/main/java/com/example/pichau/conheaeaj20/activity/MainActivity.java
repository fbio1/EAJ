package com.example.pichau.conheaeaj20.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.pichau.conheaeaj20.Setor;
import com.example.pichau.conheaeaj20.SetorAdapter;
import com.example.pichau.conheaeaj20.sqlHelper.SetorHelper;
import com.fabio.eaj.conheaeaj.R;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Setor> listaSetor = new ArrayList<Setor>();
    //private boolean flagList = false;
    private SetorHelper setorHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        setorHelper = new SetorHelper(this);

       /* List<Setor> setorsTemp = null;

        if(setorHelper.getAll() == null) {
            Log.i("eae", "começou");
            setorsTemp = setorHelper.createList();

            for (int i = 0; i < setorsTemp.size(); i++)
                setorHelper.insert(setorsTemp.get(i));
        }*/
        listaSetor = setorHelper.createList();
        //Log.i("eae", "criou");

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        SetorAdapter setorAdapter = new SetorAdapter(MainActivity.this, listaSetor);
        recyclerView.setAdapter(setorAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.contato) {
            Intent i = new Intent(this, ContatoActivity.class);
            startActivity(i);
        } else if (id == R.id.sobre) {
            Intent i = new Intent(this, SobreActivity.class);
            startActivity(i);
        } else if (id == R.id.ajuda) {
            Intent i = new Intent(this, AjudaActivity.class);
            startActivity(i);
        } 

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
