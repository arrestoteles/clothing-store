package ShopOfSomething;

public class Reviews {

    private String iD;
    private int reviewGrade;
    private String reviewComment;


    //constructor1
    public Reviews(String iD, int itemGrade) {
        this.iD = iD;
        this.reviewGrade = itemGrade;
    }

    //constructor2
    public Reviews(String iD, int itemGrade, String itemComment) {
        this.iD = iD;
        this.reviewGrade = itemGrade;
        this.reviewComment = itemComment;
    }

    public String toString() {
        return "Grade: " + this.reviewGrade + "." + this.reviewComment;
    }

    public String getiD() {
        return iD;
    }

    public int getGrade() {
        return reviewGrade;
    }

    public String getComment() {
        return reviewComment;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public void setReviewGrade(int reviewGrade) {
        this.reviewGrade = reviewGrade;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }
}
