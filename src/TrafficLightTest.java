import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrafficLightTest {

    @Test
    public static void main(String[] args){
        TrafficLight trafficLight = new TrafficLight(0, 0, "NS", true);
        System.out.println(trafficLight.isGreen());
        System.out.println(trafficLight.isGreen());
        System.out.println(trafficLight.isGreen());
        System.out.println(trafficLight.isGreen());
        System.out.println(trafficLight.isGreen());



    }
}