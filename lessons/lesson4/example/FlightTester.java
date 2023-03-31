public class FlightTester
{
     public static void main (String[]args)
     {
         Date date1=new Date(1,3,2011);
         Date date2=new Date(23,3,2011);
         Flight elal1=new Flight(100,date1,"Rome","Tel-Aviv");
         Flight elal2=new Flight(100,date2,"London","Tel-Aviv");
         Flight elal3=new Flight(elal1);
         if (elal1.equals(elal2))
                 System.out.println("elal1,elal2 alternative flights");
         else
                   System.out.println("elal1,elal2 not alternative flights");
         if (elal1.equals(elal3))
                 System.out.println("elal1,elal3 alternative flights");
         else
                   System.out.println("elal1,elal3 not alternative flights");
         
         System.out.println(elal1.toString()); 
         System.out.println(elal2.toString()); 
         System.out.println(elal3.toString()); 
         date1.setDay(2);
         if (elal1.equals(elal3))
                 System.out.println("elal1,elal3 alternative flights");
         else
                   System.out.println("elal1,elal3 not alternative flights");
         elal1.setFlightDate(date1);
         if (elal1.equals(elal3)) 
                   System.out.println("elal1,elal3 alternative flights");
           else
                   System.out.println("elal1,elal3 not alternative flights");
                  
          System.out.println(elal1.getFlightDate().getYear()); 
          Date tempDate=elal1.getFlightDate();
          int tempMonth=tempDate.getMonth();
          if (tempMonth==12){
                   tempMonth=1;
                   int tempYear=tempDate.getYear();
                   tempYear++;
                   tempDate.setYear(tempYear);
                }
          else 
                   tempMonth++;
          tempDate.setMonth(tempMonth);
          elal1.setFlightDate(tempDate);
          System.out.println(elal1.toString()); 
          elal1.book(5);
          System.out.println("Places left on ElAl1 flight :"+elal1.placesLeft());
          System.out.println("Flight Elal1 is: " + (elal1.full()?"full":"not full"));
/*

elal1,elal2 not alternative flights
elal1,elal3 alternative flights
 Date : 1/3/2011
Destination: Rome
Origin: Tel-Aviv
Capacity :100
Booked: 0
 Date : 23/3/2011
Destination: London
Origin: Tel-Aviv
Capacity :100
Booked: 0
 Date : 1/3/2011
Destination: Rome
Origin: Tel-Aviv
Capacity :100
Booked: 0
elal1,elal3 alternative flights
elal1,elal3 not alternative flights
2011
 Date : 2/4/2011
Destination: Rome
Origin: Tel-Aviv
Capacity :100
Booked: 0
Places left on ElAl1 flight :95
Flight Elal1 is: not full

*/     
                   
                  
                }
            }