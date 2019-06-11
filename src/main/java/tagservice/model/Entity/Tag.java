package tagservice.model.entity;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "TIMES_USED")
    private long timesUsed;

    @Column(name = "TAG_STRING")
    private String tagString;

    public Tag(long timesUsed, String tagString) {
        this.timesUsed = timesUsed;
        this.tagString = tagString;
    }

    public long getId() {
        return id;
    }

    public long getTimesUsed() {
        return timesUsed;
    }

    public String getTagString() {
        return tagString;
    }

    public void incrementTimesUsed(){
        this.timesUsed++;
    }
}
