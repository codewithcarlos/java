
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
import java.util.*;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);

        int arrowsShot = 1;
        Integer currentEnd = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] > currentEnd) {
                arrowsShot++;
                currentEnd = point[1];
            }
        }

        return arrowsShot;
    }
}