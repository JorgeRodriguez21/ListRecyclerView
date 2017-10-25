package uio.androidbootcamp.listrecyclerview.adapters;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import uio.androidbootcamp.listrecyclerview.R;

/**
 * Created by jrodri on 11/7/17.
 */

public class ColorsRecyclerAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private Context context;
    private List<String> colors;
    private View.OnClickListener listener;
    private final int VIEW_ITEM = 1;

    @Override
    public int getItemViewType(int position) {
        return VIEW_ITEM;
    }


    public ColorsRecyclerAdapter(Context context, List<String> colors) {
        this.context = context;
        this.colors = colors;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public void setClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView color;
        private ConstraintLayout holderRL;

        private ViewHolder(View view) {
            super(view);
            color = view.findViewById(R.id.text_view_name);
            holderRL = view.findViewById(R.id.holderCL);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        RecyclerView.ViewHolder vh;
        v = LayoutInflater.from(context).inflate(R.layout.users_item, parent, false);
        v.setOnClickListener(this);
        vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).color.setText(colors.get(position));
        ((ViewHolder) holder).holderRL.setTag(colors.get(position));
    }

    @Override
    public int getItemCount() {
        return colors.size();
    }

}
