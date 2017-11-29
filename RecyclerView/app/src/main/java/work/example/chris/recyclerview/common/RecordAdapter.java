package work.example.chris.recyclerview.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import work.example.chris.recyclerview.R;
import work.example.chris.recyclerview.model.Record;

public class RecordAdapter extends RecyclerView.Adapter<RecordHolder> {

    private Context mContext;
    private List<Record> dataLists;

    public RecordAdapter(List<Record> dataLists) {
        this.dataLists = dataLists;
    }

    @Override
    public RecordHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();

        View view = LayoutInflater.from(mContext).inflate(R.layout.list_record, parent, false);
        RecordHolder recordHolder = new RecordHolder(view);
        return recordHolder;
    }

    @Override
    public void onBindViewHolder(RecordHolder holder, int position) {
        String name = dataLists.get(position).getName();
        String date = dataLists.get(position).getCdate();
        int price = dataLists.get(position).getPrice();

        holder.setNameTextView(name);
        holder.setPriceTextView(String.valueOf(price));
        holder.setDateTextView(date);
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }
}
