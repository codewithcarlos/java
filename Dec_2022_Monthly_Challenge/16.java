
// https://leetcode.com/problems/implement-queue-using-stacks/description/
import java.util.*;

class MyQueue {
  Stack<Integer> stack1;
  Stack<Integer> stack2;

  public MyQueue() {
    stack1 = new Stack<>();
    stack2 = new Stack<>();
  }

  public void push(int x) {
    stack1.push(x);
  }

  public int pop() {
    if (stack2.size() > 0) {
      return stack2.pop();
    }
    while (stack1.size() > 0) {
      stack2.push(stack1.pop());
    }
    return stack2.pop();
  }

  public int peek() {
    return stack2.isEmpty() ? stack1.firstElement() : stack2.peek();
  }

  public boolean empty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */