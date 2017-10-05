package work.example.chris.jsondealer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.model.BillRecord;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView dateTextView;

    private TextView nameTextView;

    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        BillRecord billRecord = getIntent().getParcelableExtra(BillContract.BillRecordBundleKey);

        initState(billRecord);
    }

    private void initState(BillRecord billRecord) {
        dateTextView = (TextView) this.findViewById(R.id.dateTextView);
        nameTextView = (TextView) this.findViewById(R.id.nameTextView);
        priceTextView = (TextView) this.findViewById(R.id.priceTextView);

        dateTextView.setText(billRecord.getCdate());
        nameTextView.setText(billRecord.getName());
        priceTextView.setText(String.valueOf(billRecord.getPrice()));
    }

}
