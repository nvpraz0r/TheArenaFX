package com.example.thearena;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * This method controls all user interaction
 * */
public class SceneController implements Initializable {
    private Stage stage;
    private Scene scene;
//    private Parent root;

    @FXML
    private Label hpLabel;

    @FXML
    private Label atkLabel;

    @FXML
    private Label defLabel;

    @FXML
    private Label agilLabel;

    @FXML
    private Label mAtkLabel;

    @FXML
    private Label mDefLabel;

    @FXML
    private ChoiceBox<String> raceChoiceBox = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> jobChoiceBox = new ChoiceBox<>();

    @FXML
    private String[] races = {"Human", "Dwarf", "Elvan"};

    @FXML
    private String[] jobs = {"Fighter", "Rogue", "Wizard"};


    /**
     * This method switches the scene from welcome-view to creation-view
     * */
    public void switchToCreation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("creation-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method switches the scene from creation-view to arean-view
     * */
    public void switchToArena(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("arena-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * This method monitors change in the choice boxes raceChoiceBox and jobChoiceBox
     * If any change is detected
     * */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
//        raceChoiceBox to show all available races
        raceChoiceBox.getItems().addAll(races);
//        once interacted with the raceChoice box will
        raceChoiceBox.setOnAction(this::getRace);

//        jobChoiceBox to show all available jobs
        jobChoiceBox.getItems().addAll(jobs);
        jobChoiceBox.setOnAction(this::getJob);
    }

    /**
     * This method detects the user's choice in the raceChoiceBox
     * Then sends necessary data to the setCharacterStats method
     * */
    public void getRace(ActionEvent event){
//        arrays for assigning value to stats
        int [] human = {40, 5, 5, 4, 4, 5};
        int [] dwarf = {50, 5, 6, 4, 4, 4};
        int [] elvan = {40, 5, 5, 4, 6, 4};

//        get the user indicated choice from raceChoiceBox
        String userRace = raceChoiceBox.getValue();

//        Based on the user's choice this switch case will call the setCharacterStats method
        switch(userRace.toLowerCase()){
            case "human" -> {
                CharacterStats stats = new CharacterStats(human[0], human[1], human[2], human[3], human[4], human[5]);
                setCharacterStats(stats);
            }
            case "dwarf" -> {
                CharacterStats stats = new CharacterStats(dwarf[0], dwarf[1], dwarf[2], dwarf[3], dwarf[4], dwarf[5]);
                setCharacterStats(stats);
            }
            case "elvan" -> {
                CharacterStats stats = new CharacterStats(elvan[0], elvan[1], elvan[2], elvan[3], elvan[4], elvan[5]);
                setCharacterStats(stats);
            }
            default -> {
                break;
            }
        }
    }

    /**
     * This method detects the user's choice in the jobChoiceBox
     * Then sends necessary data to the setCharacterJobStats
     * */
    public void getJob(ActionEvent event){
//        arrays for assigning value to stats
        int [] fighter = {20, 3, 1, 0, 0, 0};
        int [] rogue =   {10, 2, 0, 3, 0, 0};
        int [] wizard =  {10, 0, 0, 0, 3, 2};

//        get the user indicated choice from jobChoiceBox
        String userJob = jobChoiceBox.getValue();

//        Based on the user's choice this switch case will call the setCharacterJobStats method
        switch (userJob.toLowerCase()){
            case "fighter" -> {
                setCharacterJobStats(fighter);
            }
            case "rogue" -> {
                setCharacterJobStats(rogue);
            }
            case "wizard" -> {
                setCharacterJobStats(wizard);
            }
            default -> {
                break;
            }
        }
    }

    /**
     * This method retrieves the base stats, adds the base stats to the appropriate element in the job(param) array
     * Then sets each individual attribute with elements in the job(param) array
     * @param job an array of stats passed from getJob(ActionEvent event) method
     * */
    public void setCharacterJobStats(int[] job){
        String hp = hpLabel.getText();
        String atk = atkLabel.getText();
        String def = defLabel.getText();
        String agil = agilLabel.getText();
        String mAtk = mAtkLabel.getText();
        String mDef = mDefLabel.getText();

        job[0] += Integer.parseInt(hp);
        job[1] += Integer.parseInt(atk);
        job[2] += Integer.parseInt(def);
        job[3] += Integer.parseInt(agil);
        job[4] += Integer.parseInt(mAtk);
        job[5] += Integer.parseInt(mDef);

        hpLabel.setText(String.valueOf(job[0]));
        atkLabel.setText(String.valueOf(job[1]));
        defLabel.setText(String.valueOf(job[2]));
        agilLabel.setText(String.valueOf(job[3]));
        mAtkLabel.setText(String.valueOf(job[4]));
        mDefLabel.setText(String.valueOf(job[5]));
    }

    /**
     * This method sets the base attributes
     * @param stats an object to set the base stats of the character
     * */
    public void setCharacterStats(CharacterStats stats){
        hpLabel.setText(String.valueOf(stats.getBaseHP()));
        atkLabel.setText(String.valueOf(stats.getBaseAttack()));
        defLabel.setText(String.valueOf(stats.getBaseDefense()));
        agilLabel.setText(String.valueOf(stats.getBaseAgility()));
        mAtkLabel.setText(String.valueOf(stats.getBaseMagicAttack()));
        mDefLabel.setText(String.valueOf(stats.getBaseMagicDefense()));
    }
}
