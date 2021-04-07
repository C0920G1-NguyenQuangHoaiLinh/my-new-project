package test_fcorp;

import java.util.Scanner;

public class Search {

    public static void main(String[] args) {
        String[] docs = new String[2];
        docs[0] = "Bank regulation: Bank regulation is a form of government regulation which subjects banks to certain requirements";
        docs[1] = "Banking crisis: When banks suffer a sudden rush of withdrawals by depositors, this is called a bank run";
        Search.searchString(docs[0], docs[1]);
    }

    public static void searchString(String str1, String str2) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string :");
        String inputString = scanner.nextLine();
        if (str1.contains(inputString) && str2.contains(inputString)) {
            System.out.println("[0,1]");
        } else if (str2.contains(inputString)) {
            System.out.println("[1]");
        } else if (str1.contains(inputString)) {
            System.out.println("[0]");
        } else {
            System.out.println(inputString + " not found");
        }
    }
}

