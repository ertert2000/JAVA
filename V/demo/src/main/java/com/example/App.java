package com.example;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class App {

    private static final String VOICE_NAME = "kevin16";

    public static void main(String[] args)
    {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        
        try {
            // Настройка распознавания речи
            Configuration configuration = new Configuration();
            configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
            configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
            configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");

            LiveSpeechRecognizer recognizer = new LiveSpeechRecognizer(configuration);
            recognizer.startRecognition(true);

            System.out.println("Говорите что-нибудь...");

            SpeechResult result;
            while ((result = recognizer.getResult()) != null) {
                String command = result.getHypothesis();
                System.out.println("Вы сказали: " + command);
                String response = processCommand(command);
                speak(response);
            }

            recognizer.stopRecognition();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String processCommand(String command) {
        String response = "Команда не распознана.";
        if (command.contains("hello")) {
            response = "Здравствуйте! Чем могу помочь?";
        } else if (command.contains("time")) {
            response = "Сейчас " + java.time.LocalTime.now().toString();
        }
        return response;
    }

    private static void speak(String text) {
        VoiceManager voiceManager = VoiceManager.getInstance();
        Voice voice = voiceManager.getVoice(VOICE_NAME);

        if (voice != null) {
            voice.allocate();
            voice.speak(text);
            voice.deallocate();
        } else {
            System.err.println("Голос " + VOICE_NAME + " не найден.");
        }
    }
}
