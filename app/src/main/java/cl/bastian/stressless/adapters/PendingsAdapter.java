package cl.bastian.stressless.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cl.bastian.stressless.R;
import cl.bastian.stressless.data.PendingsData;
import cl.bastian.stressless.models.Pending;

/**
 * Created by santo_000 on 27-10-2016.
 */

public class PendingsAdapter extends RecyclerView.Adapter<PendingsAdapter.ViewHolder> {

    private List<Pending> pendings = new PendingsData().notDone();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_pending, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pending pending = pendings.get(position);
        holder.name.setText(pending.getName());

    }

    @Override
    public int getItemCount() {
        return pendings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView photo;
        CheckBox status;


        ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.nameTv);
            status = (CheckBox) view.findViewById(R.id.pendingCb);

        }
    }
}
