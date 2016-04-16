package in.floridatechboard.myboard.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import in.floridatechboard.myboard.Activities.AddContentActivity;
import in.floridatechboard.myboard.Adapters.RecyclerViewAdapter;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;
import in.floridatechboard.myboard.Utils.SlidingTabLayout;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyNotificationFragment extends Fragment {


    public MyNotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_notification, container, false);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Log.e("frag", "onViewCreated");
        ViewPager mPager;
        SlidingTabLayout mTabs;
        MyPagerAdapter mAdapter;


        mPager = (ViewPager) view.findViewById(R.id.pager);
        mAdapter = new MyPagerAdapter(getChildFragmentManager());

        mPager.setAdapter(mAdapter);
        mTabs = (SlidingTabLayout) view.findViewById(R.id.tabs);

        mTabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        mTabs.setDistributeEvenly(true);
        mTabs.setBackgroundColor(getResources().getColor(R.color.colorPrimaryNotify));

        mTabs.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccentNotify));
        mTabs.setViewPager(mPager);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {


        String[] tabs;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tab_my_notifications);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            if (position == 0) {
                fragment = new MyNotificationsAcademics();
            } else if (position == 1) {
                fragment = new MyNotificationsSports();
            }else if (position == 2) {
                fragment = new MyNotificationsGeneral();
            }

            return fragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public void notifyDataSetChanged() {

            super.notifyDataSetChanged();

            Log.d("notify", "changed");
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub

            FragmentManager manager = ((Fragment) object).getFragmentManager();
            FragmentTransaction trans = manager.beginTransaction();
            trans.remove((Fragment) object);
            trans.commit();

            super.destroyItem(container, position, object);
        }
    }

}
