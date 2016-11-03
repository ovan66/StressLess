package cl.bastian.stressless.views.main;

import cl.bastian.stressless.models.Pending;

/**
 * Created by santo_000 on 27-10-2016.
 */

public class PendingValidation {

    private CreateCallback callback;

    public PendingValidation(CreateCallback callback) {
        this.callback = callback;
    }

    public void init(String name){
        if (name.trim().length()>0) {
            Pending pending = new Pending();
            pending.setName(name);
            pending.setDone(false);
            pending.save();
            callback.succes(pending);
        }else{
            callback.fail();
        }
    }

}
