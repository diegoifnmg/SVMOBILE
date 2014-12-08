package com.example.br.com.diegoalvescosta.svmobile;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import br.com.diegoalvescosta.svmobile.DomainModel.Cliente;
import br.com.diegoalvescosta.svmobile.DomainModel.ItemVenda;
import br.com.diegoalvescosta.svmobile.DomainModel.Produto;
import br.com.diegoalvescosta.svmobile.DomainModel.Venda;

import com.example.br.com.diegoalvescosta.DataAccess.ClienteDAO;
import com.example.br.com.diegoalvescosta.DataAccess.ProdutoDAO;

public class VendasActivity extends Activity {

	private Spinner spinner1;
	private Spinner spProduto;
	private ClienteDAO cDAO = new ClienteDAO(this);
	private ProdutoDAO pDAO = new ProdutoDAO(this);
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Produto> produtos = new ArrayList<Produto>();
	private List<ItemVenda> itens = new ArrayList<ItemVenda>();	
	Venda venda = new Venda();
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_vendas);
		
		// ComboBox do Cliente
		clientes = cDAO.obterTodos();		
		spinner1 = (Spinner) findViewById(R.id.spCliente);                 
        ArrayAdapter<Cliente> dataAdapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_spinner_item,clientes);                      
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);                      
        spinner1.setAdapter(dataAdapter);
        
        // ComboBox do Produto
        produtos = pDAO.obterTodos();
        spProduto = (Spinner) findViewById(R.id.spProduto);                 
        ArrayAdapter<Produto> dataAdapterProduto = new ArrayAdapter<Produto>(this, android.R.layout.simple_spinner_item,produtos);                      
        dataAdapterProduto.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);                      
        spProduto.setAdapter(dataAdapterProduto);        
        
	}
	
	public void checkRadio(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
	    
	    // Check which radio button was clicked
	    switch(view.getId()) {
	        case R.id.vista:
	            if (checked)
	                venda.setTipo(0);
	            break;
	        case R.id.prazo:
	            if (checked)
	                venda.setTipo(1);
	            break;
	    }
	}
	
	
	public void Vender(View view){
		String nomeCliente = String.valueOf(spinner1.getSelectedItem());		
		
		for(Cliente c : clientes){
			if(c.getNome().equals(nomeCliente)){
				venda.setCliente(c);
				break;
			}
		}
		
		EditText edtNumParcelas = (EditText) this.findViewById(R.id.edtNumParcelas);
		String strNumParcelas = edtNumParcelas.getText().toString().trim();
		
		venda.setNumParcelas(Integer.parseInt(strNumParcelas));
		
		
		
		
		
		//Toast toast = Toast.makeText(this, venda.getCliente().getNome(), Toast.LENGTH_LONG);
		//toast.show();
	}
	
	public void AdicionarProduto(View view){
		String nomeProduto = String.valueOf(spProduto.getSelectedItem());
		ItemVenda item = new ItemVenda();
		boolean verificaProduto = false;
		
		ListView lstProdutos = (ListView) this.findViewById(R.id.lstProdutos);		
		List<ItemVenda> listaItens = new ArrayList<ItemVenda>();
		
		for(Produto p : produtos){
			if(p.getNome().equals(nomeProduto)){
				item.setProduto(p);
				item.setQuantidade(1);			
			}
		}		
		
		if(!itens.isEmpty()){
			for(ItemVenda i : itens){
				if(item.getProduto().getNome().equals(i.getProduto().getNome())){
					verificaProduto = true;
					break;
				}				
			}
			if(!verificaProduto){
				itens.add(item);
			}
		}
		else{
			itens.add(item);
		}		
		
		//Carregar List view
		
		listaItens = itens;
		
		ArrayAdapter<ItemVenda> adapter = new ArrayAdapter<ItemVenda>
		(   this,
			android.R.layout.simple_list_item_1,
			listaItens
		);
		lstProdutos.setAdapter(adapter);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.vendas, menu);
		return true;
	}

}
