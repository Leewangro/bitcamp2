# 변경 내역
- AppServer.java 추가
- ServerRequest.java 추가
- ServerResponse.java 추가
- Controller.java 변경
- AppClient.java 추가
- BoardXxxController.java 변경
- ClassroomXxxController.java 변경

...
CREATE TABLE pms_classroom(
    crno int not null,
    titl varchar(255) not null,
    sdt datetime not null,
    edt datetime not null,
    room varchar(50) 
);

alter table pms_classroom
    add constraint pms_classroom_pk primary key (crno);
    
alter table pms_classroom
	modify column crno int not null auto_increment;


CREATE TABLE pms_team(
	name varchar(100) not null,
	dscrt text,
	max_qty int not null,
	sdt datetime not null,
	edt datetime not null
);

alter table pms_team
    add constraint pms_team_pk primary key (name);
    
create table pms_task(
	tano int not null,
	titl varchar(255) not null,
	sdt datetime not null,
	edt datetime not null,
	stat int default 0,
	mid varchar(20) not null,
	tnm varchar(100) not null
);

alter table pms_task
	add constraint pms_task_pk primary key (tano);
alter table pms_task
	modify column tano int not null auto_increment;
	
	
create table pms_team_member(
	tnm varchar(100) not null,
	mid varchar(20) not null
);

alter table pms_team_member
	add constraint pms_team_member_pk primary key (tnm,mid);
    
    
    
    
    
    
    
    
    
    