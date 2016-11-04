package cl.bastian.stressless.views.main.pedingList;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.bastian.stressless.R;
import cl.bastian.stressless.adapters.PendingsAdapter;
import cl.bastian.stressless.models.Pending;
import cl.bastian.stressless.views.details.DetailsActivity;

import static android.R.attr.name;

/**
 * A placeholder fragment containing a simple view.
 */
public class PendingListFragment extends Fragment implements PendingListListener{

    public static final String PENDING_ID = "PENDING_ID";

    private PendingsAdapter pendingsAdapter;

    public PendingListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pending_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.pendingRv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        pendingsAdapter = new PendingsAdapter(this);
        recyclerView.setAdapter(pendingsAdapter);
        final SwipeRefreshLayout refreshLayout = (SwipeRefreshLayout) view;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pendingsAdapter.reset();
                        refreshLayout.setRefreshing(false);

                    }
                },800);

            }
        });
    }

    public void addPending(Pending pending){
        pendingsAdapter.add(pending);

    }

    @Override
    public void click(long id) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(PENDING_ID,id);
        startActivity(intent);

    }

    public void search (String name){
        pendingsAdapter.search(name);
    }
}
