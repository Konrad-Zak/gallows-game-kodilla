package com.kodilla.game.kodillagallowsgame.io;

import com.kodilla.game.kodillagallowsgame.model.SettingsMenuModel;

import java.io.*;

public class FileWriter {

    public void settingsWrite(SettingsMenuModel settingsMenuModel){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FileCreator.SETTINGS_FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(settingsMenuModel);
            System.out.println("zapisano");
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("blad");
        }

    }



}
