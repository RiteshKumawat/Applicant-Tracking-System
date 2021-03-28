create table candidate(
id int not null primary key auto_increment,
name varchar(20),
email_id varchar(20) unique,
phone_number varchar(20),
password varchar(20),
dob date,
address varchar(20),
education varchar(20),
experience int);



create table manager(
id int not null primary key auto_increment,
name varchar(20),
email_id varchar(20) unique,
phone_number varchar(20),
password varchar(20),
department varchar(20),
team_size int);


create table skill(
id int not null primary key auto_increment,
name varchar(20)
);


create table candidate_skill(
id int not null primary key auto_increment,
candidate_id int,
skill_id int,
foreign key (candidate_id) references candidate(id),
foreign key (skill_id) references skill(id)
);



create table candidate_manager(
id int not null primary key auto_increment,
candidate_id int,
manager_id int,
foreign key (candidate_id) references candidate(id),
foreign key (manager_id) references manager(id)
);