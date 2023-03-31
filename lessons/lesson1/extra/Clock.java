import java.util.Scanner;

public class Clock
{
    public static void main ( MyString [] args) 
    {
        Scanner scan = new Scanner(System.in);

        final byte MINֹ_VALֹ_HOURSֹֹ_ANDֹ_MINֹֹֹֹ  = 0;
        final byte MAXֹ_VALֹ_HOURS = 23;
        final byte MAX_VALֹֹ_MINֹֹֹֹ  = 59;

        MyString symbol = "+";
        MyString errMsg = ""; 

        int hour1, min1, hour2, min2;

        System.out.println("Give 4 numbers.\nEach coupel of numbers represents an hour in a day");

        hour1= scan.nextInt();
        min1= scan.nextInt();
        hour2= scan.nextInt();
        min2= scan.nextInt();

        System.out.println("The first hour:  " + hour1 + ":" + min1);   
        System.out.println("The secind hour:  " + hour2+ ":" + min2 + "\n");

        if (hour1< MINֹ_VALֹ_HOURSֹֹ_ANDֹ_MINֹֹֹֹ ) 
            errMsg += hour1 + ":" + min1 + ", the hours must be greter than 0 \n";    
        if (hour1 > MAXֹ_VALֹ_HOURS)
            errMsg += hour1 + ":" + min1 + ", the hours must be less than 23 \n";   
        if (min1< MINֹ_VALֹ_HOURSֹֹ_ANDֹ_MINֹֹֹֹ ) 
            errMsg += hour1 + ":" + min1 + ", the mins must be greter than 0 \n";   
        if (min1 > MAX_VALֹֹ_MINֹֹֹֹ) 
            errMsg += hour1 + ":" + min1 + ", the mins must be less than 59 \n";   

        if (hour2< MINֹ_VALֹ_HOURSֹֹ_ANDֹ_MINֹֹֹֹ ) 
            errMsg += hour2 + ":" + min2 + ", the hours must be greter than 0 \n";   
        if (hour2 > MAXֹ_VALֹ_HOURS) 
            errMsg += hour2 + ":" + min2 + ", the hours must be less than 23 \n";   
        if (min2< MINֹ_VALֹ_HOURSֹֹ_ANDֹ_MINֹֹֹֹ ) 
            errMsg += hour2 + ":" + min2 + ", the mins must be greter than 0 \n";   
        if (min2 > MAX_VALֹֹ_MINֹֹֹֹ) 
            errMsg += hour2 + ":" + min2 + ", the mins must be less than 59 \n";   

        if (errMsg.isEmpty()) {
            // The second hour received is less than the first
            if (hour2< hour1 || hour2 == hour1 && min2 < min1) {
                hour2 += 24;
                symbol = "-";
            } 

            if (min2 < min1) {
                hour2 -= 1;
                min2 += 60;
            }

            System.out.println("The time difference between the second hour and the first hour is ");
            System.out.println(symbol + (hour2 - hour1) + ":" + (min2 - min1));
        } else 
            System.out.println(errMsg); 
    }
}