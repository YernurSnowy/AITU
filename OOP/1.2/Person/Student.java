public class Student {
    private String firstName, lastName, group;
    private double averageMark;

    public Student(String firstName, String lastName, String group, double averageMark){
        setFirstName(firstName);
        setLastName(lastName);
        setGroup(group);
        setAverageMark(averageMark);
    }

    public int getScholarship(double averageMark){
        if(averageMark == 5){
            return 100;
        }else{
            return 80;
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGroup() {
        return group;
    }
    public void setGroup(String group) {
        this.group = group;
    }

    public double getAverageMark() {
        return averageMark;
    }
    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }
}
