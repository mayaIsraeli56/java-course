public class Ex13 {


    /**Q1
     *  calculates the shortest way from given two roads
     * time complexity: O(n)
     * one for loop for summing the roads, in parallel to another for loop that updating the minimum.
     * the loop is determined for N steps as the length of the array ---> O(n)
     * the loops are independent, so it is O(n).
     * space complexity: O(1)
     * no additional space needed for this computation, we didn't use any other space in memory.
     * the data is saved in few variables such as sum1 and sum2, ect.
     * in the second for loop we updated the minimum everytime by overriding it on the same variable.
     * @param road1
     * @param road2
     * @return int. integer number that represents the time in minutes for the shortest road.
     */
    public static int shortestRoad (int [] road1, int [] road2)
    {
        //sums up road1 and road2
        int N=road1.length; //same for road2
        int sum1=0;
        int sum2=0;
        for (int i=0;i<N;i++)
        {
            sum1=sum1+road1[i];
            sum2=sum2+road2[i];
        }
        //initialize minimum to be sum2 and res also.
        //using for loop and checking from the end.
        //every iteration we subtract from the end the last item from road2 and
        //adding the last item from road1. that way we can check easily where is the
        //point for us to move to the other road for shortest path.
        int currMin=sum2;
        int res=sum2;
        for (int i=N;i>0;i--)
        {
            res=res-road2[i-1]+road1[i-1];
            if (res<currMin)
            {
                currMin=res;
            }
        }
        res=sum1;
        for (int i=N;i>0;i--)
        {
            res=res-road1[i-1]+road2[i-1];
            if (res<currMin)
            {
                currMin=res;
            }
        }

        return currMin;
    }


//#################################################################################################################################


    /**Q2
     * time complexity: O(logn)
     * binary search is o(logn) and that the main idea here, "missingvalueBS" is an implementation of Binary search only.
     * we wanted to check if the middle element is the right value, because we already have the difference of the sequence so by the
     * arithmetic sequence formula we can compute the middle element's value.
     * every step we ignore half of the sequence, so it is O(log(n)).
     * space comlexity: O(1)
     * no needed additional memory space for this method. data is saved in few variables (independent on n, the length of arr)
     * and by the loop, every step the variable is override --->O(1)
     *
     *
     * A method to find a missing value in an arithmetic sequence.
     * @param arr
     * @return integer that represents the value of the missing element.
     */
    public static int missingValue(int[] arr)
    {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;

        return missingValueBS(arr, 0, arr.length - 1, diff);
    }
    
    private static int missingValueBS(int[] arr, int low, int high, int diff)
    {
        int mid;
        while (low <= high)
        {
            mid = (low + high) / 2;
            if ((arr[mid] - arr[0]) / diff == mid)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return arr[high] + diff;
    }


//##########################################################################################################################


    /** Q3
     * checks for longest palindrome in a given array
     * time complexity: O(n^2), because we check the array from every position to the rest of the array
     * which mean On)*O(n)=O(n^2).
     * space complexity: O(1), no additional space in memory needed. only few finite variables
     * to store data, such as i and j. (independent in arr.length).
     * @param arr
     * @return integer. int number that represents the longest palindorme in a given array.
     */
    public static int longestPalindrome (int[] arr)
    {
        int j=arr.length-1;
        int i=0;
        return longestPalindrome(arr,i,j);
    }

    private static int longestPalindrome (int[] arr,int i,int j)
    {

        //two base cases
        if (i==j)
        {
            return 1;
        }
        if (i>j)
        {
            return 0;
        }


        //check if first element and last element are equal. if so, we will call the function again and check
        //and remember to add +2, but now we will check if the next element is equal to the one before end, and so on.
        if (arr[i]==arr[j])
        {
            int subLength=longestPalindrome(arr,i+1,j-1);
            if (subLength==j-i-1)
            {
                return 2+subLength;
            }
        }

        //the above not happening, we will call for two functions and take the maximum of them.
        //the first function will increase i by 1 and the other will decrease j-1.
        //in that situation we will check for all possible combinations of the array.
        return Math.max(longestPalindrome(arr, i + 1, j), longestPalindrome(arr, i, j - 1));

    }


//##############################################################################################################################
    /**
     * isSum - Q4 maman 13
     * @param a
     * @param num
     * @return boolean
     */
    public static boolean isSum(int[] a,int num)
    {
        if (num==0) // because empty subset is a valid result.
        {
            return true;
        }
        if (a.length==0) // if we reached here, means num!=0 and if we have empty arr - we will return false
        {                  // because we have no elements to sum up to reach num.
            return false;
        }
        // from here and on we will check manually ("handly") the options of which array is less than 3 elements.
        if (a.length==1 && a[0]==num)
        {
            return true;
        }
        if(a.length==2 && a[0]+a[1]==num || a.length==2 && a[1]==num || a.length==2 && a[0]==num)
        {
            return true;
        }

        // array has 3 or more elements, and we will check by recursion from this point by overloading.
        else
            return isSum(a,0,1,2,num);
    }

    private static boolean isSum(int[] a,int i, int j,int k, int num)
    {
        // if we reached end (k is our indicate) so again we will check manually because
        // in this point we have 3 valid elements in array which we have to check about them.
        if(k==a.length-1)
        {
            if(a[k-2]==num || a[k-2]+a[k]==num ||a[k]==num || a[k-2]+a[k-1]==num
                    ||a[k-1]+a[k]==num ||a[k-1]==num)
            {
                return true;
            }
        }
        // if we got out from the limits of the array, means we didn't catch any valid result.
        if(k>= a.length)
        {
            return false;
        }
        // checking if i j k are 3 following indexes (by absolute value)
        // if yes, we will ignore the element in this index, and for that we have 3 options
        // example: if i=0 j=1 k=2, so we will check: 123,023,013
        // and we won't decrease num in this situation, because we want to check a valid result for
        // num without this element!
        if (Math.abs(i-j)==1 && Math.abs(j-k)==1)
        {
            return isSum(a,j,k,k+1,num)
                    ||isSum(a,i,k,k+1,num)
                    || isSum(a,i,j,k+1,num);
        }

        // above not happening, especially the last condition not happening, which means
        // i j k are not 3 following indexes, so we will check for the same indexes as above
        // but now we will decrease num by the element we "ignored".
        else
        {
            return isSum(a,j,k,k+1,num-a[i])
                    ||isSum(a,i,k,k+1,num-a[j])
                    || isSum(a,i,j,k+1,num-a[k]);
        }
    }

//    public static void main(String[] args)
//    {
//    }
}

