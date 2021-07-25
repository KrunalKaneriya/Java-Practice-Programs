public class Main {

    public static void main(String[] args) {
        //1 Min = 60
        //1 Hr = 60 Min Or 3600 Seconds
        System.out.println(getDurationString(65,45));
        System.out.println(getDurationString(5206));


    }
    public static String getDurationString(int minutes,int seconds) {
        if((minutes>=0) && (seconds>=0 && seconds<=59)) {
            int hoursToMin = minutes / 60;
            int remainingMinutes = minutes%60;
                return hoursToMin +"h " + remainingMinutes + "m " + seconds + "s ";
        }
        return "Invalid Value";
    }

    public static String getDurationString(int seconds){
        if(seconds<0) {
            return "Invalid Value";
        }
        int minutes = seconds/60;
        int remainingSeconds = seconds%60;
        return getDurationString(minutes,remainingSeconds);
    }
}
