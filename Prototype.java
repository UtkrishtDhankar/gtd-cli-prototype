import java.util.*;

public class Prototype {
    private static ArrayList<Context> contexts;
    private static ArrayList<Project> projects;
    private static ArrayList<Task> tasks;

    public static void main(String[] args) {
        contexts = new ArrayList<Context> ();
        projects = new ArrayList<Project> ();
        tasks = new ArrayList<Task> ();

        Scanner scanner = new Scanner(System.in);

        String command;
        while (scanner.hasNext()) {
            command = scanner.next();
            if (command.equals("context")) {
                String contextName = scanner.nextLine();
                
                contexts.add(new Context(contextName));
            } else if (command.equals("project")) {
                projects.add(new Project(scanner.nextLine()));
            } else if (command.equals("task")) {
                Task newTask = new Task();
                
                int projectNo = scanner.nextInt();
                int contextNo = scanner.nextInt();
                newTask.setContext(contexts.get(contextNo));
                newTask.setProject(projects.get(projectNo));

                newTask.setName(scanner.nextLine());
                tasks.add(newTask);
            } else if (command.equals("display")) {
                int projectNo = scanner.nextInt();

                Project projectToDisplay = projects.get(projectNo);
                System.out.println(projectToDisplay.getName() + ": ");
                for (Task task : tasks) {
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

