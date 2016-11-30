package com.company;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Number of elements: ");
        int n = in.nextInt();
        int count[] = new int[n];
        for(int i = 0; i < n; i++) {
            count[i] = in.nextInt();
        }
        Set<Integer> set = new HashSet<Integer>();
        try {
            for(int i = 0; i < n; i++) {
                set.add(count[i]);
            }
            System.out.println(set + "\t- HashSet is not sorted");

            TreeSet sortedSet = new TreeSet<Integer>(set);
            System.out.println(sortedSet + "\t- TreeSet is sorted");

            System.out.println("The First element of the set is: "+ sortedSet.first());
            System.out.println("The last element of the set is: "+ sortedSet.last());
        }
        catch(Exception e) {}
    }
}