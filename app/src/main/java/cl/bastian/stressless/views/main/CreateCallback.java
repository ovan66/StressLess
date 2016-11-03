package cl.bastian.stressless.views.main;

import android.print.PageRange;

import cl.bastian.stressless.models.Pending;

/**
 * Created by santo_000 on 27-10-2016.
 */

public interface CreateCallback {

    void succes(Pending pending);
    void fail();

}
