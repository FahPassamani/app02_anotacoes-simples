package com.example.ex02_anotacoes_fabriciodefreitaspassamani.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ex02_anotacoes_fabriciodefreitaspassamani.Activities.MainActivity;
import com.example.ex02_anotacoes_fabriciodefreitaspassamani.R;
import com.example.ex02_anotacoes_fabriciodefreitaspassamani.Util.AudioPlayer;


public class CriarAnotacaoFragment extends Fragment {

    Button btnSalvar;
    EditText editTextMultiLine;

    public CriarAnotacaoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_criar_anotacao, container, false);

        btnSalvar = view.findViewById(R.id.btnSalvar);
        editTextMultiLine = view.findViewById(R.id.editTextMultiLine);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarSharedPref();
            }
        });

        return view;
    }

    public void salvarSharedPref() {
        if (!editTextMultiLine.getText().toString().equals("")) {
            // Se não estiver vazio
            SharedPreferences.Editor editor = MainActivity.sharedPreferences.edit();
            MainActivity.relatorio = editTextMultiLine.getText().toString();
            editor.putString("dados", MainActivity.relatorio);
            editor.commit();
            Toast.makeText(getContext().getApplicationContext(),"Dados salvos com sucesso!", Toast.LENGTH_LONG).show();
            editTextMultiLine.getText().clear();
            AudioPlayer.playAudio(getContext(), R.raw.ok);

        } else {
            Toast.makeText(getContext().getApplicationContext(), "Preencha o campo anotações", Toast.LENGTH_LONG).show();
            AudioPlayer.playAudio(getContext(), R.raw.no);
        }
    }

}