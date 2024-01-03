package com.axonivy.utils.decisioncomponent.test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.axonivy.ivy.webtest.IvyWebTest;
import com.axonivy.ivy.webtest.engine.EngineUrl;
import com.axonivy.ivy.webtest.primeui.PrimeUi;
import com.axonivy.ivy.webtest.primeui.widget.SelectOneRadio;

@IvyWebTest
public class DecisionComponentWebTest {

	@BeforeEach
	void startProcess() {
		open(EngineUrl.createProcessUrl("/decision-component-utils-demo/18BA886784A13BAE/start.ivp"));
	}

	@Test
	public void checkButtonsExists() {
		$(By.id("content-form:cancel")).shouldBe(visible).click();
		$(By.id("content-form:save-button")).shouldBe(visible).click();
		$(By.id("content-form:complete-button")).shouldBe(visible).click();
	}

	@Test
	public void checkFieldsExists() {
		$(By.id("content-form:approvalDecision:headline-panel")).shouldBe(visible);
		$(By.id("content-form:approvalDecision:helptext-panel")).shouldBe(visible);
		$(By.id("content-form:approvalDecision:decision-panel")).shouldBe(visible);
		$(By.id("content-form:approvalDecision:comment-panel")).shouldBe(visible);
		$(By.id("content-form:approvalDecision:approval-history-table-panel")).shouldBe(visible);
	}

	@Test
	public void testCustomContentWhenDecisionOptionClick() {
		// select radio "Forward to"
		SelectOneRadio decision = PrimeUi.selectOneRadio(By.id("content-form:approvalDecision:decision-options"));
		decision.selectItemByLabel("Forward to");

		// expect when radio "Forward to" selected component list email will be visible
		$(By.id("content-form:approvalDecision:dropDownListOfMails")).shouldBe(visible);
	}

	// to be continue: test to go next step
	@Test
	public void testChangeDecisionOption() {
		// set select decision
		SelectOneRadio decision = PrimeUi.selectOneRadio(By.id("content-form:approvalDecision:decision-options"));
		decision.selectItemByLabel("Send to reviewer");
	}

	// to be continue: test to show approval history
	@Test
	public void testShowApprovalHistoryContent() {
	}

	// to be continue: test to show confirmation
	@Test
	public void testShowConfirmationSection() {
		$(By.id("content-form:save-button")).click();
	}

}
