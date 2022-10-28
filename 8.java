// https://leetcode.com/problems/kth-largest-element-in-a-stream/description/

import java.util.*;

class KthLargest {
  private int k;
  private PriorityQueue<Integer> heap;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    heap = new PriorityQueue<>();
    for (int num : nums) {
      heap.offer(num);
    }
    System.out.println(heap.size());
    while (heap.size() > k) {
      heap.poll();
    }
  }

  public int add(int val) {
    System.out.println(k);
    heap.offer(val);
    if (heap.size() > k) {
      heap.poll();
    }

    return heap.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
