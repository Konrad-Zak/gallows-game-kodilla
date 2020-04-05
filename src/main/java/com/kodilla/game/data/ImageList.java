package com.kodilla.game.data;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Queue;

public class ImageList implements Serializable {

    private static final long serialVersionUID = 3812000077081112222L;
    private Queue<Image> imageQueue = new ArrayDeque<>();
    private Boolean loadPictures = true;

    public ImageList()  {
        try {
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s0.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s1.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s2.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s3.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s4.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s5.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s6.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s7.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s8.jpg")));
            imageQueue.add(new Image(new FileInputStream("./src/main/resources/img/s9.jpg")));
        } catch (FileNotFoundException e){
            System.out.println("No pictures");
            loadPictures = false;
        }
    }

    public ArrayDeque<Image> getImageQueue(){
        return new ArrayDeque<>(imageQueue);
    }

    public Boolean getLoadPictures() {
        return loadPictures;
    }
}
