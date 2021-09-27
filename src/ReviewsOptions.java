package ClothingStore;

public class ReviewsOptions {
    static int[] arrayID = {1,2,3,4,5,6,7,8,9,10};
    static int[] reviewGrades = new int[10];
    // static String[] reviewComments = new String[10];

    public static void main(String[] args) {

        printReviewsOptions();
        switchOptions();
    }

    public static void printReviewsOptions(){
        String EOL = System.lineSeparator();
        System.out.print("Reviews Options Menu:" + EOL +
                "0. Return to Main Menu." + EOL +
                "1. Create an review for an Item." + EOL +
                "2. Print a specific review of an Item." + EOL +
                "3. Print all reviews of an Item." + EOL +
                "4. Print mean grade of an Item" + EOL +
                "5. Print all comments of an Item." + EOL +
                "6. Print all registered reviews." + EOL +
                "7. Print item(s) with most reviews." + EOL +
                "8. Print item(s) with least reviews." + EOL +
                "9. Print item(s) with best mean review grade." + EOL +
                "10. Print item(s) with worst mean review grade." + EOL + EOL +

                "Type an option number: ");
    }
    public static void switchOptions() {
        int selection = ClothingStore.Scanner.readInt();
        switch (selection) {
            case 0:
                printReviewsOptions();
                switchOptions();
            case 1:
                ClothingStore.ReviewsItem.CreateReview();
                printReviewsOptions();
                switchOptions();
                break;
            case 2:
                ClothingStore.ReviewsItem.printSpecReview();
                printReviewsOptions();
                switchOptions();
            case 3:
                //txtGoesHere;
            case 4:
                //txtGoesHere;
            case 5:
                //txtGoesHere;
            case 6:
                //txtGoesHere;
            case 7:
                //txtGoesHere;
            case 8:
                //txtGoesHere;
            case 9:
                //txtGoesHere;
            case 10:
                //txtGoesHere);*/
            default: System.out.println("Only option no 1 atm");
                break;
        }
    }
}
