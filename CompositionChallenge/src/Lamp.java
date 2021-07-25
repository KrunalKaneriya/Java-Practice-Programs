public class Lamp {
    private String typeOfLamp;
    private boolean isLampOn;

    public Lamp(String typeOfLamp, boolean isLampOn) {
        this.typeOfLamp = typeOfLamp;
        this.isLampOn = isLampOn;
    }

    public void LampStatus(){
        if(this.isLampOn)
            System.out.println("The Lamp is On");
        else
            System.out.println("The Lamp is Off");
    }

    public boolean isLampOn() {
        return isLampOn;
    }
}
