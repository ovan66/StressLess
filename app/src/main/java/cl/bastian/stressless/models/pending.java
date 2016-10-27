package cl.bastian.stressless.models;

import com.orm.SugarRecord;

/**
 * Created by santo_000 on 26-10-2016.
 */

public class pending extends SugarRecord {

    private String name, description;
    private boolean done;

    public pending() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
