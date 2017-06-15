import java.io.*;
import java.util.*;

public class Prototype {
    private static final String fileName = "tasks";
    private static TaskManager taskManager;
    private static Scanner scanner;

    private static void displayAllTasks() {
        for (Task task : taskManager.getAllTasks()) {
            if (task.getProject() != null) {
                System.out.print(task.getProject().getName() + " - ");
            }

            System.out.print(task.getName());

            if (task.getContext() != null) {
                System.out.print(" @" + task.getContext().getName());
            }

            System.out.print('\n');
        }
    }

    private static Context getContext() {
        System.out.print("Enter the name of the context: ");
        String name = scanner.nextLine();
        return new Context(name);
    }

    private static Project getProject() {
        System.out.print("Enter the name of the project: ");
        String name = scanner.nextLine();
        return new Project(name);
    }

    private static Task getTask() {
        System.out.print("Enter the name of the task: ");
        String name = scanner.nextLine();
        Task newTask = new Task(name);
        
        System.out.print("Enter the project associated with this task: ");
        int projectNo = scanner.nextInt();
        if (projectNo >= 0 && projectNo < taskManager.getAllProjects().size()) {
            System.out.println("Adding the project" + taskManager.getAllProjects().get(projectNo));
            newTask.setProject(taskManager.getAllProjects().get(projectNo));
        }

        System.out.print("Enter the context associated with this task: ");
        int contextNo = scanner.nextInt();
        if (contextNo >= 0 && contextNo < taskManager.getAllContexts().size()) {
            newTask.setContext(taskManager.getAllContexts().get(contextNo));
        }

        return newTask;
    }

    public static void main(String[] args) {
        try {
            ObjectInputStream taskManagerReader = new ObjectInputStream(new FileInputStream(fileName));

            taskManager = (TaskManager) taskManagerReader.readObject();
            taskManagerReader.close();
        } catch (Exception e) {
            taskManager = new TaskManager();
        }         

        scanner = new Scanner(System.in);

        String command;
        while (true) {
            System.out.print("Enter the next command: ");
            command = scanner.nextLine();
            if (command.equals("context")) {
                taskManager.addContext(getContext());
            } else if (command.equals("project")) {
                taskManager.addProject(getProject());
            } else if (command.equals("task")) {
                taskManager.addTask(getTask());
            } else if (command.equals("display")) {
                displayAllTasks();
            } else {
                break;
            }
        }

        try {
            ObjectOutputStream taskManagerWriter = new ObjectOutputStream(new FileOutputStream(fileName));

            taskManagerWriter.writeObject(taskManager);
            taskManagerWriter.flush();

            taskManagerWriter.close();
        } catch (IOException ioException) {
            System.out.println ("Couldn't write current tasks to file");
        } 

        System.out.println("Exiting...");
    }
}

