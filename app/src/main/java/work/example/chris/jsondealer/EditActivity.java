package work.example.chris.jsondealer;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditActivity extends AppCompatActivity {

    private final static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private EditText dateEditText;

    private EditText nameEditText;

    private EditText priceEditText;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initView();
    }

    private void initView() {

        dateEditText = (EditText) findViewById(R.id.dateEditText);

        nameEditText = (EditText) findViewById(R.id.nameEditText);

        priceEditText = (EditText) findViewById(R.id.priceEditText);

        dateEditText.setText(getCurrentDate());
    }

    @SuppressWarnings("MethodMayBeStatic")
    private String getCurrentDate() {
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void add(View view) {

    }
}
