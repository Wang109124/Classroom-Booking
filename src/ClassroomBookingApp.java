//version : jdk-22

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ClassroomBookingApp {

    private static final Scanner INPUT = new Scanner(System.in);
    public static ArrayList<Classroom> classrooms = new ArrayList();
    public static ArrayList<Lecturer> lecturers = new ArrayList();
    public static ArrayList<Booking> bookings = new ArrayList();

    public static void main(String[] args) throws ParseException {
        System.out.println("Welcome to the Classoom Booking Application");
        mainMenu();
        System.out.println("Thank you for using the Classroom Booking Application!");
    }

    public static void mainMenu() throws ParseException {

        int option = -1;
        while (option != 0) {
            System.out.println();
            printMainMenu();
            try {
                option = INPUT.nextInt();
            } catch (InputMismatchException ex) {
                INPUT.nextLine();
                System.out.print("Error: Only numbers are allowed.");
                continue;
            }

            switch (option) {
                case 0:
                    break;
                case 1:
                    //Handle Manage Classrooms
                    manageClassroom(classrooms);
                    break;
                case 2:
                    //Handle Manage Lecturers
                    manageLecturers(lecturers);
                    break;
                case 3:
                    //Handle Manage Bookings
                    manageBooking(bookings, classrooms, lecturers);
                    break;
                case 4:
                    //Handle Generate Report
                    manageReport(bookings);
                    break;
                default:
                    System.out.println("Invalid option");
                    mainMenu();
            }
            break;
        }
    }

    public static void printMainMenu() {
        System.out.println("*** Main Menu ***");
        System.out.println("1.Manage Classrooms");
        System.out.println("2.Manage Lecturers");
        System.out.println("3.Manage Bookings");
        System.out.println("4.Generate Report");
        System.out.println("0.Exit");
        System.out.print("Enter option:");
    }

    static void printClassroomMenu() {
        System.out.println("*** Classroom Menu ***");
        System.out.println("1.Creat classroom");
        System.out.println("2.Update classroom");
        System.out.println("3.Delate classroom");
        System.out.println("4.View all classrooms");
        System.out.println("5.Back to Main Menu");
        System.out.print("Enter option:");
    }

    static void printLecturerMenu() {
        System.out.println("*** Lecturer Menu ***");
        System.out.println("1.Add lecturer");
        System.out.println("2.Edit lecturer");
        System.out.println("3.Remove lecture");
        System.out.println("4.View all lecturers");
        System.out.println("5.Back to Main Menu");
        System.out.print("Enter option:");
    }

    static void printBookingMenu() {
        System.out.println("*** Booking Menu ***");
        System.out.println("1.Make a booking");
        System.out.println("2.Cancal booking");
        System.out.println("3.View all bookings");
        System.out.println("4.Back to Main Menu");
        System.out.print("Enter option:");
    }

    static void printReportMenu() {
        System.out.println("** Reports Menu **");
        System.out.println("1.Generate bookings report by date");
        System.out.println("2.Generate bookings report by classroom");
        System.out.println("3.Generate bookings report by lecturer");
        System.out.println("4.Generate total number of bookings");
        System.out.println("5.Back to Main Menu");
        System.out.print("Enter option:");
    }

    static void manageClassroom(ArrayList<Classroom> classrooms) throws ParseException {
        int option = -1;
        while (option != 5) {
            System.out.println();
            printClassroomMenu();
            try {
                option = INPUT.nextInt();
            } catch (InputMismatchException ex) {
                INPUT.nextLine();
                System.out.print("Error: Only numbers are allowed.");
            }

            switch (option) {
                case 1:
                    //Creat Classroom
                    addClassroom(classrooms);
                    break;
                case 2:
                    //Update classroom
                    updateClassroom(classrooms);
                    break;
                case 3:
                    //Delate classroom
                    delateClassroom(classrooms);
                    break;
                case 4:
                    //View all classrooms
                    viewAllClassrooms(classrooms);
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public static void addClassroom(ArrayList<Classroom> classrooms) {
        System.out.println();
        System.out.print("Enter classroom number: ");
        int classroomNumber = INPUT.nextInt();
        boolean existed = false;
        for (Classroom classroom : classrooms) {
            if (classroomNumber == classroom.getClassroomNumber()) {
                existed = true;
                System.out.printf("Error: Classroom number '%d' already exists!", classroomNumber);
                break;
            }
        }
        if (!existed) {
            System.out.print("Enter classroom name: ");
            String classroomName = INPUT.next();
            System.out.print("Enter classroom loccation: ");
            String classroomLocation = INPUT.next();

            Classroom room = new Classroom(classroomNumber, classroomName, classroomLocation);
            classrooms.add(room);
            System.out.println("New Classroom created!");
        }
    }

    public static void updateClassroom(ArrayList<Classroom> classrooms) {
        System.out.println();
        System.out.print("Enter classroom number: ");
        int classroomNumber = INPUT.nextInt();
        boolean found = false;
        for (Classroom classroom : classrooms) {
            if (classroomNumber == classroom.getClassroomNumber()) {
                found = true;
                System.out.print("Enter classroom name: ");
                String classroomName = INPUT.next();
                System.out.print("Enter classroom loccation: ");
                String classroomLocation = INPUT.next();
                classroom.setClassroomName(classroomName);
                classroom.setClassroomLocation(classroomLocation);
                System.out.printf("Classroom '%d' updated!", classroomNumber);
            }
            if (!found) {
                System.out.println("Error: Invalid classroom number!");
            }
        }
    }

    public static void delateClassroom(ArrayList<Classroom> classrooms) {
        System.out.print("Enter classroom number: ");
        int classroomNumber = INPUT.nextInt();

        Iterator<Classroom> iterator = classrooms.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Classroom classroom = iterator.next();
            if (classroomNumber == classroom.getClassroomNumber()) {
                found = true;
                iterator.remove();
                System.out.printf("Classroom '%d' deleted", classroomNumber);
            }
        }
        if (!found) {
            System.out.printf("Classroom number '%d' does not exist.", classroomNumber);
        }
    }

    public static void viewAllClassrooms(ArrayList<Classroom> classrooms) {
        for (Classroom room : classrooms) {
            System.out.println(room.toString());
        }
    }

    static void manageLecturers(ArrayList<Lecturer> lecturers) throws ParseException {

        int option = -1;
        while (option != 5) {
            System.out.println();
            printLecturerMenu();
            try {
                option = INPUT.nextInt();
            } catch (InputMismatchException ex) {
                INPUT.nextLine();
                System.out.print("Error: Only numbers are allowed.");
            }

            switch (option) {
                case 1:
                    addLecturer(lecturers);
                    break;
                case 2:
                    editLecturer(lecturers);
                    break;
                case 3:
                    removeLecturer(lecturers);
                    break;
                case 4:
                    viewAllLecturer(lecturers);
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }
    }

    public static void addLecturer(ArrayList<Lecturer> lecturers) {

        INPUT.nextLine();
        System.out.print("Enter lecturerID: ");
        String lecturerID = INPUT.nextLine();
        System.out.print("Enter full name:");
        String fullName = INPUT.nextLine();
        System.out.print("Enter contact number:");
        String contactNumber = INPUT.nextLine();
        System.out.print("Entere email:");
        String emailAddress = INPUT.nextLine();
        Lecturer lecturer = new Lecturer(lecturerID, fullName, contactNumber, emailAddress);
        lecturers.add(lecturer);
        System.out.println("New Lecturer added!");
    }

    public static void editLecturer(ArrayList<Lecturer> lecturers) {
        INPUT.nextLine();
        System.out.print("Enter lecturerID to edit: ");
        String lecturerID = INPUT.nextLine();
        boolean found = false;
        for (Lecturer lecturer : lecturers) {
            if (lecturerID.equals(lecturer.getLecturerID())) {
                found = true;
                System.out.print("Enter lecturer full name: ");
                String fullName = INPUT.nextLine();
                System.out.print("Enter contact number: ");
                String contactNumber = INPUT.nextLine();
                System.out.print("Enter emailAdress: ");
                String emailAdress = INPUT.nextLine();
                lecturer.setFullName(fullName);
                lecturer.setContactNumber(contactNumber);
                lecturer.setEmailAddress(emailAdress);
                System.out.printf("Lecturer '%s' edited!",lecturerID);
                break;
            }
        }
        if (!found) {
            System.out.println("Error: Invalid lecturer ID!");
        }

    }

    public static void removeLecturer(ArrayList<Lecturer> lecturers) {
        System.out.print("Enter lecturerID to remove: ");
        String lecturerID = INPUT.next();

        Iterator<Lecturer> iterator = lecturers.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Lecturer lecturer = iterator.next();
            if (lecturerID.equals(lecturer.getLecturerID())) {
                found = true;
                iterator.remove();
                System.out.printf("Lecturer '%s' removed!", lecturerID);
            }
        }
        if (!found) {
            System.out.printf("Lecturer Id '%s' does not exist.", lecturerID);
        }
    }

    public static void viewAllLecturer(ArrayList<Lecturer> lecturers) {
        for (Lecturer lecturer : lecturers) {
            System.out.println(lecturer.toString());
        }
    }

    static void manageBooking(ArrayList<Booking> bookings, ArrayList<Classroom> classrooms, ArrayList<Lecturer> lecturers) throws ParseException {

        int option = -1;
        while (option != 4) {
            System.out.println();
            printBookingMenu();
            try {
                option = INPUT.nextInt();
            } catch (InputMismatchException ex) {
                INPUT.nextLine();
                System.out.print("Error: Only numbers are allowed.");
            }

            switch (option) {
                case 1:
                    //Making a booking
                    makeBooking(bookings, classrooms, lecturers);
                    break;
                case 2:
                    // Cancel a booking classroom
                    cancelBooking(bookings, classrooms, lecturers);
                    break;
                case 3:
                    //view all bookings
                    viewAllBooking(bookings, classrooms, lecturers);
                    break;
                case 4:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    static void makeBooking(ArrayList<Booking> bookings, ArrayList<Classroom> classrooms, ArrayList<Lecturer> lecturers) {
        INPUT.nextLine();
        System.out.print("Enter booking date (dd/MM/yyyy):");
        String bookingDateInput = INPUT.nextLine();

        Date bookingDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Convert String into Date
        try {
            //Convert String into Date
            bookingDate = formatter.parse(bookingDateInput);
        } catch (ParseException ex) {
            System.out.println("Invalid Date");
        }

        Classroom classroom = findAvailableClassroom(bookingDate, classrooms, bookings);
        if (classroom == null) {
            //TODO:Ensure bookingDate is formatted correctly
            System.out.printf("Error: No available classroom on '%s'!", bookingDateInput);
        }
        else{
            System.out.print("Enter lecturer ID: ");
            String lecturerID = INPUT.next();
            Booking book = new Booking(5000, bookingDate, classroom.getClassroomNumber(), lecturerID);
            bookings.add(book);
            System.out.printf("Classroom '%d' booked, booking ID is %d", classroom.getClassroomNumber(), book.getBookingID());
        }
    }

    static Classroom findAvailableClassroom(Date bookingDate, ArrayList<Classroom> classrooms, ArrayList<Booking> bookings) {
        for (Classroom classroom : classrooms) {
            boolean isAvailable = true;
            for (Booking booking : bookings) {
                if (booking.getBookingDate().equals(bookingDate) && booking.getclassroomNumber() == classroom.getClassroomNumber()) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                return classroom;
            }
        }
        // No classroom is available on this bookingDate
        return null;
    }

    public static void cancelBooking(ArrayList<Booking> bookings, ArrayList<Classroom> classrooms, ArrayList<Lecturer> lecturers) {
        System.out.print("Enter booking ID: ");
        int bookingID = INPUT.nextInt();

        Iterator<Booking> iterator = bookings.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            if (bookingID == booking.getBookingID()) {
                found = true;
                bookings.remove(booking);
                System.out.printf("Booking '%d' cancelled!", bookingID);
            }
        }
        if (!found) {
            System.out.printf("Error: Booking ID '%d' does not exist.", bookingID);
        }
    }

    public static void viewAllBooking(ArrayList<Booking> bookings, ArrayList<Classroom> classrooms, ArrayList<Lecturer> lecturers) {
        for (Booking booking : bookings) {
            System.out.println(booking.toString());
        }
    }

    static void manageReport(ArrayList<Booking> bookings) throws ParseException {
        int option = -1;
        while (option != 5) {
            System.out.println();
            printReportMenu();
            try {
                option = INPUT.nextInt();
            } catch (InputMismatchException ex) {
                INPUT.nextLine();
                System.out.print("Error: Only numbers are allowed.");
            }
            // Either if-else or switch
            switch (option) {
                case 1:
                    GenerateBookingsReportByDate(bookings);
                    break;
                case 2:
                    GenerateBookingsReportByClassroom(bookings);
                    break;
                case 3:
                    GenerateBookingsReportByLecturer(bookings);
                    break;
                case 4:
                    GenerateTotalNumberOfBookings(bookings);
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }

    }

    public static void GenerateBookingsReportByDate(ArrayList<Booking> bookings) {

        INPUT.nextLine();
        System.out.print("Enter booking date (dd/MM/yyyy): ");
        String bookingDateInput = INPUT.nextLine();

        Date bookingDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        //Convert String into Date
        try {
            //Convert String into Date
            bookingDate = formatter.parse(bookingDateInput);
        } catch (ParseException ex) {
            System.out.println("Invalid Date");
        }
        for (Booking booking : bookings) {
            if (bookingDate.equals(booking.getBookingDate())) {
                System.out.println(booking.toString());
            }

        }
    }

    public static void GenerateBookingsReportByClassroom(ArrayList<Booking> bookings) {
        System.out.print("Enter classroom number: ");
        int classroomNum = INPUT.nextInt();
        for (Booking booking : bookings) {
            if (classroomNum == booking.getclassroomNumber()) {
                System.out.println(booking.toString());
            }
        }
    }

    public static void GenerateBookingsReportByLecturer(ArrayList<Booking> bookings) {
        System.out.print("Enter lecturer id: ");
        String lecturerId = INPUT.next();
        for (Booking booking : bookings) {

            if (lecturerId.equals(booking.getLecturerID())) {
                System.out.println(booking.toString());
            }

        }
    }

    public static void GenerateTotalNumberOfBookings(ArrayList<Booking> bookings) {
        System.out.printf("Total number of bookings: %d", bookings.size());
    }
}
