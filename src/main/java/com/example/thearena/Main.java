package com.example.thearena;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
 *   Current/In Progress Objective(s):
 *   =====================
 *
 *
 *   Short Term Objective(s):
 *   =====================
 *      =design arena scene
 *      =add functionality to arena scene - via SceneController
 *          -(can I use a different controller for arena-view??)
 *
 *   Completed Objective(s):
 *   =====================
 *      =create a GUI✓✓✓
 *
 *      =swap scenes on action event✓✓✓
 *
 *      =character creation scene✓✓✓
 *
 *      =add functionality to character creation scene - via SceneController ✓✓✓
 *          -show various stats upon selection of race + job (in progress)✓✓✓
 *              +continue working on character creation - use CharacterStats class to facilitate swapping of race/job✓✓✓
 *      =create player class✓✓✓
 *          -populate the class with necessary pojo✓✓✓
 *
 *      =fix logic error when adding job stats to race stats✓✓✓
 *
 *   Known Issues(s):
 *   =====================
 *      =when selecting a job during character select, stats can be accumulated by changing jobs
 *          - unless I code every race-job combo this might just be a "feature" ;)
 *          - possible solution: send raceArray to job for a "default" set of stats then reset stats as the job changes?
 */


/**
 * Main method that launches the program
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("welcome-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}