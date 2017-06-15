/*
 * A doable thing, like a project or a single task.
 */
public interface IDoable {
    String getName();

    void setName(String name);

    boolean isDone();

    void setDone(boolean newDone);
}