import java.util.*;

public class Project {
	public Project() {
		tasks = new ArrayList<Task> ();

	}

	public Project(String newName) {
		this();
		
		setName(newName);
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task newTask) {
		tasks.add(newTask);
		newTask.setProject(this);
	}

	public ArrayList<Task> tasks;

	private String name;
}
