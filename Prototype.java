public class Prototype {
	public static void main(String[] args) {
		Project p = new Project();
		p.addTask(new Task("Testing tasks"));
		p.addTask(new Task("This is the second task added"));

		for (Task t : p.getTasks()) {
			System.out.println(t.getName());
		}
	}
}

