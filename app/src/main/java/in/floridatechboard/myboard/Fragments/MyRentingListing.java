package in.floridatechboard.myboard.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import in.floridatechboard.myboard.Adapters.ViewAdapterMarketplace;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyRentingListing extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<RentListing> rent_list;

    public MyRentingListing() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_renting_listing, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        rent_list = createDumyData();
        // specify an adapter (see also next example)
        mAdapter = new ViewAdapterMarketplace(rent_list, getActivity(), 1);

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
                Intent intent = new Intent(getActivity(), AddContentActivity.class);
                //intent.putExtra("val","Suggest a place");
                startActivity(intent);
            }
        });

        return view;
    }

    public ArrayList<RentListing> createDumyData() {
        ArrayList<RentListing> p_list = new ArrayList<RentListing>();
        int[] listingId = {1, 2};
        String[] listingHeading = {"Room for rent for summer", "1 BHK for rent in landmark"};
        String[] listingCost = {"$ 550", "$ 300"};
        String[] listingStartedDate = {"Summer", "5th May"};
        String[] listingPostingDate = {"13th April", "13th April"};
        String[] listingPersonName = {"Phone Khant", "Chan"};
        String[] listingDetails = {"I will be away during the summer and am renting out my room. The rent is 550 including electricity and 75Mbps internet. The apartment has a washer and a drier, and a tv + ps4. Includes personal bathroom, and furnished Bedroom with bed and study table. The apartment will have one other person(male). Leave a text to 917-943-4525 or reply to this email if interested.", "I am looking for a roommate to move in with me. Email me back if interested."};


        for (int i = 0; i < listingId.length; i++) {
            RentListing p = new RentListing(listingId[i], listingPersonName[i], listingPostingDate[i], listingStartedDate[i], listingHeading[i], listingCost[i], listingDetails[i]);

            p_list.add(p);
            p_list.add(p);
            p_list.add(p);
        }
        return p_list;

    }

}
