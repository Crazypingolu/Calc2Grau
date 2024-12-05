package br.edu.fateczlcalc2grau;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    controller obj = new controller();

    private TextView tvRaiz1;
    private TextView tvRaiz2;
    private TextView tvAvisos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Variável -> ações da interface
        EditText etNumA = findViewById(R.id.etNumA);
        EditText etNumB = findViewById(R.id.etNumB);
        EditText etNumC = findViewById(R.id.etNumC);
        tvRaiz1 = findViewById(R.id.tvRaiz1);
        tvRaiz2 = findViewById(R.id.tvRaiz2);
        tvAvisos = findViewById(R.id.tvAvisos);
        Button btnVerificar = findViewById(R.id.btnVerificar);
        // conversão de variáveis
        float numA = Float.parseFloat(etNumA.getText().toString());
        float numB = Float.parseFloat(etNumB.getText().toString());
        float numC = Float.parseFloat(etNumC.getText().toString());
        // Aciona o botão
        btnVerificar.setOnClickListener(op -> verifica(numA, numB, numC));

    }

    public void verifica(float a, float b, float c){
        tvAvisos.setText(" ");
        String resp = " ";
        if (a != 0){
            float delta = obj.calcDelta(a, b, c);
            if (delta > 0){
                float raiz1 = obj.calcRaiz(delta, a, b, false);
                float raiz2 = obj.calcRaiz(delta, a, b, true);
                resp = getText(R.string.raiz1) + " " + raiz1;
                tvRaiz1.setText(resp);
                resp = getText(R.string.raiz1) + " " + raiz2;
                tvRaiz2.setText(resp);
            } else if (delta == 0) {
                float raiz = obj.calcRaiz(delta, a, b, false);
                resp = getText(R.string.raiz1) + " " + raiz;
                tvRaiz1.setText(resp);
                tvRaiz2.setText(resp);
            } else {
                String aviso = getString(R.string.aviso) + " Não existe Raíz.";
                tvAvisos.setText(aviso);
            }
        } else {
            String aviso = getString(R.string.aviso) + " Não é uma equação de 2º grau.";
            tvAvisos.setText(aviso);
        }
    }
}