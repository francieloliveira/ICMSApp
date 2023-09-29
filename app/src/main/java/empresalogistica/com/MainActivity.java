package empresalogistica.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

public class MainActivity extends AppCompatActivity {

    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSpinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.estados, android.R.layout.simple_spinner_item);
        mSpinner.setAdapter(adapter);

        mEditTextValor = findViewById(R.id.editTextValor);
        mTextViewPorcentagem = findViewById(R.id.textViewPorcentagem);
        mTextViewTotal = findViewById(R.id.textViewTotal);
    }

    public void calcular(View view) {

        float porcentagem;

        String estado = mSpinner.getItemAtPosition(mSpinner.getSelectedItemPosition()).toString();
        switch (estado) {
            case "AC":
            case "MS":
            case "RO":
                porcentagem = 0.17f;
                break;
            default:
                porcentagem = 0.18f;
                break;
        }

        mTextViewPorcentagem.setText(String.format("%.0f%%", porcentagem * 100));

        float valor = Float.parseFloat(mEditTextValor.getText().toString());
        float total = valor + (valor * porcentagem);

        mTextViewTotal.setText(String.format("Total com ICMS: R$ %.2f", total));
    }


}