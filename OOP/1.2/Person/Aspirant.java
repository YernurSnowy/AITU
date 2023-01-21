public class Aspirant extends Student {
    String scientificWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork){
        super(firstName, lastName, group, averageMark);
        setScientificWork(scientificWork);
    }

    @Override
    public int getScholarship(double averageMark) {
        if(averageMark == 5){
            return 200;
        }else {
            return 180;
        }
    }

    public String getScientificWork() {
        return scientificWork;
    }
    public void setScientificWork(String scientificWork) {
        this.scientificWork = scientificWork;
    }
}
