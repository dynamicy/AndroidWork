package work.example.chris.jsondealer.component;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class BillDataViewHolder extends RecyclerView.ViewHolder {

    private TextView dataTextView;

    private TextView nameTextView;

    private TextView priceTextView;

    public BillDataViewHolder(View itemView) {
        super(itemView);
    }

    public TextView getDataTextView() {
        return dataTextView;
    }

    public void setDataTextView(TextView dataTextView) {
        this.dataTextView = dataTextView;
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
