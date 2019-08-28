
create table role(
                     id bigint(20) primary key,
                     roleName varchar(255) not null
)ENGINE=innoDB auto_increment=12 default charset=utf8;


insert into role(roleName) values('ADMIN');
insert into role(roleName) values('APPLICANT');
insert into role(roleName) values('EMPLOYER');
