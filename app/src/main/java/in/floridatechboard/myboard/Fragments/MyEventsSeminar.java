package in.floridatechboard.myboard.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.afollestad.materialdialogs.MaterialDialog;
import com.melnykov.fab.FloatingActionButton;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import in.floridatechboard.myboard.Activities.AddContentActivity;
import in.floridatechboard.myboard.Adapters.RecyclerViewAdapter;
import in.floridatechboard.myboard.Adapters.ViewAdapterEvents;
import in.floridatechboard.myboard.Models.Events;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;
import in.floridatechboard.myboard.Utils.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyEventsSeminar extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Events> e_list;

    public MyEventsSeminar() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_my_events_seminar, container, false);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        e_list = createDumyData();
        // specify an adapter (see also next example)
        mAdapter = new ViewAdapterEvents(e_list, getActivity());

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setShadow(false);
        fab.attachToRecyclerView(mRecyclerView);

        JazzyRecyclerViewScrollListener jazzyScrollListener;
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        jazzyScrollListener.setTransitionEffect(new SlideInEffect());

        mRecyclerView.setOnScrollListener(jazzyScrollListener);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        // do whateve
                        new MaterialDialog.Builder(getActivity())
                                .title(e_list.get(position).getEventTitle())
                                .content(e_list.get(position).getEventDetails())
                                .positiveText("CLOSE")
                                .show();


                    }
                })
        );

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

    public ArrayList<Events> createDumyData() {
        ArrayList<Events> e_list = new ArrayList<Events>();
        int[] eventId={1,2};
        String[] eventTitle={"Seminar Title 1", "Seminar Title 2"};
        String[] eventDate={"2nd April","5th April"};
        String[] eventTime={"2:00 pm","10:30 am"};
        String[] eventSender={"abc@fit.edy","def@my.fit.edu"};
        String[] eventLoc={"Olin Engineering 210","Library 214"};
        String[] eventDetails={"asdj ashdkjsd js dhas dh shdsah  dhsad h","asd has dhsdgvsag hdsgsag dgsfd gsf gsadgsfdg  sgdgas dgasdsd sg d"};
        String[] eventHashTags={"#cs2017, #programing", "#presentations, #everyone"};


        for (int i = 0; i < eventId.length; i++) {
            Events p = new Events(eventId[i],eventSender[i],  eventDate[i], eventTime[i], eventLoc[i], eventDetails[i], eventHashTags[i],eventTitle[i]);
            e_list.add(p);
            e_list.add(p);
            e_list.add(p);
        }
        return e_list;

    }

}
