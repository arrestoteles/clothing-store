package ClothingStore;

public class ReviewsItem {

    // method where user creates review if ID exists
    public static void CreateReview() {

        ClothingStore.Scanner.printMessage("What ID do you wish to review?: ");
        int reviewID = ClothingStore.Scanner.readInt();

        for (int i = 0; i < ClothingStore.ReviewsOptions.arrayID.length; i++) {
            if (containsElement(reviewID)) {
                ClothingStore.Scanner.printMessage("Type your grade: ");
                int myGrade = ClothingStore.Scanner.readInt();
                ClothingStore.ReviewsOptions.reviewGrades[reviewID] = myGrade;
                ClothingStore.Scanner.printInt(ClothingStore.ReviewsOptions.reviewGrades[2]);
                break;
            } else {
                ClothingStore.Scanner.printMessage("ID " + reviewID + "doesn't exist");
            }
        }
    }

    // method that checks if ID exist in array
    public static boolean containsElement(int element) {
        for (int i = 0; i < 1000; i++) {
            if (ClothingStore.ReviewsOptions.arrayID[i] == element) {
                return true;
            }
        } return false;
    }

    public static String printSpecReview() {
        String output = toString((System.out.println(ClothingStore.ReviewsOptions.reviewGrades)));
        return output;
    }
}
