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
 * Created by Shrikant M on 16-04-2016 at 18:24.
 */
public class ViewAdapterGallery extends RecyclerView.Adapter<ViewAdapterGallery.ViewHolder> {
    private ArrayList<RentListing> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewAdapterGallery(ArrayList<RentListing> myDataset, Context context) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);

    }


    @Override
    public ViewAdapterGallery.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_gallery, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewAdapterGallery.ViewHolder holder, int position) {
        holder.gallertTitle.setTypeface(tf);

       // holder.gallertTitle.setText(mDataset.get(position).getEventTitle());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView gallertTitle;
        public ImageView galleryIcon;

        public ViewHolder(View v) {

            super(v);
            gallertTitle = (TextView) v.findViewById(R.id.galleryTitle);
            galleryIcon = (ImageView) v.findViewById(R.id.galleryIcon);

        }
    }
}
