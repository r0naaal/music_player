package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class MusicPlayerApp extends Application {

    private Image albumImage = new Image(getClass().getResource("/images/record.png").toString());
    private ImageView albumImageView = new ImageView(albumImage);
    
    
    private Button previousSong;
    private Button play;
    private Button pause;
    private Button nextSong;
    private Button likeButton;
    private Button randomizeButton;
    private VBox actionsVBox;
    private VBox mainBox;
    private Scene mainScene;
    private HBox titleBox;
    private HBox artistBox;
    private HBox sliderBox;
    private HBox controlsBox;

    private Label titleLabel;
    private Label artistLabel;
    private Slider songSlider;
    private Button volumeButton;

    private Scene createMainScene() {
        previousSong = new Button("Previous");
        play = new Button("Play");
        pause = new Button("Pause");
        nextSong = new Button("Next");
        likeButton = new Button("Like");
        randomizeButton = new Button("R");
        volumeButton = new Button("V");

        titleLabel = new Label("Song Title");
        titleBox = new HBox(titleLabel, likeButton);
        titleBox.setAlignment(Pos.CENTER_LEFT);

        artistLabel = new Label("Artist Name");
        artistBox = new HBox(artistLabel);
        artistBox.setAlignment(Pos.CENTER_LEFT);

        songSlider = new Slider();
        sliderBox = new HBox(songSlider);
        sliderBox.setAlignment(Pos.CENTER);

        // Controls (play, pause, next, previous) and box
        controlsBox = new HBox(randomizeButton, previousSong, play, pause, nextSong, volumeButton);
        controlsBox.setAlignment(Pos.CENTER);
        controlsBox.setSpacing(5);

        // Add all boxes to actionsHBox in order
        actionsVBox = new VBox(titleBox, artistBox, sliderBox, controlsBox);
        actionsVBox.setSpacing(10);
        actionsVBox.setAlignment(Pos.CENTER);
        actionsVBox.getStyleClass().addAll("red-border");

        mainBox = new VBox(albumImageView, actionsVBox);
        mainBox.setAlignment(Pos.TOP_CENTER);
        mainBox.getStyleClass().addAll("blue-border");

        mainScene = new Scene(mainBox, 400, 500);
        mainScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        return mainScene;
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Music Player");
        primaryStage.setScene(createMainScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    
}
