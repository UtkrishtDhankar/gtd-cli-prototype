public class Task implements IDoable {
	public Task() {
		done = false;
		name = "";
	}

	public Task(String newName) {
        this();

		name = newName;	
	}

    @Override
	public String getName() {
		return name;
	}

    @Override
	public void setName(String newTaskName) {
		name = newTaskName;	
	}

    @Override
    public boolean isDone() {
		return done;
	}

    @Override
    public void setDone(boolean newDone) {
		done = newDone;
	}

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

    // IDoable data
	private String name;
	private boolean done;

	private Context context;
	private Project project;
}
