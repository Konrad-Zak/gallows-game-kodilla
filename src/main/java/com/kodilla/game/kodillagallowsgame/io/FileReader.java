package com.kodilla.game.kodillagallowsgame.io;

import com.kodilla.game.kodillagallowsgame.model.GameWindowModel;
import com.kodilla.game.kodillagallowsgame.model.SettingsMenuModel;

import java.io.*;

public class FileReader {

    public SettingsMenuModel readSettingsModel(){

        SettingsMenuModel settingsMenuModel = new SettingsMenuModel();
        try{

            FileInputStream fileInputStream = new FileInputStream(FileWriter.SETTINGS_FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            settingsMenuModel = (SettingsMenuModel) objectInputStream.readObject();
            System.out.println("File read");

        } catch (ClassNotFoundException | IOException e){
            e.getStackTrace();
        }
        return settingsMenuModel;
    }

    public GameWindowModel readGameStatus(){

        GameWindowModel gameWindowModel = new GameWindowModel();
        try{

            FileInputStream fileInputStream = new FileInputStream(FileWriter.GAME_STATUS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            gameWindowModel = (GameWindowModel) objectInputStream.readObject();
            System.out.println("File read");

        } catch (ClassNotFoundException | IOException e){
            e.getStackTrace();
        }
        return gameWindowModel;
    }

}
