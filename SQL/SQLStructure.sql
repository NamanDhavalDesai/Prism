create table players
(
	hash_ int(6) primary key,
	rating int(4),
	position varchar(5),
	name varchar(50),
	club varchar(50),
	league varchar(50),
	country varchar(50),
	skillboost varchar(50)
);
create table statplayers
(
	hash_ int(6) primary key,
	foreign key (hash_) references players(hash_),
 	pace int(5),
	shooting int(5),
	passing int(5),
	dribbling int(5),
	defending int(5),
	physical int(5)
);
create table exstatplayers 
(
	hash_ int(6) primary key,
	foreign key (hash_) references statplayers(hash_),
	acceleration int(5),
	sprint_speed int(5),
	positioning int(5),
	finishing int(5),
	shot_power int(5),
	long_shot int(5),
	volleys int(5),
	penalties int(5),
	vision int(5),
	crossing int(5),
	free_kick int(5),
	short_passing int(5),
	long_passing int(5),
	curve int(5),
	agility int(5),
	balance int(5),
	reactions int(5),
	ball_control int(5),
	dribbling int(5),
	interceptions int(5),
	heading int(5),
	marking int(5),
	stand_tackle int(5),
	slide_tackle int(5),
	jumping int(5),
	strength int(5),
	aggression int(5)
);	
create table statkeepers
(
	hash_ int(6) primary key,
	foreign key (hash_) references players(hash_),
	diving int(5),
	positioning int(5),
	handling int(5),
	reflexes int(5),
	kicking int(5),
	physical int(5)
);
create table exstatkeepers
(
	hash_ int(6) primary key,
	foreign key (hash_) references statkeepers(hash_),
	diving int(5),
	positioning int(5),
	handling int(5),
	reflexes int(5),
	jumping int(5),
	kicking int(5),
	long_passing int(5),
	reactions int(5),
	agility int(5),
	sprint_speed int(5),
	strength int(5)
);
create table users
(
	user_id varchar(50) primary key,
	name varchar(50),
	email_id varchar(50),
	password_ varchar(50)
);
insert into users values ('NRX07','Naman Dhaval Desai','naman2701@gmail.com','Nrx07CR7.');
insert into users values ('AY489','Aryan Gulabchand Yadav','ayaryan489@gmail.com','489');
insert into users values ('PSG1012','Pratham Sunil Gupta','prathamgupta1012@gmail.com','1012');
create table history
(
	user_id varchar(50),
	foreign key (user_id) references users(user_id),
	hash_ int(6),
	foreign key (hash_) references players(hash_)
);