package br.com.rampelotti.tts;

import java.util.Locale;

/**
 * Classe para controle de constantes comuns para parametrização da pronúncia
 * 
 * @author ronaldo.rampelotti
 *
 */
public class PronunciaSetup {

	// Idioma utilizado pelo sintetizador
	public static Locale IDIOMA = new Locale("por", "BRA");
	
	// Tom da voz utilizada pelo sintetizador 0.0 ~ >= 1.0 Sendo 1.0 normal
	public static float TOM = 1.0f;
	
	// Velocidade que vai ser pronunciado pelo sintetizador 0.0 ~ >0 1.0 Onde quanto maior o valor mais acelerado fica
	public static float VELOCIDADE = 1.0f;
	
	// Tempo em milessegundos para que o dispositivo fique vibrando
	public static int TEMPO_VIBRAR = 1000;

}
