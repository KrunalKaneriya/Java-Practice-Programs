import static java.lang.System.exit;

public class Car extends Vehicle{
    private String carName;
    private boolean isTwoSeater;
    private int gear=1;
    public Car(String typeofVehicle, String transportationType, boolean isPrivate, String carName, boolean isTwoSeater) {
        super(typeofVehicle, transportationType, isPrivate);
        this.carName = carName;
        this.isTwoSeater = isTwoSeater;
        this.isClutchOn = false;
    }

    private boolean isClutchOn;
    private String direction = "North";
    private double Speed;

    public void changeClutchMode() {
        if(!isClutchOn) {
            isClutchOn = true;
            System.out.println("Now You can Move The Car");
        }

//        if(isClutchOn) {
//            isClutchOn = false;
//        }
    }
    public void changeGear() {

        if(isClutchOn) {
            System.out.println("--------------------------------------");
            System.out.println("Current Gear is " + this.gear);
            this.gear++;
            System.out.println("Now Changed the Gear to " + this.gear);
            System.out.println("--------------------------------------");
        }
        if((!isClutchOn) || (this.gear>6)) {
            System.out.println("Unable to Change Gear. Change Clutch or Gear is At Max Level.");
        }
    }

    public void changeDirection(String direction) {
        int Stringcheck;
        Stringcheck = this.direction.compareTo(direction);
        if(Stringcheck == 0) {
            System.out.println("Change The Direction");
            exit(0);
        }
        if(direction.equalsIgnoreCase("West") || direction.equalsIgnoreCase("North") || direction.equalsIgnoreCase("South") || direction.equalsIgnoreCase("East")) {
            this.direction = direction;
        }
        getDirection();
    }

    public String getDirection() {
        System.out.println("The Current Direction is: " + this.direction);
        return direction;
    }
}
