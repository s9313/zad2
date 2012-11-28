package meteo.db;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;


public class PodmiotManagerTest {

	PodmiotManager podmiotManager = new PodmiotManager();
	
	private final static String NAME_1 = "Pogodynka";
	
	@Test
	public void checkConnection(){
		assertNotNull(podmiotManager.getConnection());
	}
	
	public void checkAdding(){
		
		Operator operator = new Operator(NAME_1);
		
		podmiotManager.clearPersons();
		assertEquals(1,podmiotManager.addPerson(operator));
		
		List<Operator> persons = podmiotManager.getAllPersons();
		Operator personRetrieved = persons.get(0);
		
		assertEquals(NAME_1, personRetrieved.getName());
		
	}
}
