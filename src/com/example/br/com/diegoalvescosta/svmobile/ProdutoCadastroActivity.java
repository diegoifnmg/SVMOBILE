package com.example.br.com.diegoalvescosta.svmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.diegoalvescosta.svmobile.DomainModel.Produto;

import com.example.br.com.diegoalvescosta.DataAccess.ProdutoDAO;



public class ProdutoCadastroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produto_cadastro);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.produto_cadastro, menu);
		return true;
	}

	public void Salvar(View view){		
	
		
		
		EditText edtNome = (EditText) this.findViewById(R.id.txtNomeProduto);
		EditText edtQuantidadeEstoque = (EditText) this.findViewById(R.id.edtQuantidadeProduto);
		EditText edtPreco = (EditText) this.findViewById(R.id.edtPreco);
	
		String strNome = edtNome.getText().toString().trim();
		String strQuantidadeEstoque = edtQuantidadeEstoque.getText().toString().trim();
		String strPreco = edtPreco.getText().toString().trim();
		
		if(strQuantidadeEstoque.equals("") || strNome.equals("") || strPreco.equals("")){
			Toast toast = Toast.makeText(this, "Favor preencher todos os campos!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			Produto produto = new Produto();
			produto.setNome(strNome);
			produto.setQTD(Integer.parseInt(strQuantidadeEstoque));
			produto.setPreco(Double.parseDouble(strPreco));
			
			ProdutoDAO produtoDAO = new ProdutoDAO(this);
			produtoDAO.inserir(produto);
			
			Toast toast = Toast.makeText(this, "Produto cadastrado com sucesso!", Toast.LENGTH_LONG);
			toast.show();

			
			edtNome.setText("");
			edtQuantidadeEstoque.setText("");
			edtPreco.setText("");
			
			Intent intentNovaTela = new Intent(this, PrincipalActivity.class);
			this.startActivity(intentNovaTela);
			
		}
		
		
	}
	
}
