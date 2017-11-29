package work.example.chris.recyclerview.common;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import work.example.chris.recyclerview.R;

public class RecordHolder extends RecyclerView.ViewHolder {

    private TextView nameTextView;
    private TextView priceTextView;
    private TextView dateTextView;

    public RecordHolder(View itemView) {
        super(itemView);

        nameTextView = itemView.findViewById(R.id.nameTextView);
        priceTextView = itemView.findViewById(R.id.priceTextView);
        dateTextView = itemView.findViewById(R.id.dateTextView);
    }

    public void setNameTextView(CharSequence charSequence) {
        nameTextView.setText(charSequence);
    }

    public void setPriceTextView(CharSequence charSequence) {
        priceTextView.setText(charSequence);
    }

    public void setDateTextView(CharSequence charSequence) {
        dateTextView.setText(charSequence);
    }
}
