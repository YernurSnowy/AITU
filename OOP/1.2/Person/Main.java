public class Main {
    public static void main(String[] args){
        Student[] student = new Student[4];
        student[0] = new Student("Yernur", "Koishybayev", "SE", 5);
        student[1] = new Student("Ibragim", "Makarov","IT",4);
        student[2] = new Aspirant("Alibek","Kantarbev","CS", 4, "Project 1");
        student[3] = new Aspirant("Nur", "Koishybayev", "ITM", 5,"Project 2");

        for(int i = 0; i< student.length; i++){
            int amount = student[i].getScholarship(student[i].getAverageMark());
            System.out.println(amount);
        }
    }
}
