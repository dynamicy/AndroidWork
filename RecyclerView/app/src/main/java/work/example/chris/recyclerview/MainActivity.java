package work.example.chris.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import work.example.chris.recyclerview.common.RecordAdapter;
import work.example.chris.recyclerview.model.Record;
import work.example.chris.recyclerview.utils.JsonHelper;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize recyclerView
        initRecyclerView();
    }

    protected void onStart() {
        super.onStart();

        List<Record> recordList = JsonHelper.getModelFromRaw(this).getRecord();

        setupRecyclerView(recordList);
    }

    private void setupRecyclerView(List<Record> recordList) {
        RecordAdapter adapter = new RecordAdapter(recordList);
        recyclerView.setAdapter(adapter);
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
