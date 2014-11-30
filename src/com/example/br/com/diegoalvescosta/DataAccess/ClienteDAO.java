package com.example.br.com.diegoalvescosta.DataAccess;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.diegoalvescosta.svmobile.DomainModel.Cliente;

public class ClienteDAO {
	
	private Context context;
	
	public ClienteDAO(Context context){
		this.context = context;
	}
	
	public void inserir(Cliente cliente){
		BDUtil bdUtil = new BDUtil(this.context);
		
		ContentValues contentValues = new ContentValues();
		
		contentValues.put("NOME", cliente.getNome());
		contentValues.put("CPF", cliente.getCPF());
		contentValues.put("TELEFONE",cliente.getTelefone());
		contentValues.put("ATIVO", cliente.getAtivo());
		
		
		bdUtil.getWritableDatabase().insert("CLIENTE", null, contentValues);
		
	}
	
public List<Cliente> obterTodos(){
		
		BDUtil bdUtil = new BDUtil(this.context);
		
		String[] colunas = {"NOME", "CPF", "TELEFONE", "ATIVO"};
		
		SQLiteDatabase db = bdUtil.getReadableDatabase();
		
		Cursor c = db.query(
				"CLIENTE",  // Nome da tabela
				colunas, 	// Numero de colunas
				null,		// Clausula WHERE
				null,		// Parametros WHERE
				null,		// Group para agrupar
				null,		// Usando Haven
				"NOME"		// Ordenando pelo nome
				);
		
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		
		while(c.moveToNext()){
			Cliente cliente = new Cliente();
			
			
			cliente.setNome(c.getString(0));
			cliente.setCPF(c.getString(1));
			cliente.setTelefone(c.getString(2));
			cliente.setAtivo(c.getInt(3));
			
			listaClientes.add(cliente);
			
		}	
		return listaClientes;
	}
}
