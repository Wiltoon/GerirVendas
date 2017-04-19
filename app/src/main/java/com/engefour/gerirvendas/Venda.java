package com.engefour.gerirvendas;

/**
 * Created by Marcelo on 09/04/2017.
 */
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

public class Venda extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.venda_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //generate list
        ArrayList<String> list = new ArrayList<String>();
        list.add("Produto 1");
        list.add("Produto 2");
        list.add("Produto 3");
        list.add("Produto 4");
        list.add("Produto 5");
        list.add("Produto 6");
        list.add("Produto 7");
        list.add("Produto 8");
        list.add("Produto 9");
        list.add("Produto 10");
        list.add("Produto 11");
        list.add("Produto 12");
        list.add("Produto 13");
        list.add("Produto 14");
        list.add("Produto 15");
        list.add("Produto 16");


        //instantiate custom adapter
        AdapterVenda adapter = new AdapterVenda(list, this);

        //handle listview and assign adapter
        ListView lView = (ListView)findViewById(R.id.listVendas);
        lView.setAdapter(adapter);
        View v = View.inflate(this, R.layout.header_vendas,null);

        Spinner spinner = (Spinner) v.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapterr = ArrayAdapter.createFromResource(this,R.array.clientes_array, android.R.layout.simple_spinner_item);
        adapterr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       spinner.setAdapter(adapterr);
        ImageView button_add = (ImageView) v.findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Venda.this,NovoCliente.class);
                startActivity(i);
            }
        });
       lView.addHeaderView(v);

        final Button salvar = new Button(this);
        salvar.setText("Salvar");

        lView.addFooterView(salvar);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
