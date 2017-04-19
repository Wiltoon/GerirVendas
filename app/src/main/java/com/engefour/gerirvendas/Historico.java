package com.engefour.gerirvendas;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Marcelo on 09/04/2017.
 */
public class Historico extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.historico_layout, container, false);

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
        ArrayList<String> datas = new ArrayList<String>();
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");
        datas.add("18/04/2017 às 17:43");


        //generate list
        ArrayList<String> dividas = new ArrayList<String>();
        dividas.add("0");
        dividas.add("300,00");
        dividas.add("400,00");
        dividas.add("0");
        dividas.add("27,00");
        dividas.add("2,00");
        dividas.add("1000000");
        dividas.add("8,00");
        dividas.add("0,50");

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

        AdapterHistorico adapter = new AdapterHistorico(nomes,datas,dividas,preços,getActivity());

        //handle listview and assign adapter
        ListView lView = (ListView) view.findViewById(R.id.listHistorico);
        lView.setAdapter(adapter);
    return view;
    }
}
