package empresalogistica.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

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

        float porcentagem = 0;

        String estado = mSpinner.getItemAtPosition(mSpinner.getSelectedItemPosition()).toString();
        switch (estado) {
            case "Selecione o Estado:":
                Toast errorToast = Toast.makeText(this, "Erro! Selecione um Estado!", Toast.LENGTH_SHORT);
                errorToast.show();
                break;
            case "AC":
            case "MS":
            case "RO":
                porcentagem = 0.17f;
                break;
            default:
                porcentagem = 0.18f;
                break;
        }
        if(porcentagem != 0) {
            mTextViewPorcentagem.setText(String.format("Porcentagem: %.0f%%", porcentagem * 100));

            float valor = Float.parseFloat(mEditTextValor.getText().toString());
            float total = valor + (valor * porcentagem);
            mTextViewTotal.setText(String.format("Total com ICMS: R$ %.2f", total));
        }
    }
}