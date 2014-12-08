package com.example.br.com.diegoalvescosta.svmobile;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.diegoalvescosta.svmobile.DomainModel.Produto;
import br.com.diegoalvescosta.svmobile.DomainModel.Venda;

import com.example.br.com.diegoalvescosta.DataAccess.VendaDAO;

public class VendasListagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vendas_listagem);
		
		//Carregar List view
		ListView lstVendas = (ListView) this.findViewById(R.id.lstVendas);
		
		VendaDAO vendaDAO = new VendaDAO(this);
		List<Venda> listaVendas = vendaDAO.obterTodos();
		
		ArrayAdapter<Venda> adapter = new ArrayAdapter<Venda>
		(   this,
			android.R.layout.simple_list_item_1,
			listaVendas
		);
		lstVendas.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vendas_listagem, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_Venda:
			Intent intent = new Intent(this,VendasActivity.class);
			this.startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	
}
