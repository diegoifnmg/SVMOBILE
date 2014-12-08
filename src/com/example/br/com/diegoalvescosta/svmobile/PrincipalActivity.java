package com.example.br.com.diegoalvescosta.svmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class PrincipalActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}
	
	public void Produto(View view){
	
		Intent intentNovaTela = new Intent(this, ProdutoListagemActivity.class);
		this.startActivity(intentNovaTela);
	
	}
	
	public void Cliente(View view){
		
		Intent intentNovaTela = new Intent(this, ClienteListagemActivity.class);
		this.startActivity(intentNovaTela);
	
	}
	
	public void Caixa(View view){
		
		Intent intentNovaTela = new Intent(this, CaixaListagemActivity.class);
		this.startActivity(intentNovaTela);
	
	}
	
	public void Venda(View view){
		Intent intentNovaTela = new Intent(this, VendasActivity.class);
		this.startActivity(intentNovaTela);
	}
	

}
