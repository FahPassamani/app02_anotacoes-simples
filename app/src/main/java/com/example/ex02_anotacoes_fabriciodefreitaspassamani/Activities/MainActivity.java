package com.example.ex02_anotacoes_fabriciodefreitaspassamani.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ex02_anotacoes_fabriciodefreitaspassamani.Fragments.CriarAnotacaoFragment;
import com.example.ex02_anotacoes_fabriciodefreitaspassamani.Fragments.LerAnotacaoFragment;
import com.example.ex02_anotacoes_fabriciodefreitaspassamani.R;

public class MainActivity extends AppCompatActivity {

    public static String relatorio;
    public static SharedPreferences sharedPreferences;
    Button btnCriarAnotacoes, btnVerAnotacao;
    CriarAnotacaoFragment criarAnotacaoFragment;
    LerAnotacaoFragment lerAnotacaoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCriarAnotacoes = findViewById(R.id.btnCriarAnotacoes);
        btnVerAnotacao = findViewById(R.id.btnVerAnotacoes);

        criarAnotacaoFragment = new CriarAnotacaoFragment();
        lerAnotacaoFragment = new LerAnotacaoFragment();

        // Nome do arquivo SharedPref
        String nameFile = "anotacoesShared";
        sharedPreferences = getSharedPreferences(nameFile, Context.MODE_PRIVATE);

        // Buscar SharedPref
        relatorio = sharedPreferences.getString("dados", "Nenhum texto salvo");


        btnCriarAnotacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFragment(criarAnotacaoFragment);
            }
        });

        btnVerAnotacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirFragment(lerAnotacaoFragment);
            }
        });
    }

    private void abrirFragment(Fragment fragment) {
        // Criar uma transação
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // Informar o recurso que irá receber o fragment
        transaction.replace(R.id.frameLayout, fragment);
        // Consolidar a transação
        transaction.commit();
    }

}