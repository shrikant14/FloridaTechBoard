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

import in.floridatechboard.myboard.Models.EventListing;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;

/**
 * Created by Shrikant M on 19-06-2015 at 00:29.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private ArrayList<RentListing> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtTitle;
        public TextView txtLoc;
        public TextView txtDistance;
        public TextView txtTimeToSee;
        public RatingBar ratingBar;
        public TextView txtDesc;
        public ImageView titleImage;

        public ViewHolder(View v) {

            super(v);
            txtTitle = (TextView) v.findViewById(R.id.firstLine);
            txtLoc = (TextView) v.findViewById(R.id.secondLine);
            txtDistance = (TextView) v.findViewById(R.id.tLoc);
            txtTimeToSee = (TextView) v.findViewById(R.id.tvSee);
            txtDesc = (TextView) v.findViewById(R.id.tvDesc);
            ratingBar = (RatingBar) v.findViewById(R.id.ratingBar);
            titleImage = (ImageView) v.findViewById(R.id.icon);

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
    public RecyclerViewAdapter(ArrayList<RentListing> myDataset, Context context) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);

    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_places_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String name = mDataset.get(position).getListingHeading();

        holder.txtTitle.setTypeface(tf);
        holder.txtLoc.setTypeface(tf1);
        holder.txtDistance.setTypeface(tf1);
        holder.txtTimeToSee.setTypeface(tf1);
        holder.txtDesc.setTypeface(tf1);
        holder.txtTitle.setTypeface(tf1);


        holder.txtTitle.setText(mDataset.get(position).getListingHeading());
        holder.ratingBar.setRating(2);
        holder.txtDistance.setText(mDataset.get(position).getListingPersonName() + " kms away");
        holder.txtTimeToSee.setText(mDataset.get(position).getListingPersonName()+"  hr to see");
        holder.txtDesc.setText("\"asd js jdsj dks djs das gdfs hgdfshg dfgs fdsg\"");


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

}