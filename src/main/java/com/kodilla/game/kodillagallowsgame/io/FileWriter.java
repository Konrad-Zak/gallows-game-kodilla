package com.kodilla.game.kodillagallowsgame.io;


import java.io.*;

public class FileWriter {

    public final static String SETTINGS_FILE_NAME = "./src/main/resources/file/SettingsMenu.obj";
    public final static String GAME_STATUS = "./src/main/resources/file/GameStatus.obj";

    private File fileSettings = new File(SETTINGS_FILE_NAME);
    private File fileGame = new File(GAME_STATUS);

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
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Error saving");
        }
    }

    public boolean settingsFileExists(){
        return fileSettings.exists();
    }

    public boolean gameStatusFileExists(){
        return fileGame.exists();
    }



}
