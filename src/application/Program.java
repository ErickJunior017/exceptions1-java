package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Reservation reservation = new Reservation();
        try {
            System.out.print("Room number: ");
            int number = input.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkin = sdf.parse(input.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(input.next());

            reservation = new Reservation(number, checkin, checkOut);
            System.out.println("Reservation: " + reservation);
            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkin = sdf.parse(input.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(input.next());

            reservation.updateDates(checkin, checkOut);
            System.out.println("Reservation: " + reservation);
        } catch (ParseException e){
            System.out.println("Invalid date format");
        } catch(DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
    }
}
