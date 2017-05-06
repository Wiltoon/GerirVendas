package com.engefour.gerirvendas.Uteis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    //NOME DA BASE DE DADOS
    private static final String NOME_BASE_DE_DADOS   = "Banco.db";

    //VERSÃO DO BANCO DE DADOS
    private static final int    VERSAO_BASE_DE_DADOS = 9;

    //CONSTRUTOR
    public DataBase(Context context){

        super(context,NOME_BASE_DE_DADOS,null,VERSAO_BASE_DE_DADOS);
    }

    /*NA INICIALIZAÇÃO DA CLASSE VAMOS CRIAR A TABELA QUE VAMOS USAR*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_cliente (");
        stringBuilderCreateTable.append("        id_cliente     INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_nome        TEXT    NOT NULL     UNIQUE,            ");
        stringBuilderCreateTable.append("        ds_email       TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_telefone    TEXT    NOT NULL )           ");

        db.execSQL(stringBuilderCreateTable.toString());

        StringBuilder stringBuilderCreateTable2 = new StringBuilder();

        stringBuilderCreateTable2.append(" CREATE TABLE tb_produto (");
        stringBuilderCreateTable2.append("        id_produto     INTEGER  PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable2.append("        ds_nome        TEXT     NOT NULL     UNIQUE,            ");
        stringBuilderCreateTable2.append("        ds_valor       FLOAT    NOT NULL )           ");

        db.execSQL(stringBuilderCreateTable2.toString());

        StringBuilder stringBuilderCreateTable3 = new StringBuilder();

        stringBuilderCreateTable3.append(" CREATE TABLE tb_venda (");
        stringBuilderCreateTable3.append("        id_venda          INTEGER  PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable3.append("        ds_quantidade     INTEGER  NOT NULL,            ");
        stringBuilderCreateTable3.append("        ds_valor_total    FLOAT    NOT NULL,            ");
        stringBuilderCreateTable3.append("        ds_valor_pago     FLOAT    NOT NULL,            ");
        stringBuilderCreateTable3.append("        ds_saldo          FLOAT    NOT NULL,            ");
        stringBuilderCreateTable3.append("        ds_nome_cliente        TEXT  NOT NULL,            ");
        stringBuilderCreateTable3.append("        ds_nome_produto        TEXT  NOT NULL,            ");
        stringBuilderCreateTable3.append("        FOREIGN KEY    (ds_nome_cliente) REFERENCES tb_cliente(ds_nome),");
        stringBuilderCreateTable3.append("        FOREIGN KEY    (ds_nome_produto) REFERENCES tb_produto(ds_nome) )");

        db.execSQL(stringBuilderCreateTable3.toString());

    }

    /*SE TROCAR A VERSÃO DO BANCO DE DADOS VOCÊ PODE EXECUTAR ALGUMA ROTINA
      COMO CRIAR COLUNAS, EXCLUIR ENTRE OUTRAS */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tb_cliente");
        db.execSQL("DROP TABLE IF EXISTS tb_produto");
        db.execSQL("DROP TABLE IF EXISTS tb_venda");
        onCreate(db);

    }

    /*MÉTODO QUE VAMOS USAR NA CLASSE QUE VAI EXECUTAR AS ROTINAS NO
    BANCO DE DADOS*/
    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }
}
