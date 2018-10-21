package base.android.material;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private MessageContainer container = new MessageContainer();
    {
        container.add("Hello!");
        container.add("It's Recycler");
        container.add("View");
    }
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        ListViewHolder viewHolder = new ListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.setText(container.get(position));
    }
    @Override
    public int getItemCount() {
        return container.len();
    }
    public void append(String text){
        container.add(text + " " + System.currentTimeMillis());
        notifyDataSetChanged();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;
        ListViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
        }
        void setText(String text){
            textView.setText(text);
        }
    }
}
