//version : jdk-22

public class Classroom {

    private int classroomNumber;
    private String classroomName;
    private String classroomLocation;

    public Classroom(int classroomNumber, String classroomName, String classroomLocation) {
        this.classroomNumber = classroomNumber;
        this.classroomName = classroomName;
        this.classroomLocation = classroomLocation;
    }

    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public String getClassroomLocation() {
        return classroomLocation;
    }

    public void setClassroomLocation(String classroomLocation) {
        this.classroomLocation = classroomLocation;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    @Override
    public String toString() {
        return "Classroom Number: " + classroomNumber +
                ", Name: " + classroomName +
                ", Location: " + classroomLocation ;
    }
}
