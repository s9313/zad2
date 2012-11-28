package meteo.db;

public class Operator {

	private long id;
	
	private String name;
	
	public Operator() {
	}
	
	public Operator(String name) {
		super();
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
