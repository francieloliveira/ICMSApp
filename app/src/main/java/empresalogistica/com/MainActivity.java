package empresalogistica.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;

    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = findViewById(R.id.autocompleteTextView);
        String[] items = {"RS", "SC", "PR", "AC", "MS", "RO", "AL", "AM", "AP", "BA",
                "CE", "DF", "ES", "GO", "MA", "MT", "MG", "PA", "PB", "PE", "PI",
                "RJ", "RN", "RR", "SP", "SE", "TO"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);
        autoCompleteTextView.setAdapter(adapter);

        mEditTextValor = findViewById(R.id.editTextValor);
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        mTextViewTotal = findViewById(R.id.textViewTotal);
    }

    public void calcular(View view) {
        float porcentagem = 0;
        String estado = autoCompleteTextView.getText().toString();

        switch (estado) {
            case "AC":
            case "MS":
            case "RO":
                porcentagem = 0.17f;
                break;
            case "AL":
            case "PR":
            case "AM":
            case "AP":
            case "BA":
            case "CE":
            case "DF":
            case "ES":
            case "GO":
            case "MA":
            case "MT":
            case "MG":
            case "PA":
            case "PB":
            case "PE":
            case "PI":
            case "RJ":
            case "RN":
            case "RS":
            case "RR":
            case "SC":
            case "SP":
            case "SE":
            case "TO":
                porcentagem = 0.18f;
                break;
            default:
                break;
        }

        mTextViewPorcentagem.setText(String.format("%.2f%%", porcentagem));

        float valor = Float.parseFloat(mEditTextValor.getText().toString());
        float total = valor * porcentagem;

        mTextViewTotal.setText(String.format("Total: %s", total));
    }


}