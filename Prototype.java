import java.util.*;

public class Prototype {
    private static TaskManager taskManager = new TaskManager();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        while (scanner.hasNext()) {
            command = scanner.next();
            if (command.equals("context")) {
                String contextName = scanner.nextLine();
                taskManager.addContext(new Context(contextName));
            } else if (command.equals("project")) {
                taskManager.addProject(new Project(scanner.nextLine()));
            } else if (command.equals("task")) {
                Task newTask = new Task();
                
                int projectNo = scanner.nextInt();
                int contextNo = scanner.nextInt();
                newTask.setContext(taskManager.getAllContexts().get(contextNo));
                newTask.setProject(taskManager.getAllProjects().get(projectNo));

                newTask.setName(scanner.nextLine());

                taskManager.addTask(newTask);
            } else if (command.equals("display")) {
                int projectNo = scanner.nextInt();

                Project projectToDisplay = taskManager.getAllProjects().get(projectNo);
                System.out.println(projectToDisplay.getName() + ": ");
                for (Task task : taskManager.getTasksByProject(projectToDisplay)) {
                    if (task.getProject() == projectToDisplay) {
                        System.out.println(task.getName() + " @" + task.getContext().getName());
                    }
                }
            } else {
                break;
            }
        }

        System.out.println("Exiting...");
    }
}

