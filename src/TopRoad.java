import java.util.ArrayList;
import java.util.Arrays;

public class TopRoad {
    int no_cars = 0;
    ArrayList<Car> cars = new ArrayList<Car>();

    public String[] topRoad = new String[]{"_", "_", "_", "_", "_", "_", "_", "_", "_", "_",
            "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", };

    void addVehicle() {
        if (topRoad[0] == "_") {
            cars.add(new Car(no_cars));
            topRoad[0] = "c";
            no_cars++;
        }

    }

    int getNo_cars() {
        return no_cars;
    }

    void move_vehicles() {

        for (int i = 0; i < no_cars; i++) {
            Car a = cars.get(i);

            if (topRoad[a.getPos() + 1] == "_"){
                topRoad[a.getPos()] = "_";
                topRoad[a.getPos()+1] = a.drawCar();
            }


           /*r for (int l = 0; l <= topRoad.length-2; l++) {


                if (a.getPos() == topRoad.length-1) {
                    topRoad[topRoad.length-1] = "+";


                } else if (topRoad[a.getPos() + 1] == "+") {
                    topRoad[a.getPos()] = "+";
                    topRoad[a.getPos() + 1] = a.drawCar();

                }
            }*/

        }
        System.out.println(Arrays.toString(topRoad));
    }


    void drawRoad() {
        System.out.println(Arrays.toString(topRoad));
    }
/*
    void moveTop(int pos){
        topRoad[pos] = "c";
        topRoad[pos-1] = "+";

    }

    void addCar(){
        topRoad[0] = "c";
    }

    void movement(){
        System.out.println(Arrays.toString(topRoad));
        for (i){
            if (this.topRoad[i] == "c"){
                this.topRoad[i+1] = "c";
                this.topRoad[i] = "+";
                i = i+2;}
            else if (topRoad[i] == "+"){
                i++;}

        }


        }
    void addVehicle(String type){
        if (type = "car")

    }
*/

}
