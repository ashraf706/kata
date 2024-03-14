package com.awesome.ash;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an alphabet A to Z:");
        char alphabet = sc.next().charAt(0);
        sc.close();
        Diamond.draw(alphabet);
    }
}
