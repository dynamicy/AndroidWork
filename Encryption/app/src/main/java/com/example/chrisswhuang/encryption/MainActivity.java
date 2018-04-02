package com.example.chrisswhuang.encryption;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String[] types = {"AES", "BLOWFISH"};

    private Spinner spinner;

    private EditText originalMessage;

    private EditText encrypted_message;

    private int typeId;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        initSpinner();

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
        originalMessage = findViewById(R.id.originalMessage);
        encrypted_message = findViewById(R.id.encrypted_message);
    }

    private void initSpinner() {
        spinner = findViewById(R.id.spinner);

        final ArrayAdapter<String> typeList = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, types);
        spinner.setAdapter(typeList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                typeId = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                String tempMsg = originalMessage.getText().toString();
                if (types[typeId].equals("AES")) {
                    encrypted_message.setText(Encryption.getInstance().encryptAES(tempMsg, "test key"));

                } else {
                    encrypted_message.setText(Encryption.getInstance().encryptBlowFish(tempMsg, "test key"));
                }

                break;
            default:
                break;
        }
    }
}
