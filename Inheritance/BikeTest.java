package Inheritance;

/**
 * InnerBikeTest
 */
class Bycycle {
    public int gear;
    public int speed;

    public Bycycle(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    public void applyBreak(int decrement) {
        speed = speed - decrement;
    }

    public void speedUp(int increment) {
        speed = speed + increment;
    }

    public String print() {
        return ("No of gear of Bicycle" + gear + "\n" + "Speed Of Bicycle is " + speed);
    }
}

class MountainBike extends Bycycle{
    public int seatHeight;

    public MountainBike(int startHeight, int speed, int gear) {
        super(gear, speed);
        this.seatHeight = startHeight;
    }

    public void seatHeight(int Height) {
        seatHeight = Height;

    }

    public String print(){
        return(super.print()+"\n Seat Height is"+seatHeight);
    }



}   

public class BikeTest {
    public static void main(String[] args) {
        MountainBike mb = new MountainBike(3, 100, 25);
        System.out.println(mb.print());
    }
}
