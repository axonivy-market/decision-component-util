
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
  
1. Create relationship between your data table and ApprovalHistorytable.  
  
Example:  
  
 You have a table TicketRequest, then you should create a middle table to store id of your record in TicketRequest table and id of corresponding approval histories in ApprovalHistory table.  
 
 create table TicketRequestApprovalHistory (
	ticketRequestId varchar(32) not null,
	approvalHistoryId varchar(32) not null,
	primary key (ticketRequestId, approvalHistoryId)
)

alter table TicketRequestApprovalHistory 
   add constraint fk_ticketRequestApprovalHistory_ticketRequest
   foreign key (ticketRequestId) 
   references TicketRequest(id)
   
alter table TicketRequestApprovalHistory 
   add constraint fk_ticketRequestApprovalHistory_approvalHistory 
   foreign key (approvalHistoryId) 
   references ApprovalHistory(id);
 
2. Do data mapping in Java entity class of TicketRequest table.  
  
Example:  
  
 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) @JoinTable(name = "REQUEST_APPROVAL_HISTORY", joinColumns = { @JoinColumn(name = "REQUEST_ID", referencedColumnName = ID, foreignKey = @ForeignKey(name = "FK_REQUEST_APPROVAL_HISTORY_REQUEST")) }, inverseJoinColumns = @JoinColumn(name = "APPROVAL_HISTORY_ID", referencedColumnName = ID, foreignKey = @ForeignKey(name = "FK_REQUEST_APPROVAL_HISTORY_APPROVAL_HISTORY"))) private List<ApprovalHistory> approvalHistories = new ArrayList<>();  
 
3. Integrate this component into your task dialog:  
  
Example:  
  
 <ic:com.ricoh.hr.core.component.ApprovalDecision id="decision" managedBean="#{workerPersonalDataDecisionBean}" fieldsetStyleClass="p-mt-3" headline="#{cc.attrs.managedBean.getApprovalDecisionHeadline()}" headlineStyleClass="p-md-10 p-md-offset-2" decisionRendered="#{cc.attrs.managedBean.contentState.decisionVisible}" />  
 
4. Create managed bean for this component by extending com.ricoh.hr.core.managedbean.AbstractApprovalDecisionBean class.  
  
By default, the component using enum com.ricoh.hr.core.enums.ApprovalDecisionOption for decision options.  
If you want to use your own enum as options for decision, please override methods getDecisionLabel(), getDecisions().  
  
Example: com.ricoh.hr.onboarding.prehire.managedbean.component.CheckDayOneApprovalDecisionBean  
  
5. Handle save/submit approval histories in your managed bean.  
  
Handle save/submit by calling methods from the managed bean created from step 4.  
Call method handleApprovalHistoryBeforeSave() when you want to save (Example: Click Save button on your dialog).  
Call method handleApprovalHistoryBeforeSubmit() when you want to submit (Example: Click Submit button on your dialog).  
  
Then map approval histories to the entity and save it.  
  
Example: com.ricoh.hr.onboarding.prehire.managedbean.ValidateEmployeeInformationBean  
  
 @Override public void save() throws TransactionRolledbackException { checkDayOneApprovalDecisionBean.handleApprovalHistoryBeforeSave(approvalHistories); getPreHireOnboarding().setApprovalHistories(approvalHistories); super.save(); }  
 @Override public void submit() throws TransactionRolledbackException { checkDayOneApprovalDecisionBean.handleApprovalHistoryBeforeSubmit(approvalHistories); getPreHireOnboarding().setApprovalHistories(approvalHistories); super.save(); }  
 
6. (Optional) Customize the default sort option of the Approval history table  
  
By default, the Approval history table is sorted by approval date in descending order.  
To override the default sort order, you should override the method isApprovalHistoryTableSortDescending().  
  
Example:  
  
 @Override public boolean isApprovalHistoryTableSortDescending() { return false; }  
To override the default sort field, you should override the method getApprovalHistoryTableSortField().  
  
Example:  
  
 @Override public String getApprovalHistoryTableSortField() { return "displayUserName"; }  
Available sort fields:  
  
 "displayApprovalDate": approval date "displayUserName": name of the creator "comment": comment  
Attributes  
----------  
- managedBean: It is required. Must extend com.ricoh.hr.core.managedbean.AbstractApprovalDecisionBean class.  
- isReadOnly: Configures component to be read only. Default is false.  
- fieldsetToggleable: Makes fieldset toggleable. Default is false.  
- fieldsetLegend: Legend text of the fieldset.  
- fieldsetStyleClass: Style class of the fieldset.  
- headline: Headline text inside the component.  
- headlinePanelStyleClass: style class for the panel of the headline.  
- helpText: Help text inside the component.  
- helpTextPanelStyleClass: style class for the panel of the help text.  
- helpTextStyleClass: style class for the help text.  
- validatorId: ID of the validator, default value is "ricohValidator" (com.ricoh.hr.core.validation.RicohValidator).  
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
- 
  Example:  
  
  <ic:com.ricoh.hr.core.component.ApprovalDecision id="decision"  
  managedBean="#{decisionBean}">  
  <f:facet name="customHeadline">  
  <p>Please check this <a href="www.google.com">Email</a> before proceed</p>  
  </f:facet>  
  </ic:com.ricoh.hr.core.component.ApprovalDecision>  
  
- customHelpText: Custom help text. Should be using when you want a more complicated help text.  
- 
  Example:  
  
  <ic:com.ricoh.hr.core.component.ApprovalDecision id="decision"  
  managedBean="#{decisionBean}">  
  <f:facet name="customHelpText">  
  <p>Please check this <a href="www.google.com">Email</a> before proceed</p>  
  </f:facet>  
  </ic:com.ricoh.hr.core.component.ApprovalDecision>  
  
- customContent: Custom content for special requirement.  
- 
  Example:  
  
  <ic:com.ricoh.hr.core.component.ApprovalDecision id="decision"  
  managedBean="#{decisionBean}">  
  <f:facet name="customContent">  
  <p:selectManyCheckbox id="daily-summary" value="#{data.emailSetting.emailSendDailyTaskSummary}" layout="responsive" columns="3"  
  styleClass="daily-summary">  
  <f:selectItems value="#{data.dailySummaryList}" var="day" itemLabel="#{day.getLocalizedName(ivy.session.getContentLocale())}"  
  itemValue="#{day}" />  
  </p:selectManyCheckbox>  
  </f:facet>  
  </ic:com.ricoh.hr.core.component.ApprovalDecision>

