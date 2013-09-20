create table ACCOUNT(
	username VARCHAR(100),
	password VARCHAR(100) not null,
	id varchar2(20),
	primary key(username),
	unique(id)
);

create table PATIENT(
	pid varchar2(20), 
	name varchar2(20),
	dob varchar2(20),
	gender VARCHAR(100),
	allergies VARCHAR(100),
	medication VARCHAR(100),
	history VARCHAR(100),
	econtact VARCHAR(100),
	primary key(pid)
);

create table DOCTOR(
	did varchar2(20),
	name varchar2(20),
	gender varchar2(20),
	hospital varchar2(20),
	specialization varchar2(20),
	dPhone varchar2(20),
	primary key(did)
);

create table APPOINTMENT(
	aid varchar2(20),
	dates varchar2(20),
	did varchar2(20),
	pid varchar2(20),
	reason VARCHAR(100),
	notes VARCHAR(100),
	primary key(aid)
);

