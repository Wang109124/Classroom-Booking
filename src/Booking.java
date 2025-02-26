//author: WU JIACHEN
//version : jdk-22

import java.text.SimpleDateFormat;
import java.util.Date;


public class Booking {
    private static int nextID = 50000;

    private int bookingID;
    private Date bookingDate;
    private int classroomNumber;
    private String lecturerID;

    private static int generateNextID(){
        nextID++;
        return nextID;
    }

    public Booking(int bookingID, Date bookingDate, int classroomNumber, String lecturerID) {
        this.bookingID = generateNextID();
        this.bookingDate = bookingDate;
        this.classroomNumber = classroomNumber;
        this.lecturerID = lecturerID;
    }

    public int getBookingID() {
        return bookingID;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getclassroomNumber() {
        return classroomNumber;
    }

    public void setclassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return "bookingID: " + bookingID +
                ", Date: " + formatter.format(bookingDate) +
                ", Classroom number: " + classroomNumber +
                ", Lecturer ID:" + lecturerID ;
    }

}
