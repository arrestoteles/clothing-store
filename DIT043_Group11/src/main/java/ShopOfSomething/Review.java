package ShopOfSomething;

public class Review {
    String iD;
    int grade;
    String comment;

    //Constructor with optional comment
    public Review(String iD, int grade, String comment) {
        this.iD = iD;
        this.grade = grade;
        this.comment = comment;
    }

    //Constructor without optional comment
    public Review(String iD, int grade) {
        this.iD = iD;
        this.grade = grade;
    }

    public String getiD() {
        return iD;
    }

    public int getGrade() {
        return grade;
    }

    public String getComment() {
        return comment;
    }
}
