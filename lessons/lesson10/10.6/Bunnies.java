public class Bunnies {
  
    public static int reproduction(int monthes) {
        if(monthes <=2 ) {
            return 1;
        } 

        return reproduction(monthes -1) + reproduction(monthes -2);
    }
}
