package com.engefour.gerirvendas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Marcelo on 09/04/2017.
 */
public class Produtos extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.produtos_layout, container, false);
        ArrayList<String> nomes = new ArrayList<String>();
        nomes.add("30");
        nomes.add("Produto 2");
        nomes.add("Produto 3");
        nomes.add("Produto 4");
        nomes.add("Produto 5");
        nomes.add("Produto 6");
        nomes.add("Produto 7");
        nomes.add("Produto 8");
        nomes.add("Produto 9");
        nomes.add("Produto 10");
        nomes.add("Produto 11");
        nomes.add("Produto 12");
        nomes.add("Produto 13");
        nomes.add("Produto 14");
        nomes.add("Produto 15");
        nomes.add("Produto 16");


        ArrayList<String> preços = new ArrayList<String>();
        preços.add("300,00");
        preços.add("500,00");
        preços.add("400,00");
        preços.add("100,00");
        preços.add("30,00");
        preços.add("10,00");
        preços.add("99999999,00");
        preços.add("508,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");
        preços.add("1,00");

        AdapterProdutos adapter = new AdapterProdutos(nomes,preços,getActivity());

        //handle listview and assign adapter
        ListView lView = (ListView) view.findViewById(R.id.listProdutos);
        lView.setAdapter(adapter);
        return view;
    }
}
