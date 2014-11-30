package com.example.br.com.diegoalvescosta.svmobile;

import java.text.ParseException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.diegoalvescosta.svmobile.DomainModel.Caixa;

import com.example.br.com.diegoalvescosta.DataAccess.CaixaDAO;

public class CaixaListagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caixa_listagem);
		
		//Carregar List view
				ListView lstCaixas = (ListView) this.findViewById(R.id.lstCaixaListagem);
				
				CaixaDAO caixaDAO = new CaixaDAO(this);
				List<Caixa> listaCaixas = null;
				try {
					listaCaixas = caixaDAO.obterTodos();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				ArrayAdapter<Caixa> adapter = new ArrayAdapter<Caixa>
				(   this,
					android.R.layout.simple_list_item_1,
					listaCaixas
				);
				lstCaixas.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.caixa_listagem, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_novo_caixa:
			Intent intent = new Intent(this,CaixaActivity.class);
			this.startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
