package application;

import model.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation = new Reservation();

        System.out.print("Room number: ");
        int number = input.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkin = sdf.parse(input.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(input.next());

        if (!checkOut.after(checkin)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else {
            reservation = new Reservation(number, checkin, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        System.out.println();

        System.out.println("Enter data to update the reservation:");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkin = sdf.parse(input.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        checkOut = sdf.parse(input.next());

        String error = reservation.updateDates(checkin, checkOut);
        if (error != null){
            System.out.println("Error in reservation: " + error);
        }else {
            System.out.println("Reservation: " + reservation);
        }



    }
}
