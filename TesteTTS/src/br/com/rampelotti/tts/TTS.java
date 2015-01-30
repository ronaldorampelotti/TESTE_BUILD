package br.com.rampelotti.tts;

import java.util.Locale;

import android.content.Context;
import android.media.AudioManager;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;

/**
 * Classe manipuladora do Google Text To Speech
 * 
 * @author ronaldo.rampelotti
 */
public class TTS {
	
	private static TextToSpeech tts;
	
	private static Context appContext;
	
	/**
	 * Método para inicializar a ferramenta de pronuncia
	 */
	private static void inicializaPronuncia() {
		tts = new TextToSpeech(appContext, new OnInitListener() {
			public void onInit(int status) {
				if (status == TextToSpeech.SUCCESS) {
					// Baixa o pacote de pronúncia em PT/BR
					tts.setLanguage(new Locale("pt","BR"));
					tts.setEngineByPackageName("com.google.android.tts");
					
					Log.d(getClass().getSimpleName(), "Inicializou TTS com sucesso!");
				} else {
					Log.d(getClass().getSimpleName(), "Inicializou TTS com erro!");
				}
				
			}
		});
		
	}
	
	public static void carregaVoz() {
		//atribuiVolume(0f);
		tts.speak("a", TextToSpeech.QUEUE_FLUSH, null);
	}
	
	/**
	 * Método para pronuncia do dispositivo
	 * 
	 * @param textoParaPronuncia texto que deve ser pronunciado
	 */
	public static void pronunciaTexto (String textoParaPronuncia) {

		atribuiVolume(0.7f);
		
		// Tom da voz
		tts.setPitch(PronunciaSetup.TOM);
		
		// Velocidade de pronuncia
		tts.setSpeechRate(PronunciaSetup.VELOCIDADE);
		
		// Sintetizador pronuncia o texto enviado
		tts.speak(textoParaPronuncia, TextToSpeech.QUEUE_FLUSH, null);
		
	}
	
	private static void atribuiVolume(float percentualVolume){
		// Volume da pronuncia
		AudioManager am = (AudioManager)appContext.getSystemService(Context.AUDIO_SERVICE);
		int amStreamMusicMaxVol = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		am.setStreamVolume(AudioManager.STREAM_MUSIC, (int)(amStreamMusicMaxVol * percentualVolume), 0);
	}
	
	public static void finaliza() {
		if (tts != null) {
			tts.shutdown();
			tts = null;
		}
	}


	public static void inicializa(Context ctx) {
		appContext = ctx;
		if (tts == null) {
			inicializaPronuncia();
		}
	}

}
