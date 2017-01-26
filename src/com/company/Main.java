package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)throws IOException {
        // write your code here
        Scanner kb = new Scanner(System.in);
        Scanner num = new Scanner(System.in);

        Scanner sc = new Scanner(new File("ColorName.txt"));
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine().toLowerCase());
        }

        String[] names = lines.toArray(new String[0]);
        lines.clear();
        sc.close();

        Scanner sc1 = new Scanner(new File("ColorHex.txt"));
        List<String> lines1 = new ArrayList<String>();
        while (sc1.hasNextLine()) {
            lines1.add(sc1.nextLine());
        }

        String[] pairedHexes = lines1.toArray(new String[0]);
        lines1.clear();
        sc1.close();


        System.out.println("Are you entering a Color, Hex code, or RGB triplet (C/HEX/RGB) ");
        String path = kb.nextLine();

        if (path.equalsIgnoreCase("c")) {

            System.out.println("Type the name of the color");
            String usrColor = kb.nextLine();

            int hexSearch = -1;
            for (int i = 0; i < names.length; ++i) {
                if (usrColor.equalsIgnoreCase(names[i])) {
                    hexSearch = i;
                    break;
                }
            }
            if (hexSearch == -1){

            }
            else {
                System.out.println("The RGB Triplet is " + toDecimal(pairedHexes[hexSearch].substring(0, 2)) + " " + toDecimal(pairedHexes[hexSearch].substring(2, 4)) + " " + toDecimal(pairedHexes[hexSearch].substring(4)));
                System.out.println("the hex code is #" + pairedHexes[hexSearch]);
            }


        } else if (path.equalsIgnoreCase("hex")) {

            System.out.println("Type the hex code without the #");
            String hexFull = kb.nextLine();

            System.out.println("the RGB triplet is " + toDecimal(hexFull.substring(0, 2)) + " " + toDecimal(hexFull.substring(2, 4)) + " " + toDecimal(hexFull.substring(4)));
            int nameSearch = -1;
            for (int i = 0; i < names.length; ++i) {
                if (hexFull.equalsIgnoreCase(pairedHexes[i])) {
                    nameSearch = i;
                    break;
                }
            }
            if (nameSearch == -1){
                System.out.println("This color has no standard name");
            }
            else {
                System.out.println(" The color is called " + names[nameSearch]);
            }

        } else if (path.equalsIgnoreCase("rgb")) {

            System.out.println("enter red value");
            String red = toHex(num.nextInt());

            System.out.println("enter green value");
            String green = toHex(num.nextInt());

            System.out.println("enter blue value");
            String blue = toHex(num.nextInt());

            System.out.println("the hex version is #" + red + green + blue);
            String hexFull = (red + green + blue);
            int nameSearch = -1;
            for (int i = 0; i < names.length; ++i) {
                if (hexFull.equalsIgnoreCase(pairedHexes[i])) {
                    nameSearch = i;
                    break;
                }
            }
            if (nameSearch == -1){
                System.out.println("This color has no standard name");
            }
            else {
                System.out.println(" The color is called " + names[nameSearch]);
            }


        } else {
            System.out.println("You Lose Enter from the list next time");
        }


    }

    public static String toHex(int n) {
        int r = 0;
        String s = "";
        char dig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (n > 0) {
            r = n % 16; //finding remainder by dividing the number by 16
            s = dig[r] + s; //adding the remainder to the result
            n = n / 16;
        }
        return s;

    }

    public static int toDecimal(String hex) {
        int sum = 0;
        int newnum = 0;
        String digit = hex.toUpperCase();
        for (int i = 0; i < digit.length(); i++) {
            char c = digit.charAt(digit.length() - i - 1);

            if (c == 'A') {
                newnum = 10;
            } else if (c == 'B') {
                newnum = 11;
            }
            else if (c == 'C') {
                newnum = 12;
            }
            else if (c == 'D') {
                newnum = 13;
            }
            else if (c == 'E') {
                newnum = 14;
            }
            else if (c == 'F') {
                newnum = 15;
            } else {
                newnum = Character.getNumericValue(c);
            }
            sum = (int) (sum + newnum * Math.pow(16, i));
        }
        return sum;
    }

}
