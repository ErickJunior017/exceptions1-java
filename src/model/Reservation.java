package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    //Colocar como static para indicar que vou utilizar apenas um para todos os objetos que serão criados
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) {
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)){
           throw new IllegalArgumentException("Reservation dates dor update mus be future");
        }
        if (!checkOut.after(checkIn)) {
            throw new IllegalArgumentException("Check-out date must be after check-in date");
        }
        checkin = checkIn;
        checkout = checkOut;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Reservation: ");
        sb.append(getRoomNumber() + ", ");
        sb.append("Check-in: " + sdf.format(getCheckin()) + ", ");
        sb.append("Check-out: " + sdf.format(getCheckout()) + ", ");
        sb.append(duration() + " nights");
        return sb.toString();
    }
}
