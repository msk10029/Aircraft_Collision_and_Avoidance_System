package factory;

import models.Aircraft;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AircraftGenerator {

    static int maxAltitude = 45000;
    static int minAltitude = 40000;
    static double maxX = 677;
    static double maxY = 660;

    public static List<Aircraft> generateRandomAircraft(int count) {
        List<Aircraft> aircraftList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            double positionX = random.nextDouble() * maxX;
            double positionY = random.nextDouble() * maxY;
            double speed = random.nextDouble()*10;
            double altitude = minAltitude + (random.nextDouble() * (maxAltitude - minAltitude));
            int heading = random.nextInt() * 360;

            double collisionRadius = 15;

            Color color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);

            String id = "AC" + (i + 1);

            Aircraft aircraft = new Aircraft(id, positionX, positionY, altitude, speed, heading, collisionRadius,
                    color);

            aircraftList.add(aircraft);
        }

        return aircraftList;
    }
}
