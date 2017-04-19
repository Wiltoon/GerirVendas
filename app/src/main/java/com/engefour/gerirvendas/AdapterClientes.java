package com.engefour.gerirvendas;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterClientes extends BaseAdapter implements ListAdapter {
    private ArrayList<String> nomes = new ArrayList<String>();
    private ArrayList<String> telefones = new ArrayList<String>();
    private ArrayList<String> dividas = new ArrayList<String>();
    private Context context;

    public AdapterClientes(ArrayList<String> nomes, ArrayList<String> telefones, ArrayList<String> dividas, Context context) {
        this.nomes = nomes;
        this.telefones = telefones;
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
            view = inflater.inflate(R.layout.cell_clientes, null);
        }

        //Handle TextView and display string from your list
        TextView nome_cliente = (TextView) view.findViewById(R.id.nome_cliente);
        TextView textDividas = (TextView) view.findViewById(R.id.textDividas);
        ImageView tel_button =(ImageView) view.findViewById(R.id.phone_button);

        nome_cliente.setText(nomes.get(position));
        tel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+telefones.get(position)));
                context.startActivity(i);
                // PARA FAZER LIGAÇÃO DIRETAMENTE (DESCOMENTAR PERMISSÃO NO MANIFEST)

//                Intent callIntent = new Intent(Intent.ACTION_CALL);
//                callIntent.setData(Uri.parse("tel:" + telefones.get(position)));
//
//                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
//                    context.startActivity(callIntent);
//                else {
//                    ActivityCompat.requestPermissions(((MainActivity) context).getParent(), new String[]{Manifest.permission.CALL_PHONE}, 1);
//                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED)
//                        context.startActivity(callIntent);
//                }
            }
        });



            String aux = dividas.get(position);
            if (aux == "0") {
                textDividas.setTextColor(Color.parseColor("#85bb65"));
                textDividas.setText("Dívidas: OK");
            } else {
                textDividas.setTextColor(Color.parseColor("#b33a3a"));
                textDividas.setText("Dívidas: " + dividas.get(position));
            }
            return view;
        }

    }