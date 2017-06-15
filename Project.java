import java.util.*;

public class Project implements IDoable {
	public Project() {
		done = false;
		name = "";
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

    @Override
    public boolean isDone() {
		return done;
	}

    @Override
    public void setDone(boolean newDone) {
		done = newDone;
	}

	private boolean done;
	private String name;
}
