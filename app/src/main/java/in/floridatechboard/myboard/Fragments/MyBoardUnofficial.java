package in.floridatechboard.myboard.Fragments;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.afollestad.materialdialogs.MaterialDialog;
import com.melnykov.fab.FloatingActionButton;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import in.floridatechboard.myboard.Activities.AddContentActivity;
import in.floridatechboard.myboard.Adapters.RecyclerViewAdapter;
import in.floridatechboard.myboard.Adapters.ViewAdapterUnofficial;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.Models.UnofficialStory;
import in.floridatechboard.myboard.R;
import in.floridatechboard.myboard.Utils.RecyclerItemClickListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyBoardUnofficial extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<UnofficialStory> story_list;

    public MyBoardUnofficial() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_board_unofficial, container, false);
        // Inflate the layout for this fragment
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view1);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        setHasOptionsMenu(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        story_list = createDumyData();
        // specify an adapter (see also next example)
        mAdapter = new ViewAdapterUnofficial(story_list, getActivity());

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
                                .title(story_list.get(position).getTagLine())
                                .content(story_list.get(position).getStory())
                                .positiveText("CLOSE")
                                .show();

                    }
                })
        );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddContentActivity.class);
                intent.putExtra("val",1);
                startActivity(intent);
            }
        });
        return view;
    }

    public ArrayList<UnofficialStory> createDumyData() {
        ArrayList<UnofficialStory> s_list = new ArrayList<UnofficialStory>();
        int[] storyId = {1, 2};
        String[] storyTitle = {"TITLE 1", "TITLE 2"};
        String[] storyTags = {"# incampus, #cs2017", "# incampus, #mech2017"};
        String[] storyDate = {"2nd April", "5th May"};
        String[] storyTime = {"2:30", "12:45"};
        String[] storyMain = {"dsasjd kdh sh dasjd sagdhsa hs hsa fdgsf dgs fdgsfd gsfd gsfds asjd hsgd hs hsa dgsd ghsadg asdgas d sahdv hsavd as asd jsd jsg dsg asd sd sdh sa asdsab as", "a sdhs dgsv dgsgds d sgd sa kasjd ksd sakjdh kajsdh jksdh ah sjhsa dsjhg"};


        for (int i = 0; i < storyId.length; i++) {
            UnofficialStory o = new UnofficialStory(storyId[i], storyTitle[i],storyDate[i], storyTime[i], storyMain[i],storyTags[i]);
            s_list.add(o);
            s_list.add(o);
            s_list.add(o);
        }
        return s_list;

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        inflater.inflate(R.menu.menu_board_unofficial, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_filter) {
            filterDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private MaterialDialog filterDialog() {

        String[] categories = {"Incampus", "PDH", "Class 2017","Dept: Mechanical","Dept: CS"};


        MaterialDialog dialog = new MaterialDialog.Builder(getActivity())
                .title("NOT INTERESTED IN")
                .customView(R.layout.dialog_customview, true)
                .positiveText("ADD")
                .negativeText("CANCEL")
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        //addFilterToList(places_list, 1);
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                    }
                }).build();

        LinearLayout linearLayoutCat = (LinearLayout) dialog.findViewById(R.id.layoutCheckBoxCategory);
        CheckBox[] checkBoxCategory = new CheckBox[categories.length];
        for (int i = 0; i < categories.length; i++) {
            checkBoxCategory[i] = new CheckBox(getActivity());
            checkBoxCategory[i].setText(categories[i]);
            checkBoxCategory[i].setChecked(false);
            checkBoxCategory[i].setTextSize(18);
            checkBoxCategory[i].setTextColor(Color.parseColor("#000000"));
        }

        LinearLayout.LayoutParams paramsCat = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsCat.topMargin = 20;

        for (int i = 0; i < categories.length; i++) {
            linearLayoutCat.addView(checkBoxCategory[i], paramsCat);
        }

        // linearLayout.addView(checkBox);
        dialog.show();
        return dialog;
    }


}
