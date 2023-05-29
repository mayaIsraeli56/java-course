public class Tester {

  public static void main(String[] args) {
    // calc
    // System.out.println(Calc.calc(3, 36, 4));

    //sink
    // int[][] a = {
    //   { 0, 1, 0, 1, 1, 0 },
    //   { 1, 0, 1, 1, 0, 0 },
    //   { 0, 0, 0, 1, 0, 1 },
    //   { 0, 0, 0, 0, 0, 0 },
    //   { 1, 0, 1, 1, 0, 0 },
    //   { 0, 1, 0, 1, 1, 1 },
    // };
    // System.out.println(Sink.isSink(a));
    
    // count
    // int[] b = {-5,-5,1,1,1,1,1,1,1,1,2,2,2,2,2,3,3,3,67,67,99};
    // System.out.println(Count.count(b, 5));

    // volume
    int[] c = {2,1,1,4,1,1,2,3,2};
    System.out.println(WaterVolume.waterVolume(c));
  }
}
