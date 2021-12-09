package com.example.ex02_anotacoes_fabriciodefreitaspassamani.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ex02_anotacoes_fabriciodefreitaspassamani.Activities.MainActivity;
import com.example.ex02_anotacoes_fabriciodefreitaspassamani.R;


public class LerAnotacaoFragment extends Fragment {

    TextView lblRelatorio;



    public LerAnotacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ler_anotacao, container, false);

        lblRelatorio = view.findViewById(R.id.lblRelatorio);

        SharedPreferences sharedPreferences = getContext().getSharedPreferences(MainActivity.relatorio, Context.MODE_PRIVATE);
        lblRelatorio.setText(MainActivity.relatorio);




        return view;
    }
}