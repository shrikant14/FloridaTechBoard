package in.floridatechboard.myboard.Models;

/**
 * Created by Shrikant M on 16-04-2016 at 15:47.
 */
public class Events {

    private int eventId;
    private String eventSender;
    private String eventCC;
    private String eventDate;
    private String eventTitle;
    private String eventTime;
    private String eventSentDate;
    private String eventSentTime;
    private String eventPlace;
    private String eventDetails;
    private String eventTags;

    public Events(int eventId, String eventSender, String eventDate, String eventTime, String eventPlace, String eventDetails, String eventTags, String eventTitle) {
        this.eventId = eventId;
        this.eventSender = eventSender;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventPlace = eventPlace;
        this.eventDetails = eventDetails;
        this.eventTags=eventTags;
        this.eventTitle=eventTitle;
    }
    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }


    public String getEventTags() {
        return eventTags;
    }

    public void setEventTags(String eventTags) {
        this.eventTags = eventTags;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventSentDate() {
        return eventSentDate;
    }

    public void setEventSentDate(String eventSentDate) {
        this.eventSentDate = eventSentDate;
    }

    public String getEventSentTime() {
        return eventSentTime;
    }

    public void setEventSentTime(String eventSentTime) {
        this.eventSentTime = eventSentTime;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }



    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventSender() {
        return eventSender;
    }

    public void setEventSender(String eventSender) {
        this.eventSender = eventSender;
    }

    public String getEventCC() {
        return eventCC;
    }

    public void setEventCC(String eventCC) {
        this.eventCC = eventCC;
    }
}
