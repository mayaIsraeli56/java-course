public class WhileLoop {
    public static void main(String[] args) {
        int num = 8525532;
        int singularity;

        while (num != 0) {
            singularity = num %10 ;
            System.out.print(singularity + " ");
            num = num / 10;
        }
    }
}