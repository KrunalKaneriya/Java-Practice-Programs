import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Bajrang",10,10);
//        theatre.getSeats();
        if(theatre.reserveSeat("A05")) {
            System.out.println("Seat Reserved. Please Pay");
        }
        else {
            System.out.println("Error Reserving Seat..");
        }

        printlist(theatre);


    }

    public static void printlist(List<Theatre.Seat> seats) {
        for(Theatre.Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + " " + seat.getSeatPrice());
        }
    }


}
