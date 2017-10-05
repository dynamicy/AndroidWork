package work.example.chris.jsondealer.component;

import android.app.LoaderManager;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.example.chris.jsondealer.R;
import work.example.chris.jsondealer.model.BillRecord;

public class BillDataRecyclerViewAdapter extends RecyclerView.Adapter<BillDataViewHolder> {

    private final static String TAG = BillDataRecyclerViewAdapter.class.getSimpleName();

    private Cursor cursor;

    @Override
    public BillDataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_bill_data, parent, false);
        return new BillDataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BillDataViewHolder holder, int position) {

        cursor.moveToPosition(position);

        BillRecord billRecord = new BillRecord(cursor);

        holder.getDataTextView().setText(billRecord.getCdate());
        holder.getNameTextView().setText(billRecord.getName());
        holder.getPriceTextView().setText(String.valueOf(billRecord.getPrice()));

    }

    @Override
    public int getItemCount() {
        if (cursor != null) {
            return cursor.getCount();
        } else {
            return 0;
        }
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }
}
