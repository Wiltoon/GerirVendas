package com.engefour.gerirvendas;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Marcelo on 09/04/2017.
 */
public class Clientes extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.clientes_layout, container, false);


        //generate list
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("João do Feijão");
        nomes.add("Marcelo Amarelo");
        nomes.add("Caique Cacique");
        nomes.add("Paris Wilton");
        nomes.add("Ikaro Bárbaro");
        nomes.add("Fucking Fuchs");
        nomes.add("João Ninguém");
        nomes.add("João Ninguém");
        nomes.add("João Ninguém");

        //generate list
        ArrayList<String> telefones = new ArrayList<String>();
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");
        telefones.add("993123621");


        //generate list
        ArrayList<String> dividas = new ArrayList<String>();
        dividas.add("0");
        dividas.add("300");
        dividas.add("400");
        dividas.add("0");
        dividas.add("27");
        dividas.add("2");
        dividas.add("1000000");
        dividas.add("8");
        dividas.add("0.5");

        AdapterClientes adapter = new AdapterClientes(nomes,telefones,dividas,getActivity());

        //handle listview and assign adapter
        ListView lView = (ListView) view.findViewById(R.id.listClientes);
        lView.setAdapter(adapter);
        return view;
    }
}
