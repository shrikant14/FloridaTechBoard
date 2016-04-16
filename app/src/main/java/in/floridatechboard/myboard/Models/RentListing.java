package in.floridatechboard.myboard.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Shrikant M on 13-04-2016 at 20:50.
 */
public class RentListing implements Parcelable {

    private int listingId;
    private String listingHeading;
    private String listingCost;
    private String listingStartedDate;
    private String listingPostingDate;
    private String listingPersonName;
    private String listingDesc;

    public RentListing(int listingId, String listingPersonName, String listingPostingDate, String listingStartedDate, String listingHeading, String listingCost) {
        this.listingId = listingId;
        this.listingPersonName = listingPersonName;
        this.listingPostingDate = listingPostingDate;
        this.listingStartedDate = listingStartedDate;
        this.listingHeading = listingHeading;
        this.listingCost = listingCost;
    }
    public RentListing(int listingId, String listingPersonName, String listingPostingDate, String listingStartedDate, String listingHeading, String listingCost,String listingDesc) {
        this.listingId = listingId;
        this.listingPersonName = listingPersonName;
        this.listingPostingDate = listingPostingDate;
        this.listingStartedDate = listingStartedDate;
        this.listingHeading = listingHeading;
        this.listingCost = listingCost;
        this.listingDesc=listingDesc;
    }

    public String getListingDesc() {
        return listingDesc;
    }

    public void setListingDesc(String listingDesc) {
        this.listingDesc = listingDesc;
    }

    public String getListingPersonName() {
        return listingPersonName;
    }

    public void setListingPersonName(String listingPersonName) {
        this.listingPersonName = listingPersonName;
    }

    public String getListingPostingDate() {
        return listingPostingDate;
    }

    public void setListingPostingDate(String listingPostingDate) {
        this.listingPostingDate = listingPostingDate;
    }

    public String getListingStartedDate() {
        return listingStartedDate;
    }

    public void setListingStartedDate(String listingStartedDate) {
        this.listingStartedDate = listingStartedDate;
    }

    public String getListingCost() {
        return listingCost;
    }

    public void setListingCost(String listingCost) {
        this.listingCost = listingCost;
    }

    public String getListingHeading() {
        return listingHeading;
    }

    public void setListingHeading(String listingHeading) {
        this.listingHeading = listingHeading;
    }

    public int getListingId() {
        return listingId;
    }

    public void setListingId(int listingId) {
        this.listingId = listingId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeInt(listingId);
        parcel.writeString(listingHeading);
        parcel.writeString(listingCost);
        parcel.writeString(listingStartedDate);
        parcel.writeString(listingPostingDate);
        parcel.writeString(listingPersonName);

    }


    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public RentListing createFromParcel(Parcel in) {
            return new RentListing(in);
        }

        public RentListing[] newArray(int size) {
            return new RentListing[size];
        }
    };

    private RentListing(Parcel parcel) {

        listingId = parcel.readInt();
        listingHeading = parcel.readString();
        listingCost = parcel.readString();
        listingStartedDate = parcel.readString();
        listingPostingDate = parcel.readString();
        listingPersonName = parcel.readString();

    }
}
