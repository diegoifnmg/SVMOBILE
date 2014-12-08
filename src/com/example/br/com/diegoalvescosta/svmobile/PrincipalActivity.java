package com.example.br.com.diegoalvescosta.svmobile;



import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;


public class PrincipalActivity extends Activity {

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		// listener handler
        View.OnClickListener handler = new View.OnClickListener(){
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.btnShowNotification:
                        showNotification();
                        break;

                    case R.id.btnCancelNotification:
                        cancelNotification(0);
                        break;
                }
            }
        };

        // we will set the listeners
        findViewById(R.id.btnShowNotification).setOnClickListener(handler);
        findViewById(R.id.btnCancelNotification).setOnClickListener(handler);

    }

    public void showNotification(){

        // define sound URI, the sound to be played when there's a notification
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        // intent triggered, you can add other intent for other actions
        Intent intent = new Intent(PrincipalActivity.this, ParcelasActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(PrincipalActivity.this, 0, intent, 0);

        // this is it, we'll build the notification!
        // in the addAction method, if you don't want any icon, just set the first param to 0
        Notification mNotification = new Notification.Builder(this)

            .setContentTitle("Parcelas!")
            .setContentText("Existem Parcelas em Atraso!")
            .setSmallIcon(R.drawable.ic_launcher)
            .setContentIntent(pIntent)
            .setSound(soundUri)

            .addAction(R.drawable.ic_launcher, "Olhar", pIntent)
            .addAction(0, "", pIntent)

            .build();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // If you want to hide the notification after it was selected, do the code below
        // myNotification.flags |= Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(0, mNotification);
    }

    public void cancelNotification(int notificationId){

        if (Context.NOTIFICATION_SERVICE!=null) {
            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager nMgr = (NotificationManager) getApplicationContext().getSystemService(ns);
            nMgr.cancel(notificationId);
        }
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
		
		Intent intentNovaTela = new Intent(this, CaixaActivity.class);
		this.startActivity(intentNovaTela);
	
	}
	
	public void Venda(View view){
		Intent intentNovaTela = new Intent(this, VendasActivity.class);
		this.startActivity(intentNovaTela);
	}
	

}

