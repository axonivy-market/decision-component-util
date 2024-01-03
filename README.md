
# Project Title

A brief description of what this project does and who it's for


# decision-component-utils  
decision-component-utils  
  
  
# Approval Decision component #  
  
Introduction  
------------  
  
This component offers a common approach to implementing the approval flow.
User can make a decision, confirmation, leave a comment, and see the approval history in a data table.
  
Approach  
--------  
  
Comments data is stored in database table named ApprovalHistory  
  
This table will store the selected decision (column decision), comment (column comment), the approval date (column approvalDate), and selected confirmations (column selectedConfirmations).  
  
Data from this table will be used to show in the Approval History section.  
  
How to use  
----------  

1. create 2 tables in databse and adding relationship between them 

Example:

create table TicketRequest (
  	id varchar(32) not null
    ...
);
create table ApprovalHistory (
    id varchar(32) not null,
    ...
);

alter table RequestApprovalHistory 
   add constraint fk_requestApprovalHistory_request
   foreign key (requestId) 
   references TicketRequest(id)
   
alter table RequestApprovalHistory 
   add constraint fk_requestApprovalHistory_approvalHistory 
   foreign key (approvalHistoryId) 
   references ApprovalHistory(id);

2. implement 2 Java entity class by extend BaseRequest class and BaseApprovalHistory class

Example:

public class TicketRequest extends BaseRequest<ApprovalHistory>{}
public class ApprovalHistory extends BaseApprovalHistory{}

3. Integrate this component into your task dialog:  
  
Example:  
  
     <ic:com.axonivy.utils.decisioncomponent.ApprovalDecision
					id="approvalDecision"
					managedBean="#{managedBean.approvalDecisionBean}"
					validatorId="#{managedBean.approvalDecisionBean.validatorId}"
					fieldsetLegend="#{ivy.cms.co('/Dialogs/com/axonivy/utils/decisioncomponent/RequestTicketForm/DecisionLegend')}"
					fieldsetToggleable="#{true}" 
					fieldsetStyleClass="p-mt-3"
					headline="#{ivy.cms.co('/Dialogs/com/axonivy/utils/decisioncomponent/RequestTicketForm/ApprovalDecisionHeadline')}"
					headlinePanelStyleClass="" 
					headlineStyleClass="p-text-bold"
					helpText="#{ivy.cms.co('/Dialogs/com/axonivy/utils/decisioncomponent/RequestTicketForm/ApprovalDecisionHelpText')}"
					helpTextPanelStyleClass="" 
					helpTextStyleClass=""
					decisionRendered="#{managedBean.contentState.decisionRendered}"
					decisionDisable="#{managedBean.contentState.decisionDisable}"
					decisionRequired="#{managedBean.contentState.decisionRequired}"
					listenerOnDecisionAction="#{managedBean.onChangeDecision()}"
					componentToUpdateOnDecision="approvalDecision:dropDownListOfMails"
					commentRendered="#{managedBean.contentState.commentRendered}"
					commentRequired="#{managedBean.contentState.commentRequired}"
					approvalHistoryRendered="#{managedBean.contentState.approvalHistoryRendered}">

 
4. Create managed bean for this component by extending com.axonivy.utils.decisioncomponent.managedbean.AbstractApprovalDecisionBean class.  
  
By default, the component using enum com.axonivy.utils.decisioncomponent.enums.ApprovalDecisionOption for decision options.  
If you want to use your own enum as options for decision, please override methods getDecisionLabel(), getDecisions().  
  
5. Handle save/submit approval histories in your managed bean.  
  
Handle save/submit by calling methods from the managed bean created from step 4.  
Call method handleApprovalHistoryBeforeSave() when you want to save (Example: Click Save button on your dialog).  
Call method handleApprovalHistoryBeforeSubmit() when you want to submit (Example: Click Submit button on your dialog).  
  
Then map approval histories to the entity and save it.  
  
Example: com.axonivy.utils.decisioncomponent.demo.managedbean.TicketProcessBean
  
	public void save() {
		approvalDecisionBean.handleApprovalHistoryBeforeSave(this.request.getApprovalHistories());
		handleSaving();
		TicketProcessUtils.showInfo();
	}
	private void handleSaving() {
		TicketRequest saved = TicketRequestDAO.getInstance().save(this.request);
		setRequest(saved);
		this.approvalDecisionBean.setApprovalHistory(this.request.getApprovalHistories().stream()
				.filter(p -> p.getIsEditing()).findFirst().orElse(new ApprovalHistory()));
	}

6. (Optional) Customize the default sort option of the Approval history table  
  
By default, the Approval history table is sorted by approval date in descending order.  

To override the default sort order, you should override the method isApprovalHistoryTableSortDescending().  
  
Example:  

	@Override public boolean isApprovalHistoryTableSortDescending() { return false; }  

To override the default sort field, you should override the method getApprovalHistoryTableSortField().  
  
Example:  
  
	@Override public String getApprovalHistoryTableSortField() { return "displayUserName"; }  

Available sort fields:  
  
 "displayApprovalDate": approval date 
 "displayUserName": name of the creator 
 "comment": comment  


