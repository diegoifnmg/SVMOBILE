package com.example.br.com.diegoalvescosta.svmobile;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CaixaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caixa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.caixa, menu);
		return true;
	}

}
