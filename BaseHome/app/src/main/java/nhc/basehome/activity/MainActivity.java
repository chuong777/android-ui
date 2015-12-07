package nhc.basehome.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import nhc.basehome.R;
import nhc.basehome.adapter.MainFragmentAdapter;
import nhc.basehome.util.DeviceManager;

public class MainActivity extends AppCompatActivity {
    private MainFragmentAdapter adapter;
    private ActionBarDrawerToggle drawerToggle;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.drawer_left)
    ScrollView scrvDrawer;
    @Bind(R.id.lnl_header)
    LinearLayout lnlHeader;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DeviceManager.setupStatusBar(this);
        setupAppBar();
        setupDrawerLayout();
        setupViewPager();
        setupTabLayout();
    }

    private void setupTabLayout() {
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    private void setupDrawerLayout() {
        lnlHeader.setPadding(lnlHeader.getPaddingLeft(), DeviceManager.statusBarHeight, lnlHeader.getPaddingRight(), lnlHeader.getPaddingBottom());
    }

    private void setupAppBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_dehaze_white_24dp);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(MainActivity.this, "Clicked Search", Toast.LENGTH_SHORT).show();
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        MenuItemCompat.setOnActionExpandListener(searchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Toast.makeText(MainActivity.this, "Expand", Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Toast.makeText(MainActivity.this, "Collapse", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Search: " + searchView.getQuery(), Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
