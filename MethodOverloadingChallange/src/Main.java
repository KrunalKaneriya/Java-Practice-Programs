public class Main {

    public static void main(String[] args) {
        double answer = calcFeetAndInchToCM(0,5);
    }
    public static double calcFeetAndInchToCM(double feet,double inches) {
        if(feet>=0 && (inches >=0 && inches<=12)) {
            double centimetres = (feet *30.48) + (inches*2.54);
            System.out.println("Feet = " + (feet*30.48) + " inches = " + (inches*2.54) + " centimetres = " + centimetres);

            return centimetres;
        }
        return -1;
    }

    public static double calcFeetAndInchToCM(double inches) {
        if(inches>=0){
            double feet = inches / 12;
            double centimetres =calcFeetAndInchToCM(feet,inches);
            return centimetres;
        }
        return -1;

    }

}
