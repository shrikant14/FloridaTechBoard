package in.floridatechboard.myboard.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import in.floridatechboard.myboard.Models.Events;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;

/**
 * Created by Shrikant M on 16-04-2016 at 17:08.
 */
public class ViewAdapterMarketplace extends RecyclerView.Adapter<ViewAdapterMarketplace.ViewHolder> {
    private ArrayList<RentListing> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;
    int con = 0;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewAdapterMarketplace(ArrayList<RentListing> myDataset, Context context, int con) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);
        this.con = con;
    }

    @Override
    public ViewAdapterMarketplace.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_marketplace, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewAdapterMarketplace.ViewHolder holder, int position) {

        holder.itemTitle.setTypeface(tf);
        holder.itemPosted.setTypeface(tf1);
        holder.itemOwner.setTypeface(tf1);
        holder.itemPrice.setTypeface(tf1);
        holder.itemTags.setTypeface(tf1);
        holder.itemDesc.setTypeface(tf1);


        if (con == 1) {
            // Rent Listing
            holder.itemTitle.setText(mDataset.get(position).getListingHeading());
            holder.itemPosted.setText("From " + mDataset.get(position).getListingStartedDate());
            holder.itemOwner.setText("By " + mDataset.get(position).getListingPersonName());
            holder.itemPrice.setText("For " + mDataset.get(position).getListingCost());
            holder.itemTags.setText("");
            holder.itemDesc.setText(mDataset.get(position).getListingDesc());

        } else if (con == 5) {
            //Rent Posting
            holder.itemIcon.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView itemTitle;
        public TextView itemPosted;
        public TextView itemOwner;
        public TextView itemPrice;
        public TextView itemTags;
        public TextView itemDesc;
        public ImageView itemIcon;


        public ViewHolder(View v) {

            super(v);
            itemTitle = (TextView) v.findViewById(R.id.itemTitle);
            itemPosted = (TextView) v.findViewById(R.id.itemPostedOn);
            itemOwner = (TextView) v.findViewById(R.id.itemSeller);
            itemPrice = (TextView) v.findViewById(R.id.itemPricec);
            itemTags = (TextView) v.findViewById(R.id.itemTags);
            itemDesc = (TextView) v.findViewById(R.id.itemDesc);
            itemIcon = (ImageView) v.findViewById(R.id.icon);
        }
    }
}
