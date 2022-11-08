package com.anasim.cm.masterdsa.character_array_string03;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterArrayAndString01 {

    public static void main(String[] args) {

        char[] chArr1 = {'A', 'z', 'e', '@', '3', 'm', 'P', '0'};

        System.out.println("chArr1: " + chArr1);

        System.out.print("chArr1: ");
        for (char ch : chArr1) {
            System.out.print(ch + ", ");
        }
        System.out.println();

        String str1 = "Hello World, Welcome To The World Of DSA";
        System.out.println("str1: " + str1);

        char[] chArr2 = new char[str1.length()];
        for (int i = 0; i < chArr2.length; i++) {
            chArr2[i] = str1.charAt(i);
        }

        System.out.print("chArr2: ");
        for (char ch : chArr2) {
            System.out.print(ch);
        }
        System.out.println();

        String str2 = "Hello @every1, 0 To 9 are digits, #DIGIT";
        System.out.println("str2: " + str2);

        char[] chArr3 = str2.toCharArray();
        System.out.println("chArr3: " + Arrays.toString(chArr3));

        Scanner scn = new Scanner(System.in);

        String scnStr1 = scn.next();
        System.out.println("scnStr1: " + scnStr1);

        String scnStr2 = scn.nextLine();
        System.out.println("scnStr2: " + scnStr2);

        char scnCh1 = scn.next().charAt(0);
        System.out.println("scnCh1: " + scnCh1);

        boolean scnBol1 = scn.nextBoolean();
        System.out.println("scnBol1: " + scnBol1);

        int scnInt1 = scn.nextInt();
        System.out.println("scnInt1: " + scnInt1);

        double scnDob1 = scn.nextDouble();
        System.out.println("scnDob1: " + scnDob1);
    }
}
