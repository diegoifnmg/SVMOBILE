package com.example.br.com.diegoalvescosta.svmobile;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import br.com.diegoalvescosta.svmobile.DomainModel.Cliente;

import com.example.br.com.diegoalvescosta.DataAccess.ClienteDAO;

public class ClienteListagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente_listagem);
		
		//Carregar List view
		ListView lstClientes = (ListView) this.findViewById(R.id.lstClienteListagem);
		
		ClienteDAO clienteDAO = new ClienteDAO(this);
		List<Cliente> listaClientes = clienteDAO.obterTodos();
		
		ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>
		(   this,
			android.R.layout.simple_list_item_1,
			listaClientes
		);
		lstClientes.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente_listagem, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_novo_cliente:
			Intent intent = new Intent(this,ClienteCadastroActivity.class);
			this.startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}
	

}
