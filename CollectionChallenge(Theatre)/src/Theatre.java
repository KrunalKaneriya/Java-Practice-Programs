import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Theatre{
    public final String theatreName;
    private List<Seat>seats = new ArrayList<>();

    public Theatre(String theatreName,int numRows,int seatsPerRow) {
        this.theatreName = theatreName;
        double price = 12.00;
        int lastRow = 'A' + (numRows-1);
        for(char row = 'A';row<=lastRow;row++) {
            for(int seatsNum = 1;seatsNum<=seatsPerRow;seatsNum++) {
                if((row<'D') && ((seatsNum>=4) && seatsNum<=9)) {
                price = 17.00;
                } else if((row>'F') || (seatsNum<=3) || (seatsNum >=10)) {
                    price = 10.00;
                }
                Seat seat = new Seat((row + String.format("%02d",seatsNum)),price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return this.theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
//        int foundSeat  = Collections.binarySearch(seats,requestedSeat,null);
//        if(foundSeat<0) {
//            System.out.println("Seat Not Founded...");
//            return false;
//        }
//        else {
//            return seats.get(foundSeat).reserve();
//        }
        for(Seat searchingSeat : seats) {
            if(searchingSeat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = searchingSeat;
                return true;
            }
        }

        if(requestedSeat == null) {
            System.out.println("The Requested Seat is not Found in our Database..");
            return false;
        }

        return requestedSeat.reserve();
    }


    //For Testing
    public Collection<Seat>getSeats() {
        return seats;
    }

    public class Seat implements Comparable<Seat>{
        private final String seatNumber;
        private boolean reserved = false;
        private double price;
        public Seat(String seatNumber,double price) {
            this.seatNumber = seatNumber;
            this.price = price;
        }

        public boolean reserve() {
            if(!this.reserved) {
                System.out.println("Seat " + seatNumber + " reserved..");
                reserved = true;
                return true;
            }
            else {
                System.out.println("Error Reserving The Seat. Please Try Again..");
                return false;
            }
        }

        @Override
        public int compareTo(Seat obj) {
            return this.seatNumber.compareToIgnoreCase(obj.getSeatNumber());
        }

        public boolean cancelSeat() {
            if(this.reserved) {
                reserved = false;
                System.out.println("Seat " + seatNumber + " is cancelled..");
                return true;
            }
            return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public double getSeatPrice() {
            return price;
        }

    }
}
