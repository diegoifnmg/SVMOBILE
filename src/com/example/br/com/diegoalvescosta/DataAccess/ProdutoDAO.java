package com.example.br.com.diegoalvescosta.DataAccess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.diegoalvescosta.svmobile.DomainModel.Produto;

public class ProdutoDAO {
	
	private Context context;
	
	public ProdutoDAO(Context context){
		this.context = context;
	}

	public void inserir(Produto produto){
		BDUtil bdUtil = new BDUtil(this.context);
		
		ContentValues contentValues = new ContentValues();
		
		contentValues.put("NOME", produto.getNome());
		contentValues.put("QTD", produto.getQTD());
		contentValues.put("PRECO",produto.getPreco());
		contentValues.put("ATIVO", produto.getAtivo());
		
		
		bdUtil.getWritableDatabase().insert("PRODUTO", null, contentValues);
		
	}
	
public List<Produto> obterTodos(){
		
		BDUtil bdUtil = new BDUtil(this.context);
		
		String[] colunas = {"NOME", "QTD", "PRECO", "ATIVO"};
		
		SQLiteDatabase db = bdUtil.getReadableDatabase();
		
		Cursor c = db.query(
				"PRODUTO",  // Nome da tabela
				colunas, 	// Numero de colunas
				null,		// Clausula WHERE
				null,		// Parametros WHERE
				null,		// Group para agrupar
				null,		// Usando Haven
				"NOME"		// Ordenando pelo nome
				);
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		while(c.moveToNext()){
			Produto produto = new Produto();
			
			
			produto.setNome(c.getString(0));
			produto.setQTD(c.getInt(1));
			produto.setPreco(c.getDouble(2));
			produto.setAtivo(c.getInt(3));
			
			listaProdutos.add(produto);
			
		}	
		return listaProdutos;
	}
	
}
