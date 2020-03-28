package com.kodilla.game.kodillagallowsgame.io;

import com.kodilla.game.kodillagallowsgame.model.SettingsMenuModel;

import java.io.*;

public class FileWriter {
    public final static String SETTINGS_FILE_NAME = "./src/main/resources/file/SettingsMenu.obj";
    private File fileSettings = new File(SETTINGS_FILE_NAME);

    public void settingsWrite(SettingsMenuModel settingsMenuModel){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(SETTINGS_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(settingsMenuModel);
            System.out.println("File save");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error saving");
        }

    }

    public boolean settingsFileExists(){
        return fileSettings.exists();
    }



}
