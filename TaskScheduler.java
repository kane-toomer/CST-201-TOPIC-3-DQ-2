import java.util.PriorityQueue;

public class TaskScheduler {
    // Use a priority queue to store tasks with their priorities.
    private PriorityQueue<Task> taskQueue = new PriorityQueue<>();

    // Class representing a task.
    private static class Task implements Comparable<Task> {
        String name;
        int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        // Compare tasks based on their priorities.
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority, other.priority);
        }
    }

    // Method to add a task to the scheduling queue.
    public void addTask(String name, int priority) {
        taskQueue.offer(new Task(name, priority));
    }

    // Method to execute the highest priority task.
    public void executeNextTask() {
        if (!taskQueue.isEmpty()) {
            Task nextTask = taskQueue.poll();
            System.out.println("Executing task: " + nextTask.name);
        } else {
            System.out.println("No tasks to execute.");
        }
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Add tasks with priorities.
        scheduler.addTask("Task A", 2);
        scheduler.addTask("Task B", 1);
        scheduler.addTask("Task C", 3);

        // Execute tasks in order of priority.
        scheduler.executeNextTask(); // Executes Task C
        scheduler.executeNextTask(); // Executes Task A
        scheduler.executeNextTask(); // Executes Task B
        scheduler.executeNextTask(); // No tasks left
    }
}
