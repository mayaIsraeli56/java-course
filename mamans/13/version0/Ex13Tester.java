public class Ex13Tester
{
    
    public static void main(String[] args) {
        //////////////////
        // shortestRoad //
        //////////////////
        System.out.println("shortestRoad test results:");
        int[] road1_1 = {5,4,5,8,12,9,9,3};
        int[] road1_2 = {7,3,3,12,10,2,10,7};
        int[] road2_1 = {1,1,1,1,1};
        int[] road2_2 = {2,2,2,2,2};
        int[] road3_1 = {1,2,1,2,1};
        int[] road3_2 = {1,2,1,2,1};
        System.out.println("Result: " + Ex13.shortestRoad(road1_1, road1_2) + " Expected: 49");
        System.out.println("Result: " + Ex13.shortestRoad(road2_1, road2_2) + " Expected: 5");
        System.out.println("Result: " + Ex13.shortestRoad(road3_1, road3_2) + " Expected: 7");
        
        ///////////////////////
        // longestPalindrome //
        ///////////////////////
        System.out.println("\nlongestPalindrome test results:");
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,9,4,3,4};
        int[] arr3 = {5,3,5,1,7,9,4,2,1,1,2,4};
        int[] arr4 = {8,8};
        int[] arr5 = {6};
        int[] arr6 = {2,58,10,20,10,20,30,40,8,2,40,30,20,10};
        System.out.println("Result: " + Ex13.longestPalindrome(arr1) + " Expected: 1");
        System.out.println("Result: " + Ex13.longestPalindrome(arr2) + " Expected: 3");
        System.out.println("Result: " + Ex13.longestPalindrome(arr3) + " Expected: 6");
        System.out.println("Result: " + Ex13.longestPalindrome(arr4) + " Expected: 2");
        System.out.println("Result: " + Ex13.longestPalindrome(arr5) + " Expected: 1");
        System.out.println("Result: " + Ex13.longestPalindrome(arr6) + " Expected: 3");
        
        //////////////////
        // missingValue //
        //////////////////
        System.out.println("\nmissingValue test results:");
        int[] seq1 = {7,15,19,23,27,31,35};
        int[] seq2 = {-2,1,4,7,10,13,16,22,25};
        int[] seq3 = {20,14,8,2,-4,-10,-22,-28,-34,-40};
        System.out.println("Result: " + Ex13.missingValue(seq1) + " Expected: 11");
        System.out.println("Result: " + Ex13.missingValue(seq2) + " Expected: 19");
        System.out.println("Result: " + Ex13.missingValue(seq3) + " Expected: -16");

        ///////////
        // isSum //
        ///////////
        System.out.println("\nisSum test results:");
        int[] sumArr1 = {1,2,3,8,9,10};
        int[] sumArr2 = {1,2,3,8,9,10};
        int[] sumArr3 = {-3,-1,6,9,13,4};
        int[] sumArr4 = {4,5,4};
        int[] sumArr5 = {1,1,1,1,1,1,1,1};
        System.out.println("Result: " + Ex13.isSum(sumArr1, 6) + " Expected: false");
        System.out.println("Result: " + Ex13.isSum(sumArr2, 17) + " Expected: true");
        System.out.println("Result: " + Ex13.isSum(sumArr3, -4) + " Expected: true");
        System.out.println("Result: " + Ex13.isSum(sumArr4, 13) + " Expected: false");
        System.out.println("Result: " + Ex13.isSum(sumArr5, 5) + " Expected: true");
    }
    
}