Attributes  
----------  
- managedBean: It is required. Must extend com.axonivy.utils.decisioncomponent.managedbean.AbstractApprovalDecisionBean class.  
- isReadOnly: Configures component to be read only. Default is false.  
- fieldsetToggleable: Makes fieldset toggleable. Default is false.  
- fieldsetLegend: Legend text of the fieldset.  Default is "Approval decision"
- fieldsetStyleClass: Style class of the fieldset.  
- headline: Headline text inside the component.  
- headlinePanelStyleClass: style class for the panel of the headline.  
- helpText: Help text inside the component.  
- helpTextPanelStyleClass: style class for the panel of the help text.  
- helpTextStyleClass: style class for the help text.  
- validatorId: ID of the validator, default value is "decisionComponentValidator" (com.axonivy.utils.decisioncomponent.validation.DecisionComponentValidator).  
- decisionLabel: label for the decision options.  
- decisionRequired: Flag to perform mandatory check for decision. Default is true.  
- decisionRendered: Flag to render decision options. Default is true.  
- decisionRequiredMessage: Error message to be displayed when perform mandatory check for the decision options. Default value is the CMS /Labels/RequiredFieldMessage.  
- decisionPanelStyleClass: style class for the panel of decision options.  
- listenerOnDecisionAction: listener event to be called when select a decision.  
- componentToUpdateOnDecision: components to be updated when select a decision. Default value is "@this".  
- decisionCommentLabel: label for the comment. Default value is the CMS /Labels/Comment.  
- commentRequired: Flag to perform mandatory check for comment. Default is true.  
- commentRendered: Flag to render comment. Default is true.  
- commentRequiredMessage: Error message to be displayed when perform mandatory check for comment. Default value is the CMS /Labels/RequiredFieldMessage.  
- commentPanelStyleClass: style class for the panel of comment.  
- confirmationRequired: Flag to perform mandatory check for confirmation options. Default is false.  
- confirmationRequiredMessage: Error message to be displayed when perform mandatory check for the confirmation options. Default value is the CMS /Labels/RequiredFieldMessage.  
- confirmationPanelStyleClass: style class for the panel of the confirmation options.  
- confirmationLabel: label for the confirmation options.  
- approvalHistoryRendered: Flag to render the approval history table. Default is true.  
- approvalHistoryPanelStyleClass: style class for the panel of the approval history table.  
  
Facets  
------  
- customHeadline: Custom headline. Should be using when you want a more complicated headline than a text.  

Example:  
  
	<ic:com.axonivy.utils.decisioncomponent.ApprovalDecision id="approvalDecision"  
	managedBean="#{managedBean.approvalDecisionBean}">
		<f:facet name="customHeadline">  
		  <p>Please check this <a href="www.google.com">Email</a> before proceed</p>  
		</f:facet>  
	</ic:com.axonivy.utils.decisioncomponent.ApprovalDecision>  
  
- customHelpText: Custom help text. Should be using when you want a more complicated help text.  

Example:  
  
	<ic:com.axonivy.utils.decisioncomponent.ApprovalDecision id="approvalDecision"  
	managedBean="#{managedBean.approvalDecisionBean}"> 
		<f:facet name="customHelpText">  
		  <p>Please check this <a href="www.google.com">Email</a> before proceed</p>  
		</f:facet>  
	</ic:com.axonivy.utils.decisioncomponent.ApprovalDecision>
  
- customContent: Custom content for special requirement.  

Example:  
  
	<ic:com.axonivy.utils.decisioncomponent.ApprovalDecision id="approvalDecision"  
	managedBean="#{managedBean.approvalDecisionBean}">
		<f:facet name="customContent">  
		  <h:panelGroup id="dropDownListOfMails">
			  <h:panelGroup id="mail-panel" 
				layout="block"
				styleClass="p-formgrid p-grid p-align-baseline ui-fluid"
				rendered="#{managedBean.contentState.showDropdownOfMails}">
				<div class="p-field p-text-left p-text-md-right p-col-12 p-md-2">
				  <p:outputLabel for="dropdownlist-mail"
					value="#{ivy.cms.co('/Labels/EmailAddressOfRelevantDepartment')}">
					<span class="ui-outputlabel-rfi">*</span>
				  </p:outputLabel>
				</div>
				<div class="p-field p-col-12 p-md-4">
				  <p:selectOneMenu id="dropdownlist-mail"
					value="#{managedBean.request.forwardToMail}"
					requiredMessage="#{ivy.cms.co('/Labels/RequiredFieldMessage')}">
					<f:selectItem itemLabel="SelectOne" itemValue="" />
					<f:selectItems
					  value="#{managedBean.departmentMails.entrySet()}"
					  var="department" itemLabel="#{department.key}"
					  itemValue="#{department.value}" />
					<f:validator validatorId="decisionComponentValidator" />
				  </p:selectOneMenu>
				  <p:message for="dropdownlist-mail" />
				</div>
			  </h:panelGroup>
			</h:panelGroup>
		</f:facet>
	</ic:com.axonivy.utils.decisioncomponent.ApprovalDecision>
 