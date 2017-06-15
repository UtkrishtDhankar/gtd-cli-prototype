import java.io.Serializable;

/*
 * Represents a context in the GTD sense.
 * */
public class Context implements Serializable {
	public Context() {

	}

	public Context(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	private String name;
}
