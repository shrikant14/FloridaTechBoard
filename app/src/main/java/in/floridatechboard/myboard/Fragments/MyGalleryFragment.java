package in.floridatechboard.myboard.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.melnykov.fab.FloatingActionButton;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import in.floridatechboard.myboard.Activities.AddContentActivity;
import in.floridatechboard.myboard.Adapters.RecyclerViewAdapter;
import in.floridatechboard.myboard.Adapters.ViewAdapterGallery;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGalleryFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<RentListing> rent_list;

    public MyGalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_gallery, container, false);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        rent_list = createDumyData();
        // specify an adapter (see also next example)
        mAdapter = new ViewAdapterGallery(rent_list, getActivity());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setShadow(false);
        fab.attachToRecyclerView(mRecyclerView);

        JazzyRecyclerViewScrollListener jazzyScrollListener;
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        jazzyScrollListener.setTransitionEffect(new SlideInEffect());

        mRecyclerView.setOnScrollListener(jazzyScrollListener);
        mRecyclerView.setAdapter(mAdapter);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(getActivity(), AddContentActivity.class);
                //intent.putExtra("val","Suggest a place");
                startActivity(intent);
            }
        });

        return view;
    }

    public ArrayList<RentListing> createDumyData() {
        ArrayList<RentListing> p_list = new ArrayList<RentListing>();
        int[] listingId={1,2};
        String[] listingHeading={"2BHK for rent", "1 BHK for rent in landmark"};
        String[] listingCost={"$230","$300"};
        String[] listingStartedDate={"2nd April","5th May"};
        String[] listingPostingDate={"13th April","13th April"};
        String[] listingPersonName={"Name1","Name2"};


        for (int i = 0; i < listingId.length; i++) {
            RentListing p = new RentListing(listingId[i], listingHeading[i], listingCost[i], listingStartedDate[i], listingPostingDate[i], listingPersonName[i]);
            p_list.add(p);
            p_list.add(p);
            p_list.add(p);
            p_list.add(p);
            p_list.add(p);
            p_list.add(p);
        }
        return p_list;

    }

}
