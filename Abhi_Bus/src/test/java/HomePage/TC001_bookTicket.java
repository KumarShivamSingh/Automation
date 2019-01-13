// Creating test class for executing Book_Ticket method of BookTicket class
package HomePage;
import org.testng.annotations.Test;

import BaseTest.basePage;
import PageUi.BookTicket;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;

public class TC001_bookTicket extends basePage {
	public static final Logger log=Logger.getLogger(TC001_bookTicket.class.getName());
  
  @BeforeTest
  public void SetUp() throws Exception {
	  browserLaunch(getData("browser"),getData("url"));
  }
  @Test
  public void Ticket_Booking() throws Exception {
	  log.info("-----Test Statred-----");
	  BookTicket ticket=new BookTicket(driver);
	  ticket.Book_Ticket();
	      
  }
 
  @AfterTest
  public void KillProcess() {
  }

}
