package PageUi;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import BaseTest.basePage;


public  class BookTicket extends basePage {
	
	public static final Logger log= Logger.getLogger(BookTicket.class.getName());
	//Definig locator value and store intp webelement object
	@FindBy(xpath="//div[@class='wrap']/a/img") WebElement toolTip;
	@FindBy(xpath="//input[@id='source']") WebElement Leaving_From;
	@FindBy(xpath="//ul[@id=\"ui-id-1\"]/li[text()=\"Hyderabad\"]") WebElement Leaving_Option;
	@FindBy(xpath="//input[@id='destination']") WebElement Going_To;
	@FindBy(xpath="//ul[@id=\"ui-id-2\"]/li[text()=\"Visakhapatnam\"]") WebElement Going_Option;
	@FindBy(id="datepicker1") WebElement DOJ;
	@FindBy(id="datepicker2") WebElement DOR;
	@FindBy(xpath="//a[text()='Search']") WebElement Search;
	@FindBy(xpath="//*[@id=\"filtersOnward\"]/div[2]/div[3]/div[1]/span[1]") WebElement Operator_click;
	@FindBy(xpath="(//div[@class=\"f-operator-checkbox filter-list\"])[1]/form/ul[1]/li[1]") WebElement Operator;
	@FindBy(xpath="//*[@id=\"ShowBtnHideAPSRTC1\"]") WebElement Button;
	@FindBy(xpath="(//span[text()=\"Select Seat\"])[1]") WebElement Seat;
	@FindBy(xpath="(//*[@id='pickup_id1'])[1]") WebElement BoardingPoint;
	@FindBy(xpath="(//select[@id=\"drop_id1\"])[1]") WebElement DropPoint;
	@FindBy(xpath="(//input[@id='btnEnable11'])[1]") WebElement ShowLayout;
	@FindBy(xpath="(//*[@id=\"O5-1ZZ\"])[1]") WebElement Select_Seat;
	@FindBy(xpath="//*[@id=\"frmSeat487670044\"]/div[1]") WebElement details;
	@FindBy(xpath="//input[@id=\"btnEnable1\"]") WebElement Book_Return;
	@FindBy(xpath="//*[@id=\"filtersReturn\"]/div[2]/div[3]/div[1]/span[1]") WebElement Operator_Return;
	@FindBy(xpath="//*[@id=\"filtersReturn\"]/div[2]/div[3]/div[3]/form/ul/li[1]/label") WebElement OpeartorRt;
	@FindBy(xpath="(//*[@id=\"ShowBtnHideAPSRTC1\"])[2]") WebElement Button_Rt;
	@FindBy(xpath="(//span[text()='Select Seat'])[13]") WebElement Seat_Rt;
	@FindBy(xpath="(//*[@id='pickup_id2'])[1]") WebElement BoardingPoint_Rt;
	@FindBy(xpath="(//select[@id=\"drop_id2\"])[1]") WebElement DropPoint_Rt;
	@FindBy(xpath="(//input[@id='btnEnable11'])[2]") WebElement ShowLayout_Rt;
	@FindBy(xpath="(//*[@id=\"O5-1ZZ\"])[2]") WebElement Select_SeatRt;
	@FindBy(xpath="(//input[@id='btnEnable1'])[2]") WebElement Payment;
	@FindBy(xpath="//*[@id=\"NetAmountmsg\"]") WebElement NetAmount;
	
	public BookTicket(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
public  void Book_Ticket()throws Exception
{  
	//Perform actions by using methods from basepage class
	elementVisible(30, toolTip);
	assertEquals(toolTip.getAttribute("title"),"abhibus.com - India's Fastest Online bus ticket booking site");
	log.info("Verified info page by using object:  "+toolTip.toString());
	Leaving_From.sendKeys(getData("Source"));
	log.info("Entering Source: "+Leaving_From.toString());
	elementVisible(30, Leaving_Option);
	Leaving_Option.click();
	elementVisible(30, Going_To);
	Going_To.sendKeys(getData("Destination"));
	log.info("Entering Destination: "+Going_To.toString());
	elementVisible(30, Going_Option);
	Going_Option.click();
	elementVisible(30, DOJ);
	datePicker(driver, DOJ, getData("DOJ"));
	log.info("Selecting Date fo Journey: "+DOJ.toString());
	elementVisible(30, DOR);
	datePicker(driver, DOR, getData("DOR"));
	log.info("Selecting Date fo Return: "+DOR.toString());
	elementVisible(30, Search);
	Search.click();
	log.info("Clicking on Search Button:  "+Search.toString());
	elementVisible(30, Operator_click);
	Operator_click.click();
	log.info("Clicking on Operator_option:  "+Operator_click.toString());
	elementVisible(30, Operator);
	Operator.click();
	log.info("Selecting  Operator:  "+Operator.toString());
	elementVisible(30, Button);
	Button.click();
	log.info("Clicking on button:  "+Button.toString());
	elementVisible(30, Seat);
	Seat.click();
	log.info("Selecting Seat:  "+Seat.toString());
	elementVisible(30, BoardingPoint);
	selectOption(BoardingPoint,1);
	log.info("Selecting Boarding Point:    "+BoardingPoint.toString());
	elementVisible(30, DropPoint);
	selectOption(DropPoint,1);
	log.info("Selecting Drop Point:   "+DropPoint.toString());
	elementVisible(30, ShowLayout);
	ShowLayout.click();
	log.info("Clicking on Show Layout:    "+ShowLayout.toString());
	elementVisible(30, Select_Seat);
	Select_Seat.click();
	log.info("Selecting Seat   "+Select_Seat.toString());
	elementVisible(30, Book_Return);
	Book_Return.click();
	log.info("Book_Return   "+Select_Seat.toString());
	elementVisible(30, Operator_Return);
	Operator_Return.click();
	log.info("Clicking on Operator_option:  "+Operator_Return.toString());
	elementVisible(30,  OpeartorRt);
	 OpeartorRt.click();
	log.info("Selecting  OperatorRt:  "+ OpeartorRt.toString());
	elementVisible(30, Button_Rt);
	Button_Rt.click();
	log.info("Clicking on button_return:  "+Button_Rt.toString());
	elementVisible(30, Seat_Rt);
	Seat_Rt.click();
	log.info("Selecting Seat Return:  "+Seat_Rt.toString());
	elementVisible(30, BoardingPoint_Rt);
	selectOption(BoardingPoint_Rt,1);
	log.info("Selecting Boarding Point:    "+BoardingPoint_Rt.toString());
	elementVisible(30, DropPoint_Rt);
	selectOption(DropPoint_Rt,1);
	log.info("Selecting Drop Point:   "+DropPoint_Rt.toString());
	elementVisible(30, ShowLayout_Rt);
	ShowLayout_Rt.click();
	log.info("Clicking on Show Layout:    "+ShowLayout_Rt.toString());
	elementVisible(30, Select_SeatRt);
	Select_SeatRt.click();
	log.info("Selecting Seat   "+Select_SeatRt.toString());
	elementVisible(30, Payment);
	Payment.click();
	log.info("Clicking on Continue to Payment:    "+Payment.toString());
	elementVisible(30, NetAmount);
	assertEquals(NetAmount.getText(),getData("Amount"));
	
	}

}
