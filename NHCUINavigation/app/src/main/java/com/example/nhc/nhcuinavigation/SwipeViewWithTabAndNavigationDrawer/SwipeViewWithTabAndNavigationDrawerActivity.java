package com.example.nhc.nhcuinavigation.SwipeViewWithTabAndNavigationDrawer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhc.nhcuinavigation.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SwipeViewWithTabAndNavigationDrawerActivity extends FragmentActivity {
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.left_drawer)
    ListView drawerListView;
    private static final int NUM_TABS = 4;
    private static final List<String> tabTitles = new ArrayList<>();
    private static final List<Integer> tabIcons = new ArrayList<>();
    private static final List<String> drawerTitle = new ArrayList<>();
    private MyFragmentPagerAdapter adapter;

    static {
        tabTitles.add("Tab 1 ABCDEF");
        tabTitles.add("Tab 2 EDASDS");
        tabTitles.add("Tab 3 FDSFSD");
        tabTitles.add("Tab 4 ASDSDW");
        tabIcons.add(R.drawable.amazon);
        tabIcons.add(R.drawable.apple);
        tabIcons.add(R.drawable.google);
        tabIcons.add(R.drawable.microsoft);
        for (int i=1; i<10; i++) {
            drawerTitle.add("Drawer item " + i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_view_navigation_drawer);
        ButterKnife.bind(this);
        setupViewPager();
        setupTabLayout();
        setTabLayoutIcon();
        setCustomTabLayout();
        setupDrawerLayout();
    }

    private void setupDrawerLayout() {
        drawerListView.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, drawerTitle));
        drawerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SwipeViewWithTabAndNavigationDrawerActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupViewPager() {
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#000000"));
    }

    private void setTabLayoutIcon() {
        for (int i = 0; i < tabIcons.size(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIcons.get(i));
        }
    }

    private void setCustomTabLayout() {
        LinearLayout lnl = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.my_tab_layout, null);
        ((TextView) lnl.findViewById(R.id.tv_text)).setText(tabTitles.get(1));
        ((ImageView) lnl.findViewById(R.id.iv_image)).setImageResource(tabIcons.get(1));
        tabLayout.getTabAt(1).setCustomView(lnl);
    }

    public static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return MyListFragment.newInstance(position);
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

    public static class MyListFragment extends ListFragment {
        //index of this fragment in fragment adapter
        private int index;
        private static List<String> data;

        static {
            data = new ArrayList<>();
            for (int i = 1; i < 20; i++) {
                data.add("One Item");
            }
        }

        /**
         * Create a new instance of CountingFragment, providing "num"
         * as an argument.
         */
        static MyListFragment newInstance(int index) {
            MyListFragment f = new MyListFragment();
            // Supply num input as an argument.
            Bundle args = new Bundle();
            args.putInt("index", index);
            f.setArguments(args);
            return f;
        }

        /**
         * When creating, retrieve this instance's number from its arguments.
         */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            index = getArguments() == null ? 1 : getArguments().getInt("index");
        }

        /**
         * The Fragment's UI is just a simple text view showing its
         * instance number.
         */
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_swipe_item, container, false);
            View tv = v.findViewById(R.id.text);
            ((TextView) tv).setText("Fragment #" + index);
            return v;
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Toast.makeText(getContext(), "Clicked at " + position, Toast.LENGTH_SHORT).show();
        }
    }
}
