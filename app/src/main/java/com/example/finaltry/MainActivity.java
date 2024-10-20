package com.example.finaltry;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {
    private EditText editTextInput;
    private Spinner spinner;
    private Button buttonCount;
    private TextView textViewResult;
    private TextCounter textCounter; // Instance of the TextCounter class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextInput = findViewById(R.id.editTextInput);
        spinner = findViewById(R.id.spinner);
        buttonCount = findViewById(R.id.buttonCount);
        textViewResult = findViewById(R.id.textViewResult);
        textCounter = new TextCounter();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        buttonCount.setOnClickListener(view -> {
            countText();
        });
    }
    private void countText() {
        String inputText = editTextInput.getText().toString();
        if (inputText.isEmpty()) {
            Toast.makeText(this, getString(R.string.empty_input_warning), Toast.LENGTH_SHORT).show();
            return;
        }
        String selectedOption = spinner.getSelectedItem().toString();
        int result;

        if (selectedOption.equals(getString(R.string.count_words))) {
            result = textCounter.countWords(inputText);
        } else {
            result = textCounter.countCharacters(inputText);
        }
        textViewResult.setText(getString(R.string.result_placeholder) + " " + result);
    }
}
