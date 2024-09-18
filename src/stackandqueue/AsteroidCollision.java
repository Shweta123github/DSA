package stackandqueue;
import java.util.*;

//+--> left  - --->right
//if collision happens anyone with lesser value get destroyed otherwise goes on deleting
//output -->final state
//-ve add nko kru stack mdhe negative tevhach add honar jevha stack empty asnar sgl
//doni same astil tri pop
//tc,sc-->n
public class AsteroidCollision {

        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < asteroids.length; i++) {
                if (asteroids[i] > 0) {
                    stack.push(asteroids[i]); // Push right-moving asteroid
                } else {
                    // Process collision with left-moving asteroid
                    while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                        stack.pop(); // Destroy smaller right-moving asteroids
                    }

                    if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                        // Both asteroids are the same size, destroy both
                        stack.pop();
                    } else if (stack.isEmpty() || stack.peek() < 0) {
                        // Either stack is empty or only left-moving asteroids are left, push the current one
                        stack.push(asteroids[i]);
                    }
                }
            }

            // Convert the stack to an array for the result
            int[] result = new int[stack.size()];
            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }
            return result;
        }
    }

