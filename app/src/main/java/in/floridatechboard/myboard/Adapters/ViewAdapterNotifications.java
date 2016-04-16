package in.floridatechboard.myboard.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import in.floridatechboard.myboard.Models.Events;
import in.floridatechboard.myboard.Models.RentListing;
import in.floridatechboard.myboard.R;

/**
 * Created by Shrikant M on 16-04-2016 at 16:32.
 */
public class ViewAdapterNotifications extends RecyclerView.Adapter<ViewAdapterNotifications.ViewHolder> {

    private ArrayList<RentListing> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewAdapterNotifications(ArrayList<RentListing> myDataset, Context context) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);

    }
    @Override
    public ViewAdapterNotifications.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_notifications, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewAdapterNotifications.ViewHolder holder, int position) {
        holder.notifyTitle.setTypeface(tf);
        holder.notifyDetails.setTypeface(tf1);
        holder.notifyTags.setTypeface(tf1);


       // holder.notifyTitle.setText(mDataset.get(position).getEventTitle());
       // holder.notifyDetails.setText("ON "+mDataset.get(position).getEventDate()+" "+mDataset.get(position).getEventTime());
       // holder.notifyTags.setText("AT "+mDataset.get(position).getEventPlace());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView notifyTitle;
        public TextView notifyDetails;
        public TextView notifyTags;


        public ViewHolder(View v) {

            super(v);
            notifyTitle = (TextView) v.findViewById(R.id.notifyTitle);
            notifyDetails = (TextView) v.findViewById(R.id.notifyDetails);
            notifyTags = (TextView) v.findViewById(R.id.notifyHashTags);

        }
    }
}
