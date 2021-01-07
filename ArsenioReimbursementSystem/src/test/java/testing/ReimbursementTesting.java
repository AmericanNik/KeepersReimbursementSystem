package testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.ArsenioReimbursementSystem.model.ArsReimbursement;
import com.ArsenioReimbursementSystem.service.ArsReimbursementService;
import com.ArsenioReimbursementSystem.service.ArsReimbursementServiceImpl;

public class ReimbursementTesting {

	ReimbursementTesting reimbursementTesting;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		System.out.println("---Before Class");
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception{
		System.out.println("---After Class");
	}
	
	
	@Before
	public void setUp() throws Exception{
		System.out.println("before every test");
	}
	
	@After
	public void tearDown() throws Exception{
		System.out.println("after every test");
	}
	
	
	//testing account login
	
	@Test
	public void accountAuthorIdTest() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("4", Integer.toString(reimb.getReimbAuthor()));
		
	}

	@Test
	public void reimbStatusIdTest() throws Exception{
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
				
		assertNull(reimb.getReimbStatusId());
//		Assert.
	}
	
	
	@Test
	public void testingBalance() throws Exception{
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("1500.66",Double.toString(reimb.getReimbAmount()));
	}
	
	@Test
	public void testingDescription() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("Another test description!", reimb.getReimbDescription() );
			
	}
	
	@Test
	public void reimbRoleId() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("1", Integer.toString(reimb.getAuthorRoleId()));
		
	}
	
	@Test
	public void authFirstName() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("Star", reimb.getAuthorFirstName());
		
	}
	
	@Test
	public void authLastName() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("Sanoin", reimb.getAuthorLastName());
		
	}
	
	@Test
	public void reimbId() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("4", Integer.toString(reimb.getReimbId()));
		
	}
	
	@Test
	public void authEmail() throws Exception{
		
		ArsReimbursementService reimbServ = new ArsReimbursementServiceImpl();
		
		ArsReimbursement reimb = reimbServ.getReimbursementById(4);
		
		assertEquals("starsanoin@mail.com", reimb.getAuthorEmail());
		
	}
	

	
	
	
}
