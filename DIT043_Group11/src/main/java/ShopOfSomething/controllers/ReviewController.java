package ShopOfSomething.controllers;

import ShopOfSomething.models.Item;
import ShopOfSomething.models.Review;
import ShopOfSomething.UserIO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReviewController {
    private ArrayList<Item> items;
    private ItemController itemController;

    public ReviewController(ArrayList<Item> items, ItemController itemController) {
        this.items = items;
        this.itemController = itemController;
    }

    public String reviewItem(String itemID, String reviewComment, int reviewGrade) {
        String message;
        if (reviewGrade < 0 || reviewGrade > 5) {
            System.out.println("Invalid value for grade");
            message = "Grade values must be between 1 and 5.";
        } else if (itemController.findItem(itemID) == null) {
            message = "Item " + itemID + " not found.";
        } else {
            itemController.findItem(itemID).reviewList.add(new Review(itemID, reviewGrade, reviewComment));
            message = "Your item review was registered successfully.";
        }
        return message;
    }

    public String reviewItem(String itemID, int reviewGrade) {
        String message;
        if (reviewGrade < 0 || reviewGrade > 5) {
            System.out.println("Invalid value for grade");
            message = "Grade values must be between 1 and 5.";
        } else if (itemController.findItem(itemID) == null) {
            message = "Item " + itemID + " not found.";
        } else {
            itemController.findItem(itemID).reviewList.add(new Review(itemID, reviewGrade));
            message = "Your item review was registered successfully.";
        }
        return message;
    }

    public String getItemCommentsPrinted(String itemID) {
        String EOL = System.lineSeparator();
        StringBuilder message = new StringBuilder();
        for (Item item : items) {
            for (Review review : item.reviewList) {
                message.append(review.getComment()).append(EOL);
            }
        }
        return message.toString();
    }

    public List<String> getItemComments(String itemID) {
        List<String> commentList = new ArrayList<>();
        Item item = itemController.findItem(itemID);
        if (item.reviewList == null) {
            return commentList;
        }
        for (Review review : item.reviewList) {
            if (review.getComment() != null && !review.getComment().isEmpty()) {
                commentList.add(review.getComment());
            }
        }
        return commentList;
    }

    public double getItemMeanGrade(String itemID) {
        double meanGrade = 0.00;
        Item item = itemController.findItem(itemID);
        if (item.reviewList.isEmpty()) {
            return 0.00;
        } else {
            for (Review review : item.reviewList) {
                meanGrade += review.getGrade();
            }
        }
        return UserIO.truncateFormat(meanGrade / item.reviewList.size());
    }

    public int getNumberOfReviews(String itemID) {
        Item item = itemController.findItem(itemID);
        return item.reviewList.size();
    }

    public String getPrintedItemReview(String itemID, int reviewNumber) {
        Item item = itemController.findItem(itemID);
        String currentReview = "";
        if (item.reviewList.size() < 1) {
            currentReview = "Item " + item.getName() + " has not been reviewed yet.";
        } else if (reviewNumber < 1 || reviewNumber > item.reviewList.size()) {
            int revNum = item.reviewList.size();
            currentReview = "Invalid review number. Choose between 1 and " + revNum + ".";
        } else {
            currentReview += item.reviewList.get(reviewNumber - 1);
        }
        return currentReview;
    }

    public String getPrintedReviews(String itemID) {
        String EOL = System.lineSeparator();
        String reviewOutput = "";
        Item item = itemController.findItem(itemID);
        if (item == null) {
            reviewOutput = "Item " + itemID + " was not registered yet.";
        } else {
            reviewOutput = "Review(s) for " + item + EOL;
            if (item.reviewList.isEmpty()) {
                reviewOutput += "The item " + item.getName() + " has not been reviewed yet.";
            }
            for (Review review : item.reviewList) {
                reviewOutput += review + EOL;
            }
        }
        return reviewOutput;
    }

    public String printMostReviewedItems() {
        String EOL = System.lineSeparator();
        int max = 0;
        for (Item item : items) {
            if (item.reviewList.size() > max) {
                max = item.reviewList.size();
            }
        }

        String count = "Most reviews: " + max + " review(s) each." + EOL;

        if (items.isEmpty()) {
            count = "No items registered yet.";
        } else {
            int num = 0;
            for (Item item : items) {
                if (!item.reviewList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Item item : items) {
                    if (item.reviewList.size() == max) {
                        count += item + EOL;
                    }
                }
            } else {
                count = "No items were reviewed yet.";
            }
        }
        return count;
    }

    public List<String> getMostReviewedItems() {
        int max = 0;
        for (Item item : items) {
            if (item.reviewList.size() > max) {
                max = item.reviewList.size();
            }
        }
        if(max == 0){
            return new ArrayList<>();
        }
        ArrayList<String> maxReviews = new ArrayList<>();
        for (Item item : items) {
            if (item.reviewList.size() == max) {
                maxReviews.add(item.getiD());
            }
        }
        return maxReviews;
    }

    public List<String> getLeastReviewedItems() {
        int min = Integer.MAX_VALUE;
        for (Item item : items) {
            if (item.reviewList.size() < min && item.reviewList.size() > 0) {
                min = item.reviewList.size();
            }
        }
        ArrayList<String> minReviews = new ArrayList<>();
        for (Item item : items) {
            if (item.reviewList.size() == min) {
                minReviews.add(item.getiD());
            }
        }
        return minReviews;
    }

    public String printLeastReviewedItems() {
        String EOL = System.lineSeparator();
        int min = Integer.MAX_VALUE;
        for (Item item : items) {
            if (item.reviewList.size() < min && item.reviewList.size() > 0) {
                min = item.reviewList.size();
            }
        }
        String count = "Least reviews: " + min + " review(s) each." + EOL;

        if (items.isEmpty()) {
            count = "No items registered yet.";
        } else {
            int num = 0;
            for (Item item : items) {
                if (!item.reviewList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Item item : items) {
                    if (item.reviewList.size() == min) {
                        count += item + EOL;
                    }
                }
            } else {
                count = "No items were reviewed yet.";
            }
        }
        return count;
    }

    public String printWorseReviewedItems() {
        String EOL = System.lineSeparator();
        String message;
        double meanGrade = 5.00;
        String meanGradeStr = "";
        String storeStr = "";
        String newStr = "";

        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int num = 0;
            for (Item item : items) {
                if (!item.reviewList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                message = "Items with worst mean reviews:" + EOL + "Grade: ";
                for (Item item : items) {
                    if (getItemMeanGrade(item.getiD()) <= meanGrade && getItemMeanGrade(item.getiD()) != 0.00) {
                        newStr = item.getiD();
                    }
                }
                meanGrade = getItemMeanGrade(newStr);
                meanGradeStr += getItemMeanGrade(newStr);
                for (Item item : items) {
                    if (getItemMeanGrade(item.getiD()) <= meanGrade && getItemMeanGrade(item.getiD()) != 0.00) {
                        meanGrade = getItemMeanGrade(item.getiD());
                        storeStr += item.getiD() + ": " + item.getName() + ". " + UserIO.decimalFormat(item.getPrice()) + " SEK" + EOL;
                    }
                }
                message += meanGradeStr + EOL + storeStr;
            } else {
                message = "No items were reviewed yet.";
            }
        }
        return message;
    }

    public String printBestReviewedItems() {
        String EOL = System.lineSeparator();
        String message = "Items with best mean reviews:" + EOL;
        double meanGrade = 0.00;
        String meanGradeStr = "";
        String storeStr = "";

        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int num = 0;
            for (Item item : items) {
                if (!item.reviewList.isEmpty()) {
                    num += 1;
                }
            }
            if (num > 0) {
                for (Item item : items) {
                    if (getItemMeanGrade(item.getiD()) >= meanGrade) {
                        meanGradeStr = "Grade: " + getItemMeanGrade(item.getiD());
                        meanGrade = getItemMeanGrade(item.getiD());
                        storeStr += item.getiD() + ": " + item.getName() + ". " + UserIO.decimalFormat(item.getPrice()) + " SEK" + EOL;
                    }
                }
                message += meanGradeStr + EOL + storeStr;
            } else {
                message = "No items were reviewed yet.";
            }
        }
        return message;
    }

    public List<String> getWorseReviewedItems() {
        ArrayList<String> worstReviews = new ArrayList<>();
        double min = 5.00;
        for (Item item : items) {
            double currentNum = getItemMeanGrade(item.getiD());
            if (currentNum <= min && currentNum != 0.00) {
                worstReviews.add(item.getiD());
            }
        }
        Collections.reverse(worstReviews);
        if (items.isEmpty()) {
            worstReviews.clear();
        } else if (!worstReviews.isEmpty()){
            String tempID = worstReviews.get(0);
            worstReviews.clear();
            for(Item item : items) {
                double currentNum = getItemMeanGrade(item.getiD());
                if (currentNum <= getItemMeanGrade(tempID) && currentNum != 0.00) {
                    worstReviews.add(item.getiD());
                }
            }
        } else {
            worstReviews.clear();
        }
        return worstReviews;
    }

    public List<String> getBestReviewedItems() {
        ArrayList<String> bestReviews = new ArrayList<>();
        double max = 0.00;
        int count = 0;

        // check to see if reviewslist is empty or not
        if(items.isEmpty()){
            return bestReviews;
        } else {
            for (Item item : items) {
                if (item.reviewList.size() > 0) {
                    count += 1;
                } else {
                    count += 0;
                }
            }
        }

        // if reviewslist not empty add ID to ArrayList, else clear ArrayList
        if (count > 0) {
            for (Item item : items) {
                double currentNum = getItemMeanGrade(item.getiD());
                if (currentNum >= max) {
                    bestReviews.add(item.getiD());
                    max = currentNum;
                }
            }
        }
        return bestReviews;
    }

    public String printAllReviews() {
        String EOL = System.lineSeparator();
        String message;
        if (items.isEmpty()) {
            message = "No items registered yet.";
        } else {
            int count = 0;
            for (Item item : items) {
                if (item.reviewList.size() > 0) {
                    count += 1;
                } else {
                    count += 0;
                }
            }
            if (count < 1) {
                message = "No items were reviewed yet.";
            } else {
                message = "All registered reviews:" + EOL +
                        "------------------------------------" + EOL;
                for (Item item : items) {
                    if (!item.reviewList.isEmpty()) {
                        message += getPrintedReviews(item.getiD()) + "------------------------------------" + EOL;
                    }
                }
            }
        }
        return message;
    }
}

