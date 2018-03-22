package com.example.pichau.conheaeaj20.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FixedTabsPageAdapter extends FragmentPagerAdapter {

    //Construtor necessita de um fragmentManager para gerenciar os fragments na tab
    public FixedTabsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:

                return new FragmentSetor();
            case 1:
                return new FragmentMapa();

            default:
                return null;
        }
    }

    //quantidade de fragment
    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Detalhes";
            case 1:
                return "Mapa";
            default:
                return null;
        }
    }
}