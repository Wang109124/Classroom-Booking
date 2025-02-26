//version : jdk-22

public class Lecturer {

    private String lecturerID;
    private String fullName;
    private String contactNumber;
    private String emailAddress;

    public Lecturer(String lecturerID, String fullName, String contactNumber, String emailAddress) {
        this.lecturerID = lecturerID;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public String getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(String lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "lecturerID: " + lecturerID +
                ", fullName: " + fullName +
                ", contactNumber: " + contactNumber +
                ", emailAddress: " + emailAddress;
    }
}


