package com.example.br.com.diegoalvescosta.DataAccess;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDUtil extends SQLiteOpenHelper{

	private static final String NOME_BD = "SVMOBILE";
	private static final int VERSAO = 1;

	private static final String TABELA_PRODUTO = "PRODUTO";
	private static final String TABELA_CLIENTE = "CLIENTE";
	private static final String TABELA_CAIXA = "CAIXA";

	// Construtor.........................................................
	public BDUtil(Context context) {
		super(context, NOME_BD, null, VERSAO);
		// TODO Auto-generated constructor stub
	}

	// onCreate...........................................................
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String ddlProduto = "CREATE TABLE " + TABELA_PRODUTO
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT, "
				+ "QTD INTEGER, "
				+ "preco DOUBLE, "
				+ "ativo INTEGER"
				+ " )";

		db.execSQL(ddlProduto);
		
		String ddlCliente = "CREATE TABLE " + TABELA_CLIENTE
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "nome TEXT, "
				+ "cpf VARCHAR, "
				+ "telefone VARCHAR, "
				+ "ativo INTEGER"
				+ " )";

		db.execSQL(ddlCliente);
		
		String ddlCaixa = "CREATE TABLE " + TABELA_CAIXA
				+ "(codigo INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ "saldo DOUBLE, "
				+ "data, DATE)";

		db.execSQL(ddlCaixa);
		
	}
		
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	
}
