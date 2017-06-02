create table acclogin(un varchar(20) primary key, pw varchar(20) not null);

insert into acclogin values('alpha','beta');

create table branches(branch_code char(3) primary key, branch_name varchar(50) not null);

insert into branches values('ME','Mechanical Engineering');

insert into branches values('CSE','Computer Science & Engineering');

insert into branches values('ECE','Electronics and Communication Engineering');

insert into branches values('IT','Information Technology');

create table cat_fee(fee_category char(3) primary key, payment_for_cat int not null);

insert into cat_fee values('GEN',200000);

insert into cat_fee values('TFW',32000);

create table category(cat char(3) primary key, cat_name varchar(20) not null);

insert into category values('GEN','General');

insert into category values('ST','Scheduled Tribes');

insert into category values('SC','Scheduled Caste');

insert into category values('OBC','Other Backward Caste');

create table ucet_students(roll int(7) primary key,name varchar(30) not null, session_start int(4) not null,session_end int(4) not null,branch char(3) not null,categ_fee char(3)not null, f_name varchar(30),m_name varchar(30),cat char(3)not null, mob bigint(20) not null,address varchar(50) not null,email varchar(50) not null, FOREIGN KEY (branch) REFERENCES branches(branch_code),FOREIGN KEY (categ_fee) REFERENCES cat_fee(fee_category),FOREIGN KEY (cat) REFERENCES category(cat));

create table payments(challan_no int primary key,amount int not null, challan_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, roll_no int not null,FOREIGN KEY(roll_no) REFERENCES ucet_students(roll));

