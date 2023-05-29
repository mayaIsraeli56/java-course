public class WaterVolume {

//   public static int waterVolume(int[] a) {
//     int left = 0, right = 1, rain = 0, blocks = 0, leftHi = 0, rightHi, currMax=a[left];

//     while (right < a.length -1) {
//       leftHi = a[left];
//       rightHi = a[right];

//       if(a[currMax] < rightHi) {
//         currMax = right;
//       }

//       if (right > left + 1 && rightHi > leftHi) {
//         rain += Math.min(rightHi, leftHi) * (right - left - 1) - blocks;
//         left = right;
//         blocks = 0;
//       } else {
//         blocks += rightHi;
//       }

//       right++;
//     }

//     // right == a.length -1 -WRONG
//     if(a[currMax] < a[right]) {
//         rain += Math.min(a[right], a[left]) * (right - left - 1) - blocks;
//     } else {
//         rain += Math.min(a[currMax], a[left]) * (currMax - left - 1) - blocks;
//     }

//     return rain;
//   }
}
