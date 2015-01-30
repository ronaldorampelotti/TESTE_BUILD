package br.com.rampelotti.testetts;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import br.com.rampelotti.tts.TTS;

public class Principal extends Activity {
	
	private String[] strDados = new String[] {
			"Pegue uma budvaizer!", 
			"Pegue uma Skoll", 
			"Pegue um palet"};
	
	private int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_principal);
        
        TTS.inicializa(getApplicationContext());
        TTS.carregaVoz();
        
		findViewById(R.id.btFaleGaroto).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				if (pos == strDados.length) {
					pos = 0;
				}
				
				TTS.pronunciaTexto(strDados[pos++]);
			}
		});
    }
    
    
    @Override
    protected void onDestroy() {
    	TTS.finaliza();
    	super.onDestroy();
    }
}
