
// https://leetcode.com/problems/keys-and-rooms/
import java.util.*;

class Solution {
  List<List<Integer>> rooms;
  boolean[] set;

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    this.rooms = rooms;
    this.set = new boolean[rooms.size()];
    return dfs(0, 0) == rooms.size();
  }

  public int dfs(int room, int count) {
    if (set[room])
      return count;
    set[room] = true;
    count++;
    for (int key : rooms.get(room)) {
      count = dfs(key, count);
    }
    return count;
  }
}