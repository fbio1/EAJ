package com.example.pichau.conheaeaj20.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.pichau.conheaeaj20.Setor;
import com.fabio.eaj.conheaeaj.R;


public class FragmentSetor extends Fragment {

    private TextView nomeSetor;
    private TextView horario;
    private TextView descricao;
    private TextView email;
    private TextView telefone;
    private TextView responsavel;
    private TextView longitude;
    private TextView latitude;
    private TextView flag;
    private ImageView imagemSetor;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.conteudo_layout_setor, container, false);

        Intent i = getActivity().getIntent();
        Setor s = (Setor) i.getSerializableExtra("objSetor");

        recuperarIds(view);

        nomeSetor.setText(s.getNomeSetor());
        horario.setText(s.getHorarioFuncionamento());
        email.setText(s.getEmailResponsavel());
        telefone.setText(s.getTelefone());
        responsavel.setText(s.getNomeResponsavel());
        descricao.setText(s.getDescricao());
        imagemSetor.setImageResource(s.getImageFragment());
        longitude.setText(""+ s.getLongitude());
        latitude.setText(""+s.getLatitude());
        flag.setText("true");
        return view;
    }


    void recuperarIds(View view){
        nomeSetor = view.findViewById(R.id.nomeSetorDetalhes);
        horario = view.findViewById(R.id.horarioSetorDetalhes);
        descricao = view.findViewById(R.id.descricaoSetorDetalhes);
        email = view.findViewById(R.id.emailSetorDetalhes);
        responsavel = view.findViewById(R.id.responsavelSetorDetalhes);
        telefone = view.findViewById(R.id.telefoneSetorDetalhes);
        longitude = view.findViewById(R.id.longitude);
        latitude = view.findViewById(R.id.latitude);
        flag = view.findViewById(R.id.flag);
        imagemSetor = getActivity().findViewById(R.id.image_toolbar_layout);
    }
}
