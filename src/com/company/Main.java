package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
     Scanner kb = new Scanner(System.in);
        Scanner num = new Scanner(System.in);

        System.out.println("Are you entering a Color, Hex code, or RGB triplet (C/HEX/RGB) ");
        String path = kb.nextLine();

        if (path.equalsIgnoreCase("c")){



        }
        else if (path.equalsIgnoreCase("hex")){



        }
        else if (path.equalsIgnoreCase("rgb")){

            System.out.println("enter red value");
            String red = toHex(num.nextInt());

            System.out.println("enter green value");
            String green = toHex(num.nextInt());

            System.out.println("enter blue value");
            String blue = toHex(num.nextInt());

            System.out.println("the hex version is #" + red + green + blue);



        }
        else {
            System.out.println("You Lose Enter from the list next time");
        }



    }
     public static String toHex(int n){
         int r = 0;
         String s = "";
         char dig[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

         while(n>0)
         {
             r=n%16; //finding remainder by dividing the number by 16
             s=dig[r]+s; //adding the remainder to the result
             n=n/16;
         }
         return s;

     }
}
