package org.jackkkonggg.medium;

import java.util.Stack;

public class AsteriodCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int value : asteroids) {
            if (stack.isEmpty()) {
                stack.push(value);
                continue;
            }

            boolean push = true;
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (isSignSame(value, top) || top < 0) break;
       
                int comparison = Integer.compare(Math.abs(value), Math.abs(top));
                if (comparison >= 0) stack.pop();
                if (comparison <= 0) {
                    push = false;
                    break;
                }
            }

            if (push) stack.push(value);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean isSignSame(int a, int b) {
        return a * b > 0;
    }
}
