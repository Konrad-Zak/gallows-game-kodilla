package com.kodilla.game.io;


import java.io.*;

public class FileWriter {

    public final static String SETTINGS_FILE_NAME = "./src/main/resources/file/SettingsMenu.obj";
    public final static String GAME_STATUS = "./src/main/resources/file/GameStatus.obj";

    public void settingsWrite(Object object){
        writeFile(object,SETTINGS_FILE_NAME);
    }

    public void gameStatusWrite(Object object){
        writeFile(object,GAME_STATUS);
    }

    private void writeFile(Object object,String string){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(string);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);
            System.out.println("File save");
            fileOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error saving");
        }
    }


}
