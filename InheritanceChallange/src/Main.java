public class Main {

    public static void main(String[] args) {
        Nissan nissanCar= new Nissan("Car","Road",true,"Nissan GT Turbo",true);
        nissanCar.changeClutchMode();
        nissanCar.changeGear();
        nissanCar.changeGear();
        nissanCar.changeDirection("East");
        nissanCar.changeDirection("West");
        nissanCar.changeDirection("North");
    }
}
