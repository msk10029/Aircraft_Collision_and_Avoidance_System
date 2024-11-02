package gui;
import java.util.List;

import engine.SimulationEngine;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import models.Aircraft;

public class Controller {

    @FXML
    private Button bt_start;

    @FXML
    private Button bt_stop;

    @FXML
    private Label lb_test;

    @FXML
    private Pane Pn_aircraftPane;

    @FXML
    private TextArea Txt_Message;

    // private Timeline movementTimeline;
    private SimulationEngine simulationEngine;
    private AircraftRenderer aircraftRenderer;
    private List<Aircraft> aircraftList;


    @FXML
    public void initialize(){
        aircraftRenderer = new AircraftRenderer(Pn_aircraftPane);
        simulationEngine = new SimulationEngine(Pn_aircraftPane, Txt_Message);
        aircraftList = simulationEngine.getAircraftList();
        // Aircraft aircraft = aircraftList.get(0);
        // Circle aircraftIcon = aircraftRenderer.addAircraftToUI(aircraft);
        // aircraft.setIcon(aircraftIcon);
        for (Aircraft aircraft : aircraftList){
            Circle aircraftIcon = aircraftRenderer.addAircraftToUI(aircraft);
            aircraft.setIcon(aircraftIcon);
            // System.out.println("Hello");
        }
    }

    @FXML
    public void start(){
        simulationEngine.startAircraftMovement();
    }

    public void stop(){
        simulationEngine.stopAircraftMovement();
    }

    

}

