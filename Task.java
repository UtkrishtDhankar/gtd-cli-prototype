public class Task {
	public Task() {

	}

	public Task(String newName) {
		name = newName;	
	}

	public String getName() {
		return name;
	}

	public void setName(String newTaskName) {
		name = newTaskName;	
	}

	/*
	 * Registers this task to the project given
	 * Should only be called by the project when this task is being assigned to it
	 */
	public void setProject(Project newProject) {
		project = newProject;
	}

	public Project getProject() {
		return project;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context newContext) {
		context = newContext;	
	}

	private String name;
	private Context context;
	private Project project;
}
