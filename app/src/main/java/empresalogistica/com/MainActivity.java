package empresalogistica.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText mEditTextValor;
    private TextView mTextViewPorcentagem;
    private TextView mTextViewTotal;
    private Spinner mSpinner;
    final Locale locale = new Locale("pt", "BR");


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

    public void calcularICMS(View view) {

        float porcentagem = 0;

        String estado = mSpinner.getItemAtPosition(mSpinner.getSelectedItemPosition()).toString();
        switch (estado) {
            case "Selecione um Estado:":
                Toast errorToast = Toast.makeText(this, "Você precisa selecionar um Estado!", Toast.LENGTH_SHORT);
                errorToast.show();
                break;
            case "Acre":
            case "Alagoas":
            case "Espírito Santo":
            case "Goiás":
            case "Mato Grosso":
            case "Mato Grosso do Sul":
            case "Pará":
            case "Piauí":
            case "Rio Grande do Sul":
            case "Roraima":
            case "Santa Catarina":
                porcentagem = 0.17f;
                break;
            case "Rondônia":
                porcentagem = 0.175f;
                break;
            default:
                porcentagem = 0.18f;
                break;
        }

        try {
            float valor = Float.parseFloat(mEditTextValor.getText().toString());
            mTextViewPorcentagem.setText(String.format(locale, "Porcentagem: %.0f%%", porcentagem * 100));
            float total = valor + (valor * porcentagem);
            mTextViewTotal.setText(String.format(locale, "Total com ICMS: R$ %.2f", total));
        } catch (NumberFormatException e) {
            Toast errorToast = Toast.makeText(this, "Por favor, insira um valor do produto!", Toast.LENGTH_SHORT);
            errorToast.show();
        }

    }
}