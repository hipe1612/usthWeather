package vn.edu.usth.weather;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    private static  final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        /*ForecastFragment emptyFragment = new ForecastFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container,emptyFragment)
                .commit();*/

        PagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager(),this);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        Log.i(TAG,"onCreate() method called");

    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG,"onStart() method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume() method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause() method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() method called");
    }

    public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
        private final int PAGE_COUNT = 3;
        private Context context;
        private final String[] titles ;

        public HomeFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
            titles = new String[]{context.getString(R.string.hanoi),context.getString(R.string.paris),context.getString(R.string.toulouse)};
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int page) {
            switch (page) {
                case 0:
                    return WeatherAndForecastFragment.newInstance(context.getString(R.string.hanoi));
                case 1:
                    return WeatherAndForecastFragment.newInstance(context.getString(R.string.paris));
                case 2:
                    return WeatherAndForecastFragment.newInstance(context.getString(R.string.toulouse));
            }
            return new EmptyFragment();
        }

        @Override
        public CharSequence getPageTitle(int page) {

            return titles[page];
        }
    }
}
