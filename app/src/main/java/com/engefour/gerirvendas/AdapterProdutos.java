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

/**
 * Created by Marcelo on 18/04/2017.
 */
public class AdapterProdutos extends BaseAdapter implements ListAdapter{

    private ArrayList<String> nomes = new ArrayList<String>();
    private ArrayList<String> preços = new ArrayList<String>();
    private Context context;

    public AdapterProdutos(ArrayList<String> nomes,ArrayList<String> preços, Context context) {
        this.nomes = nomes;
        this.preços = preços;
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
            view = inflater.inflate(R.layout.cell_produtos, null);
        }

        //Handle TextView and display string from your list
        TextView nome_produto = (TextView) view.findViewById(R.id.nome_produto);
        TextView textPreço =(TextView) view.findViewById(R.id.textPreço);
        nome_produto.setText(nomes.get(position));
        textPreço.setText("R$ "+preços.get(position));

        return view;
    }

}
