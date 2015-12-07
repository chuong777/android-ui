package nhc.basehome.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.LinkedList;
import java.util.List;

import nhc.basehome.fragment.MainFragment;

/**
 * Created by NHC on 1/12/2015.
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
    private final int NUM_TABS = 4;
    private final List<String> tabTitles = new LinkedList<>();

    {
        tabTitles.add("Tab title 1");
        tabTitles.add("Tab title 2");
        tabTitles.add("Tab title 3");
        tabTitles.add("Tab title 4");
    }

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainFragment.getInstance();
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles.get(position);
    }
}
