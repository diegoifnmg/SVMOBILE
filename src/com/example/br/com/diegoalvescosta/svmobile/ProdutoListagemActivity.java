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

import com.example.br.com.diegoalvescosta.DataAccess.ProdutoDAO;

public class ProdutoListagemActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produto_listagem);
		
		//Carregar List view
				ListView lstProdutos = (ListView) this.findViewById(R.id.lstProdutos);
				
				ProdutoDAO produtoDAO = new ProdutoDAO(this);
				List<Produto> listaProdutos = produtoDAO.obterTodos();
				
				ArrayAdapter<Produto> adapter = new ArrayAdapter<Produto>
				(   this,
					android.R.layout.simple_list_item_1,
					listaProdutos
				);
				lstProdutos.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.produto_listagem, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
		case R.id.action_novo_produto:
			Intent intent = new Intent(this,ProdutoCadastroActivity.class);
			this.startActivity(intent);
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
		
	}

}
