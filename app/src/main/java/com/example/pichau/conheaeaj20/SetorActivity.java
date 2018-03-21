package com.example.pichau.conheaeaj20;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

public class SetorActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTablayout;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mTablayout = (TabLayout) findViewById(R.id.tabSetor);
        mViewPager = (ViewPager) findViewById(R.id.viewPageSetor);


//        Intent i = getIntent();
//        Setor setor = (Setor) i.getSerializableExtra("objSetor");
//        setTitle(setor.getNomeSetor());

        PagerAdapter mPageAdapter = new FixedTabsPageAdapter(getSupportFragmentManager());

        mViewPager.setAdapter(mPageAdapter);
        mTablayout.setupWithViewPager(mViewPager);

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(mTablayout.getTabAt(1).isSelected()){
                    coordinatorLayout = findViewById(R.id.coordinatorLayout);
                    coordinatorLayout.scrollTo(0,400);

                    Log.i("testando", "selecionou");
                }else{
                    coordinatorLayout.scrollTo(0,0);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
