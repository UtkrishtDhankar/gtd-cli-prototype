import java.io.Serializable;
import java.util.*;

/*
 * This class manages all the tasks in the app, be they single actions,
 * assigned to projects, or in a someday/maybe list.
 * */
public class TaskManager implements Serializable {
	public TaskManager() {
		initialize();
	}

	// initializes this object, creating new lists for everything that is null
	public void initialize() {
		if (contexts == null)
			contexts = new ArrayList<>();
		
		if (projects == null)
			projects = new ArrayList<>();

		if (tasks == null)
			tasks = new ArrayList<>();

		if (inbox == null)
			inbox = new ArrayList<>();
	}

	public void addProject(Project project) {
		projects.add(project);
	}

	// Removes the project and all associated tasks
	public void removeProject(Project project) {
		boolean didRemove = projects.remove(project);
		if (didRemove) {
			ArrayList<Task> projectTasks = getTasksByProject(project);
			tasks.removeAll(projectTasks);
		}
	}

    // Adds a task, making sure to also add the associated project and context if they don't exist
	public void addTask(Task task) {
		tasks.add(task);

		if (!contexts.contains(task.getContext())) {
			contexts.add(task.getContext());
		}

		if (!projects.contains(task.getProject())) {
			projects.add(task.getProject());
		}
	}

	public void removeTask(Task task) {
		tasks.remove(task);
	}

	public void addInboxTask(String taskName) {
		inbox.add(new Task(taskName));
	}

	public void removeInboxTask(Task inboxTask) {
		inbox.remove(inboxTask);
	}

	public boolean hasUnprocessedItems() {
		return !inbox.isEmpty();
	}

	public Task popFirstUnprocessedTask() {
        if (!hasUnprocessedItems()) {
			return null;
		}

		Task taskToReturn = inbox.get(0);
		inbox.remove(0);

		return taskToReturn;
	}

	public void addContext(Context context) {
		contexts.add(context);
	}

	public void removeContext(Context context) {
		contexts.remove(context);
	}

	public ArrayList<Task> getTasksByProject(Project project) {
		ArrayList<Task> projectTasks = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getProject() == project) {
				projectTasks.add(task);
			}
		}

		return projectTasks;
	}

	public ArrayList<Task> getTasksByContext(Context context) {
		ArrayList<Task> contextTasks = new ArrayList<> ();
		for (Task task : tasks) {
			if (task.getContext() == context) {
				contextTasks.add(task);
			}
		}

		return contextTasks;
	}

	public ArrayList<Task> getTasksWithoutProjects() {
		ArrayList<Task> projectTasks = new ArrayList<>();
		for (Task task : tasks) {
			if (task.getProject() == null) {
				projectTasks.add(task);
			}
		}

		return projectTasks;
	}

	public ArrayList<Task> getTasksWithoutContext() {
		ArrayList<Task> contextTasks = new ArrayList<> ();
		for (Task task : tasks) {
			if (task.getContext() == null) {
				contextTasks.add(task);
			}
		}

		return contextTasks;
	}

	public ArrayList<Task> getAllTasks() {
		return tasks;
	}

	public ArrayList<Context> getAllContexts() {
		return contexts;
	}

	public ArrayList<Project> getAllProjects() {
		return projects;
	}

	public ArrayList<Task> getAllInboxTasks() {
		return inbox;
	}

	private ArrayList<Context> contexts;
	private ArrayList<Project> projects;
	private ArrayList<Task> tasks;
	private ArrayList<Task> inbox;
}
