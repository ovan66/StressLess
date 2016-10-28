package cl.bastian.stressless.data;

import java.util.ArrayList;
import java.util.List;

import cl.bastian.stressless.models.Pending;

/**
 * Created by santo_000 on 27-10-2016.
 */

public class PendingsData {

    public List<Pending> notDone() {
        List<Pending> pendings = new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class, "done = 0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }
        return pendings;
    }
}
