package cl.bastian.stressless.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import cl.bastian.stressless.R;
import cl.bastian.stressless.models.Pending;
import cl.bastian.stressless.views.main.pedingList.PendingListFragment;

public class DetailsActivity extends AppCompatActivity {

    private Pending pending;
    private EditText descriptionImput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        long pendingId = getIntent().getLongExtra(PendingListFragment.PENDING_ID,0);
        pending = Pending.findById(Pending.class, pendingId);
        getSupportActionBar().setTitle(pending.getName());
        descriptionImput = (EditText) findViewById(R.id.descriptionEt);
    }

    @Override
    protected void onResume() {
        super.onResume();
        descriptionImput.setText(pending.getDescription());
    }

    @Override
    protected void onPause() {
        String description = descriptionImput.getText().toString();
        pending.setDescription(description);
        pending.save();

        super.onPause();
    }
}
