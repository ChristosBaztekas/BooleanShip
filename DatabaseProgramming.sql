CREATE TABLE Human(
				name varchar(80),
				surname varchar(80),
				Afm varchar(9) Not null,
				email varchar(100),
				gender varchar(30),
				id int not null ,
				constraint Human_pr Primary Key (Afm)
				)
CREATE TABLE Human_belongs(
						id_Human varchar(9) not null foreign key references Human(Afm),
						id_Organisations int not null foreign key references Organisations(id)
						)
CREATE TABLE Human_waitTest(
						id_Human int not null foreign key references Human(id),
						date_insert date/*idea*/
						)
CREATE TABLE Classes(
					idifier varchar(80) not null,
					id_Organisations int not null,/*see what to be made for inherabation*/
					id int not null,
					Primary Key(id)
					)
CREATE TABLE Classes_members(
							id_Classes int not null foreign key references Classes(id),
							id_Human varchar(9) not null foreign key references Human(Afm)
							)
/*Aytoincreased!!!!!!!!*/
/*be carefull of ISA need*/
CREATE TABLE Organisations(
						name varchar(80),
						area varchar(60),
						email varchar(80),
						id int not null,
						constraint Organisations_pr Primary Key (id)
						)
CREATE TABLE NursingHomes(
						status_descr varchar(80),
						id int not null,
						count_employees int not null,
						count_carenPeople int not null,
						en_status bit, /* 0 closed 1 opened*/
						status bit,/* 0 covid free 1 ifcovid*/

						Primary Key (id)
						)
CREATE TABLE NursingHomes_employees(
								id_NursingHomes int not null foreign key references NursingHomes(id),
								id_Human varchar(9) not null foreign key references Human(Afm)
								)
CREATE TABLE NursingHomes_carenPeople(
								id_NursingHomes int not null foreign key references NursingHomes(id),
								id_Human varchar(9) not null foreign key references Human(Afm)
								)
CREATE TABLE NursingHomes_changes(
								id_NursingHomes int not null foreign key references NursingHomes(id),
								id_Human varchar(9) not null foreign key references Human(Afm)
								)
CREATE TABLE Schools(
					id int not null,
					number_of_students_positive int not null,
					number_of_teachers_positive int not null,
					number_of_others_positive int not null,
					lockdown bit not null,/*0 means no, 1 yes*/
					status bit not null
					Primary Key(id)
					)
CREATE TABLE Schools_teachers(
							id_Schools int not null foreign key references Schools(id),
							id_Human varchar(9) not null foreign key references Human(Afm)
							)
CREATE TABLE Schools_others(
							id_Schools int not null foreign key references Schools(id),
							id_Human varchar(9) not null foreign key references Human(Afm)
							)
CREATE TABLE Schools_departments(
								id_Schools int not null foreign key references Schools(id),
								id_Classse int not null foreign key references Classes(id),
								id int not null,/*maybe*/
								lockdown bit
								)
CREATE TABLE Schools_changes(
								id_Schools int not null foreign key references Schools(id),
								id_Human varchar(9) not null foreign key references Human(Afm)
								)
/*CREATE TABLE Schools_lockdown_department(
										id_Schools int not null foreign key references Schools(id),
										id_Schools_Department int not null foreign key references Schools_departments(id),
										lockdown bit
										Primary Key(id_Schools, id_Schools_Department)
										)*/
CREATE TABLE Registation_Org(
						password_org varchar(80) not null,
						username_org varchar(80) not null primary key,
						id_org int not null,--foreign key--
						)
--register
-- need to be checked if username already exists
DECLARE @everythink_ok int
DECLARE @flag int
SELECT @flag = id_org
FROM Registation_Org
WHERE username_org = ?
if @flag is null
	insert Organisations values(?,?,?)
	--take id and make it foreign key
	--in this way find id
	--which org, make inserts too
	/*fe NH*/insert NursingHomes values(/*id_org*/,?,?,?)
	@everythink_ok = 0
else
	@everythink_ok = -1




--sign in
DECLARE @id_org int
SELECT @id_org = id_org --(1)
FROM Registation_Org
WHERE password_org = ? AND username_org  = ?
--give data back
SELECT name, area, email
FROM Organisations
WHERE id = @id_org
SELECT NH.count_carenPeople
FROM NursingHomes as NH
WHERE id = @id_org
SELECT S.status
FROM Schools as S
WHERE id = @id_org




