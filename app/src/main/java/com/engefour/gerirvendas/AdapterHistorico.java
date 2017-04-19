package com.engefour.gerirvendas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHistorico extends BaseAdapter implements ListAdapter {
    private ArrayList<String> nomes = new ArrayList<String>();
    private ArrayList<String> datas = new ArrayList<String>();
    private ArrayList<String> preços = new ArrayList<String>();
    private ArrayList<String> dividas = new ArrayList<String>();
    private Context context;

    public AdapterHistorico(ArrayList<String> nomes, ArrayList<String> datas, ArrayList<String> dividas,ArrayList<String> preços, Context context) {
        this.nomes = nomes;
        this.datas = datas;
        this.preços = preços;
        this.dividas = dividas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return nomes.size();
    }

    @Override
    public Object getItem(int pos) {
        return nomes.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.cell_historico, null);
        }

        //Handle TextView and display string from your list
        TextView nome_cliente = (TextView) view.findViewById(R.id.nome_cliente);
        TextView textDivida = (TextView) view.findViewById(R.id.textDivida);
        TextView textPreço =(TextView) view.findViewById(R.id.textPreço);
        TextView textData = (TextView) view.findViewById(R.id.textData);
        nome_cliente.setText(nomes.get(position));
        String aux = dividas.get(position);
        if (aux == "0") {
            textDivida.setTextColor(Color.parseColor("#85bb65"));
            textDivida.setText("OK");
        } else {
            textDivida.setTextColor(Color.parseColor("#b33a3a"));
            textDivida.setText("- R$ " + dividas.get(position));
        }
        textPreço.setText("R$ "+preços.get(position));
        textData.setText(datas.get(position));

        return view;
    }

}
