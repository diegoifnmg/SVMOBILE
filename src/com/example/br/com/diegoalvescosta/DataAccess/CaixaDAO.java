package com.example.br.com.diegoalvescosta.DataAccess;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import br.com.diegoalvescosta.svmobile.DomainModel.Caixa;

public class CaixaDAO {
	
	private Context context;
	
	public CaixaDAO(Context context){
		this.context = context;
	}
	
	public void inserir(Caixa caixa){
		BDUtil bdUtil = new BDUtil(this.context);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		ContentValues contentValues = new ContentValues();
		
		contentValues.put("SALDO", caixa.getSaldo());
		contentValues.put("DATA", formatter.format(new java.sql.Date(caixa.getDataCaixa().getTime())));
		
		
		
		bdUtil.getWritableDatabase().insert("CAIXA", null, contentValues);
		
	}
	
	public List<Caixa> obterTodos() throws ParseException{
		
		BDUtil bdUtil = new BDUtil(this.context);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String[] colunas = {"SALDO", "DATA"};
		
		SQLiteDatabase db = bdUtil.getReadableDatabase();
		
		Cursor c = db.query(
				"CAIXA",  // Nome da tabela
				colunas, 	// Numero de colunas
				null,		// Clausula WHERE
				null,		// Parametros WHERE
				null,		// Group para agrupar
				null,		// Usando Haven
				"DATA"		// Ordenando pelo nome
				);
		
		List<Caixa> listaCaixas = new ArrayList<Caixa>();
		
		while(c.moveToNext()){
			Caixa caixa = new Caixa();
			
			
			caixa.setSaldo(c.getDouble(0));
			caixa.setDataCaixa(converteStringToDate(c.getString(1)));
			
			
			listaCaixas.add(caixa);
			
		}	
		return listaCaixas;
	}
	
	
	public Date converteStringToDate(String strData) throws ParseException  {
		Date data;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		data = formatter.parse(strData);

		return data;
	}

}
