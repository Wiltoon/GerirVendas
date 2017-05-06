package com.engefour.gerirvendas.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import com.engefour.gerirvendas.Model.ProdutoModel;
import com.engefour.gerirvendas.Uteis.DataBase;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class ProdutoRepository {
    DataBase databaseUtil;

    /***
     * CONSTRUTOR
     * @param context
     */
    public ProdutoRepository(Context context){

        databaseUtil =  new DataBase(context);
    }

    /***
     * SALVA UM NOVO REGISTRO NA BASE DE DADOS
     * @param pessoaModel
     */
    public void Salvar(ProdutoModel pessoaModel){

        ContentValues contentValues =  new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/
        contentValues.put("ds_nome",        pessoaModel.getNome());
        contentValues.put("ds_valor",       pessoaModel.getValor());

        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("tb_produto",null,contentValues);
    }
    /***
     * ATUALIZA UM REGISTRO JÁ EXISTENTE NA BASE
     * @param pessoaModel
     */
    public void Atualizar(ProdutoModel pessoaModel){

        ContentValues contentValues =  new ContentValues();

        /*MONTA OS PARAMENTROS PARA REALIZAR UPDATE NOS CAMPOS*/
        contentValues.put("ds_nome",        pessoaModel.getNome());
        contentValues.put("ds_valor",       pessoaModel.getValor());

        /*REALIZANDO UPDATE PELA CHAVE DA TABELA*/
        databaseUtil.GetConexaoDataBase().update("tb_produto", contentValues, "id_produto = ?", new String[]{Integer.toString(pessoaModel.getCodigo())});
    }

    /***
     * EXCLUI UM REGISTRO PELO CÓDIGO
     * @param codigo
     * @return
     */
    public Integer Excluir(int codigo){

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("tb_produto","id_produto = ?", new String[]{Integer.toString(codigo)});
    }

    /***
     * CONSULTA UMA PESSOA CADASTRADA PELO CÓDIGO
     * @param codigo
     * @return
     */
    public ProdutoModel GetPessoa(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_produto WHERE id_produto= "+ codigo,null);

        cursor.moveToFirst();

        ///CRIANDO UMA NOVA PRODUTO
        ProdutoModel pessoaModel =  new ProdutoModel();

        //ADICIONANDO OS DADOS DO PRODUTO
        pessoaModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_produto")));
        pessoaModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
        pessoaModel.setValor(cursor.getFloat(cursor.getColumnIndex("ds_valor")));

        //RETORNANDO A PESSOA
        return pessoaModel;
    }

    /***
     * CONSULTA TODAS AS PESSOAS CADASTRADAS NA BASE
     * @return
     */
    public List<ProdutoModel> SelecionarTodos(){

        List<ProdutoModel> pessoas = new ArrayList<ProdutoModel>();

        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_produto,      ");
        stringBuilderQuery.append("        ds_nome,         ");
        stringBuilderQuery.append("        ds_valor         ");
        stringBuilderQuery.append("  FROM  tb_produto       ");
        stringBuilderQuery.append(" ORDER BY ds_nome        ");

        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();

        ProdutoModel pessoaModel;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            pessoaModel =  new ProdutoModel();

            //ADICIONANDO OS DADOS DA PESSOA
            pessoaModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_produto")));
            pessoaModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
            pessoaModel.setValor(cursor.getFloat(cursor.getColumnIndex("ds_valor")));

            //ADICIONANDO UMA PESSOA NA LISTA
            pessoas.add(pessoaModel);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return pessoas;

    }
    public boolean produto_existe(String nome_produto){

        boolean produto_existe = TRUE;
        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_produto WHERE ds_nome= '"+ nome_produto+"'",null);
        cursor.moveToFirst();
        if(cursor.isAfterLast())
            produto_existe = FALSE;

        return produto_existe;
    }
    public List<String> SelecionarNomes(){

        List<String> produtos = new ArrayList<String>();

        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT ds_nome      ");
        stringBuilderQuery.append("  FROM  tb_produto      ");

        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();


        String NomeProduto;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            NomeProduto =  new String();

            //ADICIONANDO OS DADOS DA PESSOA
            NomeProduto=cursor.getString(cursor.getColumnIndex("ds_nome"));

            //ADICIONANDO UMA PESSOA NA LISTA
            produtos.add(NomeProduto);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return produtos;
    }
    public Float consultarPreço(String nome, int quantidade){

        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT ds_valor      ");
        stringBuilderQuery.append("  FROM  tb_produto      ");
        stringBuilderQuery.append("  WHERE ds_nome = '" +nome+"'");

        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);
        Float ValorProduto = null;
        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ValorProduto = new Float(0);//ADICIONANDO OS DADOS DA PESSOA
            ValorProduto=cursor.getFloat(cursor.getColumnIndex("ds_valor"));
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        double aux = ValorProduto * Float.valueOf(quantidade);
        String aux2 = String.valueOf(aux);
        return Float.valueOf(aux2);
    }
}