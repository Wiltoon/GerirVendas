package com.engefour.gerirvendas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.engefour.gerirvendas.Model.VendaModel;
import com.engefour.gerirvendas.Repository.VendaRepository;
import com.engefour.gerirvendas.Uteis.LinhaConsultarVendaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo on 09/04/2017.
 */
public class Vendas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.consultar_venda_layout, container, false);

        VendaRepository VendaRepository =  new VendaRepository(this.getActivity());
        //BUSCA AS PESSOAS CADASTRADAS
        List<VendaModel> vendas = VendaRepository.SelecionarTodos();
        ListView lView = (ListView) view.findViewById(R.id.listHistorico);
        //SETA O ADAPTER DA LISTA COM OS REGISTROS RETORNADOS DA BASE
        lView.setAdapter(new LinhaConsultarVendaAdapter(this, vendas));

    return view;
    }
}
