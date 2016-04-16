package in.floridatechboard.myboard.Models;

/**
 * Created by Shrikant M on 15-04-2016 at 22:57.
 */
public class UnofficialStory {
    private int id;
    private String TagLine;
    private String postedDate;
    private String postedTime;
    private String tags;
    private String story;

    public String getTagLine() {
        return TagLine;
    }

    public UnofficialStory(int id, String tagLine, String postedDate, String postedTime, String story, String tags) {
        this.id = id;
        TagLine = tagLine;
        this.postedDate = postedDate;
        this.postedTime = postedTime;
        this.story = story;
        this.tags = tags;
    }

    public void setTagLine(String tagLine) {
        TagLine = tagLine;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public String getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(String postedTime) {
        this.postedTime = postedTime;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
