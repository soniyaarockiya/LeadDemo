package com.example.a91user.leaddemo.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapter extends FragmentPagerAdapter {

    //var
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentName = new ArrayList<>();


    public ViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);

    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentName.get(position);
    }

    //add fragments as tab
    public void AddFragment(Fragment fragment, String name) {
        fragmentList.add(fragment);
        fragmentName.add(name);
    }


}
