
/**
 * 
 * @author (staff)
 * @version (2023b)
 */
public class Ex13Solution
{
    //question 1
    public static int shortestRoad(int[] road1, int[] road2)
    {
        int n=road1.length;
        int rightSum1=0;
        int rightSum2=0;
        for(int i=0; i<n; i++)
        {
            rightSum1+=road1[i];
            rightSum2+=road2[i];
        }
        int globalMin=Math.min(rightSum1,rightSum2);
        int leftSum1=0;
        int leftSum2=0;
        int currMin;
        for(int i=0; i<n; i++)
        {
            leftSum1+=road1[i];
            rightSum1-=road1[i];
            leftSum2+=road2[i];
            rightSum2-=road2[i];
            currMin=Math.min(leftSum1+rightSum2, leftSum2+rightSum1);
            globalMin = Math.min(globalMin,currMin);
        }
        return globalMin;
    }
    
    // quest 2
    public static int missingValue(int[] arr)
    {
        int d= (arr[arr.length-1]-arr[0])/arr.length;
        int left=0, right=arr.length-1;
        int middle;

        while(left!=right)
        {
            middle=(right+left)/2;
            if(arr[middle]==arr[0]+d*middle)
            {
                if(arr[middle]+d!=arr[middle+1])
                    return arr[middle]+d;

                left=middle+1;
            }
            else
                right=middle-1;

        }
        return arr[left]+d;
    }

    // question 3    
    public static int longestPalindrome(int[] arr)
    {
        return longestPalindrome(arr, 0,arr.length-1);
    }

    private static int longestPalindrome(int[] arr, int i, int j)
    {
        // if(i==j) return 1;
        if(isPalindrome(arr,i, j)) return j-i+1;
        int first=longestPalindrome(arr, i+1,j);
        int second=longestPalindrome(arr, i, j-1);
        return Math.max(first, second);
    }

    private static boolean isPalindrome(int[] arr, int i, int j)
    {
        if(i>=j) return true;
        if(arr[i]!=arr[j]) return false;
        return isPalindrome(arr,i+1, j-1);
    }

    // question 4
    public static boolean isSum(int[] a, int num)
    {
        return isSum(a, num, 0, false);
    }

    private static boolean isSum(int[] a, int num, int i, boolean prevInSum)
    {
        if(num == 0) return true;
        if(num<0) return false;
        if(i>=a.length) return false;
        boolean currInSum, currNotInSum;
        if(prevInSum)
        {
            currInSum=isSum(a, num-a[i],i+2, false);
        }
        else
        {
            currInSum=isSum(a,num-a[i],i+1, true);
        }
        currNotInSum = isSum(a,num, i+1,false);
        return currInSum||currNotInSum;
    }

}
