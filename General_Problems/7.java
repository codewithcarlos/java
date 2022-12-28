// https://leetcode.com/problems/image-overlap/description/

class Solution {
  public int shiftAndCount(int r, int c, int[][] A, int[][] B) {
    int leftShiftCount = 0;
    int rightShiftCount = 0;

    int bRow = 0;
    for (int aRow = r; aRow < A.length; aRow++) {
      int bCol = 0;
      for (int aCol = c; aCol < A.length; aCol++) {
        if (A[aRow][aCol] == 1 && B[bRow][bCol] == 1)
          leftShiftCount++;
        if (A[aRow][bCol] == 1 && B[bRow][aCol] == 1)
          rightShiftCount++;
        bCol++;
      }
      bRow++;
    }

    return Math.max(leftShiftCount, rightShiftCount);
  }

  public int largestOverlap(int[][] A, int[][] B) {
    int result = 0;
    for (int r = 0; r < A.length; r++) {
      for (int c = 0; c < A.length; c++) {
        // move the matrix A to the up-right and up-left directions.
        result = Math.max(result, shiftAndCount(r, c, A, B));
        // move the matrix B to the up-right and up-left directions,
        // which is equivalent to moving A to the down-right and down-left directions
        result = Math.max(result, shiftAndCount(r, c, B, A));
      }
    }
    return result;
  }
}
