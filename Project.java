import java.util.*;

public class Project {
	public Project() {

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

	private String name;
}
