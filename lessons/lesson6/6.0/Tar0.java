public class Tar0 {
    public static void ArrChangeOrder(int[] arr) {

        for (int temp, i = 0, j = arr.length - 1; i < arr.length / 2; i++, j = arr.length - 1 - i) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arrToStringPrint(arr);
    }

    public static void arrToStringPrint(int[] arr) {

        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    public static void toBinary(int n) {
        String n2 = "";
        do {
            n2 = (n % 2) + n2;
            n /= 2;
        } while (n > 0);
        System.out.println(n2);
    }
}