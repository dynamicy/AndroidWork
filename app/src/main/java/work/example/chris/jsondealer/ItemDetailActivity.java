package work.example.chris.jsondealer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import work.example.chris.jsondealer.common.BillContract;
import work.example.chris.jsondealer.model.BillRecord;

public class ItemDetailActivity extends AppCompatActivity {

    private TextView dataTextView;

    private TextView nameTextView;

    private TextView priceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        // Get bundle
//        BillRecord billRecord = (BillRecord) getIntent().getExtras().getSerializable(BillContract.BillRecordBundleKey);


        dataTextView = (TextView) this.findViewById(R.id.dateTextView);
        nameTextView = (TextView) this.findViewById(R.id.nameTextView);
        priceTextView = (TextView) this.findViewById(R.id.priceTextView);

    }

}
