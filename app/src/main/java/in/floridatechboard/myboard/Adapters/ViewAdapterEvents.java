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
import in.floridatechboard.myboard.Models.UnofficialStory;
import in.floridatechboard.myboard.R;

/**
 * Created by Shrikant M on 16-04-2016 at 15:04.
 */
public class ViewAdapterEvents extends RecyclerView.Adapter<ViewAdapterEvents.ViewHolder> {

    private ArrayList<Events> mDataset;
    String fontPath = "fonts/Aller_Bd.ttf";
    String fontPath1 = "fonts/Sansation-Light.ttf";
    Typeface tf, tf1;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ViewAdapterEvents(ArrayList<Events> myDataset, Context context) {
        mDataset = myDataset;
        tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        tf1 = Typeface.createFromAsset(context.getAssets(), fontPath1);

    }

    @Override
    public ViewAdapterEvents.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_events, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewAdapterEvents.ViewHolder holder, int position) {

        holder.eventTitle.setTypeface(tf);
        holder.eventOn.setTypeface(tf1);
        holder.eventAt.setTypeface(tf1);
        holder.eventDetails.setTypeface(tf1);
        holder.eventTags.setTypeface(tf1);

        holder.eventTitle.setText(mDataset.get(position).getEventTitle());
        holder.eventOn.setText("ON "+mDataset.get(position).getEventDate()+" "+mDataset.get(position).getEventTime());
        holder.eventAt.setText("AT "+mDataset.get(position).getEventPlace());
        holder.eventDetails.setText(mDataset.get(position).getEventDetails());
        holder.eventTags.setText(mDataset.get(position).getEventTags());

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView eventTitle;
        public TextView eventOn;
        public TextView eventAt;
        public TextView eventDetails;
        public TextView eventTags;

        public ViewHolder(View v) {

            super(v);
            eventTitle = (TextView) v.findViewById(R.id.eventTitle);
            eventOn = (TextView) v.findViewById(R.id.eventDate);
            eventAt = (TextView) v.findViewById(R.id.eventPlace);
            eventDetails = (TextView) v.findViewById(R.id.eventDetails);
            eventTags = (TextView) v.findViewById(R.id.eventHashTags);
        }
    }
}
