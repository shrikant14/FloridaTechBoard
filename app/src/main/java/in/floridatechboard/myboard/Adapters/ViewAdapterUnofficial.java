package in.floridatechboard.myboard.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import in.floridatechboard.myboard.Models.UnofficialStory;
import in.floridatechboard.myboard.R;

/**
 * Created by Shrikant M on 14-04-2016 at 18:20.
 */
public class ViewAdapterUnofficial extends RecyclerView.Adapter<ViewAdapterUnofficial.ViewHolder> {

    private ArrayList<UnofficialStory> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tagLine;
        public TextView postedOn;
        public TextView hashTags;
        public TextView story;

        public ViewHolder(View v) {

            super(v);
            tagLine = (TextView) v.findViewById(R.id.title);
            postedOn = (TextView) v.findViewById(R.id.postedOn);
            hashTags = (TextView) v.findViewById(R.id.hashTags);
            story = (TextView) v.findViewById(R.id.story);

        }
    }

    public void add(int position, String item) {
//        mDataset.add(position, item);
//        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mDataset.indexOf(item);
        mDataset.remove(position);
        notifyItemRemoved(position);
    }


    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewAdapterUnofficial(ArrayList<UnofficialStory> myDataset, Context context) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);

    }

    @Override
    public ViewAdapterUnofficial.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_unofficial_list, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       // final String name = mDataset.get(position).getListingHeading();

        holder.tagLine.setTypeface(tf);
        holder.postedOn.setTypeface(tf1);
        holder.hashTags.setTypeface(tf1);
        holder.story.setTypeface(tf1);

        holder.tagLine.setText(mDataset.get(position).getTagLine());
        holder.postedOn.setText("3hrs ago");
        holder.hashTags.setText(mDataset.get(position).getTags());
        holder.story.setText(mDataset.get(position).getStory());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
