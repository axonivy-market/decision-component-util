
create table request (
	id varchar(32) not null,
	version int,
	created_by varchar(255),
	created_date datetime2,
	deleted_by varchar(255),
	deleted_date datetime2,
	modified_by varchar(255),
	modified_date datetime2,
	
	ticket_title varchar(250),
	ticket_number varchar(250),
	tickt_type varchar(250),
	ticket_raiser varchar(250),
	ticket_description varchar(1000),
	
	primary key (id)
)

create table approval_history (
	id varchar(32) not null,
	version int,
	created_by varchar(255),
	created_date datetime2,
	deleted_by varchar(255),
	deleted_date datetime2,
	modified_by varchar(255),
	modified_date datetime2,
	
	approval_date datetime2,
	comment varchar(1000),
	decision varchar(100),
	is_editting bit,
	selected_confirmations varchar(1000),
	
	primary key (id)
)

create table request_approval_history (
	request_id varchar(32) not null,
	approval_history_id varchar(32) not null,
	primary key (request_id, approval_history_id)
)

alter table request_approval_history 
   add constraint fk_request_approval_history_request 
   foreign key (request_id) 
   references request
   
alter table request_approval_history 
   add constraint fk_request_approval_history_approval_history 
   foreign key (approval_history_id) 
   references approval_history
   

   



