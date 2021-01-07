package com.tts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // System.out.print("Number of data lines: ");
        int numDataLines = Integer.parseInt(scanner.nextLine());

        ArrayList<String> data = new ArrayList();
        for(int i=0;i<numDataLines;i++){
            // System.out.println("Enter data line number "+ (i+1) +": ");
            data.add(scanner.nextLine());
        }

        ArrayList<String> queries = new ArrayList();
        // System.out.print("Number of queries: ");
        int numQueryLines = Integer.parseInt(scanner.nextLine());
        for(int i=0;i<numQueryLines;i++){
            // System.out.println("Enter query line number " + (i+1) + ": ");
            queries.add(scanner.nextLine());
        }

        for(int i=0;i<numQueryLines;i++){
            String[] selectors = queries.get(i).split(" ");
            int x = Integer.parseInt(selectors[0]);
            int y = Integer.parseInt(selectors[1]);

            if (y>0){
                boolean enoughRows = (data.size() >= x);
                if(enoughRows) {
                    String[] dataRow = data.get(x-1).split(" ");
                    boolean enoughNums = (dataRow.length > y);
                    if(enoughNums){
                        System.out.println(dataRow[y]);
                    } else System.out.println("ERROR!");
                } else System.out.println("ERROR!");
            } else System.out.println("ERROR!");

        }


//        // Some outputs for debugging
//        System.out.println("Number of data lines: " + numDataLines);
//        System.out.println("Data lines: " + data);
//        System.out.println("Number of queries: " + numQueryLines);
//        System.out.println("Queries: " + queries);

    }
}
