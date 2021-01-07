package com.tts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // build the input scanner
        Scanner scanner = new Scanner(System.in);

        // first take the number of lines
//        System.out.print("Number of data lines: "); // uncomment for debugging to make manually entry easier
        int numDataLines = Integer.parseInt(scanner.nextLine());

        // now start accepting data rows
        ArrayList<String> data = new ArrayList();
        for(int i=0;i<numDataLines;i++){
            // System.out.println("Enter data line number "+ (i+1) +": ");
            data.add(scanner.nextLine());
        }

        // take the number of queries to come
        ArrayList<String> queries = new ArrayList();
//        System.out.print("Number of queries: "); // uncomment for debugging to make manually entry easier
        int numQueryLines = Integer.parseInt(scanner.nextLine());
        // now take the query lines
        for(int i=0;i<numQueryLines;i++){
//            System.out.println("Enter query line number " + (i+1) + ": "); // uncomment for debugging to make manually entry easier
            queries.add(scanner.nextLine());
        }

        // for each query, try to figure out and return the number
        for(int i=0;i<numQueryLines;i++){
            // assign our x and y from the query line we are working on
            String[] selectors = queries.get(i).split(" ");
            int x = Integer.parseInt(selectors[0]);
            int y = Integer.parseInt(selectors[1]);

            // make sure y hits an actual number instead of the first index in the data row
            if (y>0){
                // make sure there are enough rows for the query to complete
                boolean enoughRows = (data.size() >= x);
                if(enoughRows) {
                    // make an array from the row in question
                    String[] dataRow = data.get(x-1).split(" ");
                    // make sure there are enough numbers in the row
                    boolean enoughNums = (dataRow.length > y);
                    if(enoughNums){
                        // return the number in question!
                        System.out.println(dataRow[y]);
                    } else System.out.println("ERROR!"); // Error: not enough nums in row
                } else System.out.println("ERROR!"); // Error: not enough rows in data list
            } else System.out.println("ERROR!"); // Error: user selected y < 1
        }

//        // Some outputs for debugging
//        System.out.println("Number of data lines: " + numDataLines);
//        System.out.println("Data lines: " + data);
//        System.out.println("Number of queries: " + numQueryLines);
//        System.out.println("Queries: " + queries);
    }
}
