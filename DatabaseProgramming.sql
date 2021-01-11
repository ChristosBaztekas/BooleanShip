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
					id int not null foreign key Organisations(id),
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

CREATE TABLE Universities(
						id int not null foreign key Organisations(id),
						status bit not null,
						number_others_positive int not null,
						number_teachers_positive int not null
						)

CREATE TABLE Universities_department(
									id_Universities int not null foreign key Universities(id),
									id_Classes int not null foreign key Classes(id),
									number_department_positive int not null,
									lockdown_department bit not null
									)
CREATE TABLE Universities_secretariat(
									id_Universities int not null foreign key Universities(id),
									id_Classes int not null foreign key Classes(id),
									number_secreterariat_positive int not null,
									lockdown_secretariat bit not null
									)
CREATE TABLE Universities_others(
							id_Universities int not null foreign key references Universities(id),
							id_Human varchar(9) not null foreign key references Human(Afm),
							number_others_positive int not null
							)
CREATE TABLE Universities_teachers(
							id_Schools int not null foreign key references Schools(id),
							id_Human varchar(9) not null foreign key references Human(Afm),
							number_teachers_positive int not null
							)							
CREATE TABLE Labors(
				id_Labors int not null foreign key Organisations(id),
				status not null bit,
				lockdown not null bit,
				)
CREATE TABLE Labors_department(
									id_Universities int not null foreign key Labors(id),
									id_Classes int not null foreign key Classes(id),
									number_department_positive int not null,
									lockdown_department bit not null
									)
CREATE TABLE Public_Services(
							id_Public_Services int not null foreign key Labors(id),
							lockdown not null bit
							)
CREATE TABLE Companies(
					id_Companies int not null foreign key Labors(id),
					lockdown not null bit
					)

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
	select @everythink_ok = 0--does it return?
else
	select @everythink_ok = -1 --does it return?
	
	


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
SELECT 
FROM  as 
WHERE id = @id_org


--take email Organisations
SELECT O.email
FROM Organisations AS O

--printDetails method
SELECT O.name, O.area
FROM Organisations AS O
WHERE O.id = ?

--NursingHomes methods
--seeStatus method
SELECT NH.status, NH.count_employees, NH.count_carenPeople
FROM NursingHomes AS NH
WHERE NH.id = ?

SELECT H.name, H.surname, H.Afm /* LIKE toString() Human*/
FROM NursingHomes_employees AS E, Human AS H
WHERE E.id_Human = H.id
SELECT H.name, H.surname, H.Afm /* LIKE toString() Human*/
FROM NursingHomes_carenPeople AS C, Human AS H
WHERE C.id_Human = H.id

