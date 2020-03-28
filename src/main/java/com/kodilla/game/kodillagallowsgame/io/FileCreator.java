package com.kodilla.game.kodillagallowsgame.io;

import java.io.File;
import java.io.IOException;

public class FileCreator {
    public final static String SETTINGS_FILE_NAME = "./src/main/resources/file/SettingsMenu.obj";
    private File file = new File(SETTINGS_FILE_NAME);

    public void createSettingsFile(){

        boolean fileExists =  settingsFileExists();
        if (!fileExists) {
            try {
                fileExists = file.createNewFile();
            } catch (IOException e) {
                System.out.println("Nie udało się utworzyć pliku");
            }
        }

        if (fileExists)
            System.out.println("Plik istnieje lub zostal utworzony");
    }

    public boolean settingsFileExists(){
        return file.exists();
    }

}
