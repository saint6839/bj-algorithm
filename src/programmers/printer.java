package programmers;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class printer {
    public static void main(String[] args) {
        int[] priorities = {1,2,3,4,5,6};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    static class Task {
        int location;
        int priority;

        public Task (int location, int priority) {
            this.location = location;
            this.priority = priority;
        }
    }

    public static int solution(int[] priorities, int location) {
        int result = 0;

        Queue<Task> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Task(i, priorities[i]));
        }

        int now = 0;
        while ((!queue.isEmpty())) {
            Task cur = queue.poll();
            boolean flag = false;
            for (Task task : queue) {
                if (task.priority > cur.priority) {
                    flag = true;
                }
            }
            if (flag) {
                queue.add(cur);
            } else {
                now++;
                if (cur.location == location) {
                    result = now;
                    break;
                }
            }
        }
        return result;
    }
}
