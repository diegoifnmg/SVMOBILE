package com.example.br.com.diegoalvescosta.svmobile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import br.com.diegoalvescosta.svmobile.DomainModel.Cliente;

import com.example.br.com.diegoalvescosta.DataAccess.ClienteDAO;

public class ClienteCadastroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente_cadastro);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente_cadastro, menu);
		return true;
	}

	public void Salvar(View view){
		
		EditText edtNome = (EditText) this.findViewById(R.id.edtNomeCliente);
		EditText edtCPF = (EditText) this.findViewById(R.id.edtCPF);
		EditText edtTelefone = (EditText) this.findViewById(R.id.edtTelefone);
		
		String strNome = edtNome.getText().toString().trim();
		String strCPF = edtCPF.getText().toString().trim();
		String strTelefone = edtTelefone.getText().toString().trim();
		
		
		if(strCPF.equals("") || strNome.equals("") || strTelefone.equals("")){
			Toast toast = Toast.makeText(this, "Favor preencher todos os campos!", Toast.LENGTH_LONG);
			toast.show();
		}else{
			Cliente cliente = new Cliente();
			cliente.setNome(strNome);
			cliente.setCPF(strCPF);
			cliente.setTelefone(strTelefone);
			
			ClienteDAO clienteDAO = new ClienteDAO(this);
			clienteDAO.inserir(cliente);
			
			Toast toast = Toast.makeText(this, "Cliente cadastrado com sucesso!", Toast.LENGTH_LONG);
			toast.show();

			
			edtNome.setText("");
			edtCPF.setText("");
			edtTelefone.setText("");
		}
		
		
		
	}
	
}
