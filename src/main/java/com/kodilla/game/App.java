package com.kodilla.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class App extends Application {

    private VBox vBox;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        File file = new File("./src/main/resources/fxml/Main.fxml");
        boolean fileExist = file.exists();

        if(fileExist){
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(this.getClass().getResource("/fxml/Main.fxml"));
            try{
                vBox = fxmlLoader.load();
            }catch (IOException e){
                System.out.println("Something have gone wrong...");
            }
        } else {

            Label label = new Label("App has broke up...try later");
            label.setFont(new Font(15));
            Button button = new Button("Exit");
            button.setOnAction(event -> Platform.exit());
            vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(20);
            vBox.setPadding(new Insets(20,20,20,20));
            vBox.getChildren().addAll(label,button);
        }

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
