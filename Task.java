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

	public Context getContext() {
		return context;
	}

	public void setContext(Context newContext) {
		context = newContext;	
	}

	private String name;
	private Context context;
}
