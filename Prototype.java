import java.util.*;

public class Prototype {
	private static ArrayList<Context> contexts;
	private static ArrayList<Project> projects;

	public static void main(String[] args) {
		contexts = new ArrayList<Context> ();
		projects = new ArrayList<Project> ();

		Project p = new Project("Test project");
		p.addTask(new Task("Testing tasks"));
		p.addTask(new Task("This is the second task added"));

		projects.add(p);

		for (Project project : projects) {
			System.out.println("Printing tasks for " + project.getName());
			for (Task t : project.getTasks()) {
				System.out.println(t.getName());
			}
		}
	}
}

