package work.example.chris.jsondealer.component;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import work.example.chris.jsondealer.R;

public class BillDataViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTextView;

    private TextView nameTextView;

    private TextView priceTextView;

    public BillDataViewHolder(View itemView) {

        super(itemView);

        dateTextView = itemView.findViewById(R.id.dateTextView);
        nameTextView = itemView.findViewById(R.id.nameTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
    }

    public TextView getDateTextView() {
        return dateTextView;
    }

    public void setDateTextView(TextView dateTextView) {
        this.dateTextView = dateTextView;
    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public void setNameTextView(TextView nameTextView) {
        this.nameTextView = nameTextView;
    }

    public TextView getPriceTextView() {
        return priceTextView;
    }

    public void setPriceTextView(TextView priceTextView) {
        this.priceTextView = priceTextView;
    }
}
