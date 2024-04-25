package com.axonivy.utils.approvaldecision.test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import java.net.URLEncoder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.primeui.PrimeUi;
import com.axonivy.ivy.webtest.primeui.widget.SelectOneRadio;
import com.axonivy.ivy.webtest.primeui.widget.Table;
import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.open;



import static com.codeborne.selenide.Condition.*;



@IvyWebTest
public class ApprovalDecisionWebTest {

	private static final String DECISION_OPTION_FORWARD_TO = "Forward to";
	private static final String DECISION_OPTION_SEND_TO_REVIEWER = "Send to reviewer";
	private static final String DECISION_OPTION_APPROVE = "Approve";

	private static final String REQUEST_COMMENT = "Please review my ticket request";
	private static final String OK_COMMENT = "Ok";
	
	private final static String BASE_URL = "http://atomic.server.ivy-cloud.com:8082/";
	private final static String PROJECT_NAME = "approval-decision-utils";
	private final static String LOGIN_URL_PATTERN = "/pro/approval-decision-utils-demo/18EF413FC8C934DE/start.ivp?username=%s&password=%s";
	
	@BeforeAll
	public static void setupCredential() {
		try {
			//String username = URLEncoder.encode("user1", "UTF-8");
			//String password = URLEncoder.encode("123456", "UTF-8");

			//open(String.format(BASE_URL + PROJECT_NAME + LOGIN_URL_PATTERN, username, password));
			
			openApprovalDecisionUtils();
			login();
			

		} catch (Exception ex) {
			System.out.println("error while trying to login: "+ex);
		}

		Selenide.sleep(1000);
	}
	
	
	private static void login() {
		$(By.id("login:login-form:username")).should(editable).sendKeys("user1");
		$(By.id("login:login-form:password")).should(editable).sendKeys("123456");
		$(By.id("login:login-form:login-command")).shouldBe(enabled).click();
		$(By.id("welcome-welcome_1:welcome-text")).shouldBe(visible, text("welcome to the Axon Ivy Portal!"));
	}

	private static void openApprovalDecisionUtils() {
		open(BASE_URL +  PROJECT_NAME +"/");
	}


	

	@BeforeEach
	void startProcess() {
		open(BASE_URL + PROJECT_NAME +"/pro/approval-decision-utils-demo/18BA886784A13BAE/start.ivp");
	}

	@Test
	public void checkButtonsExists() {
		$(By.id("content-form:cancel")).shouldBe(visible);
		$(By.id("content-form:save-button")).shouldBe(visible);
		$(By.id("content-form:complete-button")).shouldBe(visible);
	}

	@Test
	public void checkFieldsExists() {
		$(By.id("content-form:approval-decision:headline-panel")).shouldBe(visible);
		$(By.id("content-form:approval-decision:helptext-panel")).shouldBe(visible);
		$(By.id("content-form:approval-decision:decision-panel")).shouldBe(visible);
		$(By.id("content-form:approval-decision:comment-panel")).shouldBe(visible);
		$(By.id("content-form:approval-decision:approval-history-table-panel")).shouldBe(visible);
	}

	@Test
	public void testShowCustomContentWhenDecisionOptionClick() {
		// select radio "Forward to"
		SelectOneRadio decision = PrimeUi.selectOneRadio(By.id("content-form:approval-decision:decision-options"));
		decision.selectItemByLabel(DECISION_OPTION_FORWARD_TO);

		// expect when radio "Forward to" selected component list email will be visible
		$(By.id("content-form:approval-decision:dropdown-list-of-mails")).shouldBe(visible);
	}

	@Test
	public void testButtonSubmitWorking() {
		// set select decision
		SelectOneRadio decision = PrimeUi.selectOneRadio(By.id("content-form:approval-decision:decision-options"));
		decision.selectItemByLabel(DECISION_OPTION_SEND_TO_REVIEWER);

		$(By.id("content-form:approval-decision:decision-comment")).setValue(REQUEST_COMMENT);
		$(By.id("content-form:complete-button")).click();
		Selenide.sleep(1000);

		// assert
		$(By.id("content-form:approval-decision:decision-comment")).shouldBe(exactText(""));
	}

	@Test
	public void testShowApprovalHistoryContent() {
		// set select decision
		SelectOneRadio decision = PrimeUi.selectOneRadio(By.id("content-form:approval-decision:decision-options"));
		decision.selectItemByLabel(DECISION_OPTION_SEND_TO_REVIEWER);

		$(By.id("content-form:approval-decision:decision-comment")).setValue(REQUEST_COMMENT);
		$(By.id("content-form:complete-button")).click();
		Selenide.sleep(1000);

		Table table = PrimeUi.table(By.id("content-form:approval-decision:approval-history-table"));
		table.contains(DECISION_OPTION_SEND_TO_REVIEWER);
		table.contains(REQUEST_COMMENT);
	}

	@Test
	public void testShowConfirmationOption() {
		// set select decision
		SelectOneRadio decisionRequest = PrimeUi
				.selectOneRadio(By.id("content-form:approval-decision:decision-options"));
		decisionRequest.selectItemByLabel(DECISION_OPTION_SEND_TO_REVIEWER);

		$(By.id("content-form:approval-decision:decision-comment")).setValue(REQUEST_COMMENT);

		$(By.id("content-form:complete-button")).click();
		Selenide.sleep(1000);

		SelectOneRadio decisionReview = PrimeUi
				.selectOneRadio(By.id("content-form:approval-decision:decision-options"));
		decisionReview.selectItemByLabel(DECISION_OPTION_APPROVE);

		$(By.id("content-form:approval-decision:decision-comment")).setValue(OK_COMMENT);

		$(By.id("content-form:complete-button")).click();
		Selenide.sleep(1000);

		// assert content history
		Table table = PrimeUi.table(By.id("content-form:approval-decision:approval-history-table"));
		table.contains(DECISION_OPTION_SEND_TO_REVIEWER);
		table.contains(DECISION_OPTION_APPROVE);
		table.contains(REQUEST_COMMENT);
		table.contains(OK_COMMENT);

		// assert show confirmation option
		$(By.id("content-form:approval-decision:confirmation-options")).shouldBe(visible);
	}

}
