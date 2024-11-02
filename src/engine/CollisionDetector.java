package engine;

import models.Aircraft;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.scene.paint.Color;
import javafx.scene.control.TextArea;

public class CollisionDetector {

    // boolean collision = false;
    // Aircraft a, b;
    private static Set<Aircraft> dangerSet = new HashSet<>();

    public static void checkForCollisions(List<Aircraft> aircraftList, TextArea textArea) {
        // String msg = "";
        // String temp = "";
        // Reset all aircraft to blue at the start of each collision check
        for (Aircraft aircraft : aircraftList) {
            aircraft.getIcon().setFill(Color.BLUE);  // Set default color back to blue
        }

        for (int i = 0; i < aircraftList.size(); i++) {
            for (int j = i + 1; j < aircraftList.size(); j++) {
                Aircraft a1 = aircraftList.get(i);
                Aircraft a2 = aircraftList.get(j);

                // Calculate the horizontal distance between the two aircraft
                double dx = a1.getPositionX() - a2.getPositionX();
                double dy = a1.getPositionY() - a2.getPositionY();
                double horizontalDistance = Math.sqrt(dx * dx + dy * dy);

                // Calculate the altitude difference between the two aircraft
                double altitudeDifference = Math.abs(a1.getAltitude() - a2.getAltitude());

                // Collision detection conditions: horizontal distance and altitude
                if (horizontalDistance <= (a1.getCollisionRadius() + a2.getCollisionRadius())
                    && altitudeDifference <= 500) {  // Example threshold: 500 feet

                    // msg = "Collision warning between " + a1.getId() + " and " + a2.getId()
                    //     + ". Altitude difference: " + Math.ceil(altitudeDifference) + " feet,  Maneuvring both aircrafts";
                    // int l = msg.length();
                    // String text = textArea.getText();
                    // if(text.length()>=l)
                    // text = text.substring(text.length()-l);
                    
                    // if(!text.equals(msg)){
                    //     textArea.setText(textArea.getText()+ "\n" + msg);
                    //     // temp = textArea.getText();
                    //     // textArea.setText(textArea.getText() + "\n" + msg);
                    //     // textArea.wrapTextProperty();
                    //     // System.out.println(temp.equals(msg));
                    //     // System.out.println(msg);
                    //     // System.out.println(temp);
                    // }

                    

                    // Change color of both aircraft involved in the warning to red
                    a1.getIcon().setFill(Color.RED);
                    a2.getIcon().setFill(Color.RED);

                    if (!dangerSet.contains(a1) && !dangerSet.contains(a2)) {
                        // Append warning message to the TextArea
                        textArea.appendText("Collision warning between Aircraft " + a1.getId() + " and " + a2.getId() +", Maneuvering!!"  + "\n");

                        // Add both aircraft to the danger set
                        dangerSet.add(a1);
                        dangerSet.add(a2);

                        // Initiate maneuvers for both aircraft
                        initiateManeuver(a1, a2);
                    }

                    // Gradually adjust the heading and altitude
                    // initiateManeuver(a1, a2);
                }
            }
        }
    }


    public static void initiateManeuver(Aircraft a1, Aircraft a2){

        a1.setHeading(a1.getHeading() + 20);

        if(a1.getAltitude()<=a2.getAltitude()){
            a1.setClimbRate(-1000);
            a2.setClimbRate(1000);
        }
        else{
            a1.setClimbRate(1000);
            a2.setClimbRate(-1000);

        }
    }
}


