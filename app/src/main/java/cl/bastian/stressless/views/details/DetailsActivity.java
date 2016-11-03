package cl.bastian.stressless.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cl.bastian.stressless.R;
import cl.bastian.stressless.models.Pending;
import cl.bastian.stressless.views.main.pedingList.PendingListFragment;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long pendingId = getIntent().getLongExtra(PendingListFragment.PENDING_ID,0);

        pending = Pending.findById(Pending.class, pendingId);

        Toast.makeText(this, pending.getName(), Toast.LENGTH_SHORT).show();
    }
}
