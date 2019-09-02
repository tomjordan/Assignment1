public class Car{
    int length;
    double breadth;
    int position;
    int reference;

    public Car(int ref) {
        length  =2;
        breadth = 1;
        position = 0;
        reference = ref;
    }

    public int getPos(){
        return this.position;
    }

    public void moveCar(){
        position++;
    }
    public int getReference(){
        return reference;
    }

    public int getPosition(){

        return position;

    }

    public String  drawCar(){
        position = position+1;
        return "c";
    }
}
