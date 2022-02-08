package br.senai.sp.cotia.imccalcapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private EditText editPeso, editAltura;
    private Button btCalcular, btLimpar;
    private TextView tvImc, tvClassificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPeso = findViewById(R.id.edit_peso);
        editAltura = findViewById(R.id.edit_altura);
        btCalcular = findViewById(R.id.bt_calcular);
        btLimpar = findViewById(R.id.bt_limpar);
        tvImc = findViewById(R.id.tv_imc);
        tvClassificacao = findViewById(R.id.tv_classificacao);

        tvImc.setText(" ");

        btCalcular.setOnClickListener(v -> {
            // validação dos campos
            if (editPeso.getText().toString().isEmpty()){
                editPeso.setError(getString(R.string.valida_peso));
                Toast.makeText(getBaseContext(), R.string.valida_peso, Toast.LENGTH_SHORT).show();
            }else if(editAltura.getText().toString().isEmpty()){
                editAltura.setError(getString(R.string.valida_altura));
//                Snackbar.make(editAltura, R.string.valida_altura, Snackbar.LENGTH_SHORT).show();
                Toast.makeText(getBaseContext(), R.string.valida_peso, Toast.LENGTH_SHORT).show();
            }else{
                double peso, altura, imc;
                peso = Double.parseDouble(editPeso.getText().toString());
                altura = Double.parseDouble(editAltura.getText().toString());
                imc = peso / (altura*altura);

                tvImc.setText(getString(R.string.resultado, imc));

                if (imc < 16){
                    tvClassificacao.setText(R.string.magreza_severa);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.red));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                } else if (imc < 18.4){
                    tvClassificacao.setText(R.string.magreza);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.light_red));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                } else if (imc < 24.9){
                    tvClassificacao.setText(R.string.peso_adequado);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.teal_700));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                } else if (imc < 29.9){
                    tvClassificacao.setText(R.string.sobrepeso);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.yellow));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.black));
                } else if (imc < 34.9){
                    tvClassificacao.setText(R.string.obesidade_1);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.purple_200));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                } else if (imc < 39.9){
                tvClassificacao.setText(R.string.obesidade_2);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.purple_500));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                } else{
                    tvClassificacao.setText(R.string.obesidade_severa);
                    tvClassificacao.setBackgroundColor(getResources().getColor(R.color.purple_700));
                    tvClassificacao.setTextColor(getResources().getColor(R.color.white));
                }

            }
        });


        btLimpar.setOnClickListener(v ->{
        limparCampos();
        });
    }
    public void limparCampos(){
        editPeso.setText(" ");
        editAltura.setText(" ");
        editAltura.setText(" ");
        tvImc.setText(" ");
        tvClassificacao.setText(" ");
        tvClassificacao.setBackgroundColor(getResources().getColor(R.color.verde_abacate));
        editPeso.requestFocus();
    }
}