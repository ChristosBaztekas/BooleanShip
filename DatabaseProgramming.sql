--better for java the status to be int 0-1 so to can return all together
CREATE TABLE Human(
				name varchar(80),
				surname varchar(80),
				Afm varchar(9) Not null,
				email varchar(100),
				gender varchar(30),
				id int not null IDENTITY(0,1),
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
						username varchar(80),
						password varchar(80),
						id int not null IDENTITY(0,1),
						constraint Organisations_pr Primary Key (id)
						)
CREATE TABLE NursingHomes(
                        id int not null foreign key references Organisations(id),
                        status_descr varchar(80),
                        count_employees int not null,
                        count_carenPeople int not null,
                        en_status int not null, /* 0 closed 1 opened*/
                        status int not null,/* 0 covid free 1 ifcovid*/
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
					id int not null foreign key references Organisations(id),
					number_of_students_positive int not null,
					number_of_teachers_positive int not null,
					number_of_others_positive int not null,
					lockdown int not null,/*0 means no, 1 yes*/
					status int not null
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
								lockdown int not null
								)
CREATE TABLE Schools_changes(
								id_Schools int not null foreign key references Schools(id),
								id_Human varchar(9) not null foreign key references Human(Afm)
								)
/*CREATE TABLE Schools_lockdown_department(
										id_Schools int not null foreign key references Schools(id),
										id_Schools_Department int not null foreign key references Schools_departments(id),
										lockdown int not null
										Primary Key(id_Schools, id_Schools_Department)
										)*/

CREATE TABLE Universities(
						id int not null foreign key references Organisations(id),
						status int not null ,
						number_others_positive int not null,
						number_teachers_positive int not null
						)

CREATE TABLE Universities_department(
									id_Universities int not null foreign key references Universities(id),
									id_Classes int not null foreign key references Classes(id),
									number_department_positive int not null,
									lockdown_department int not null
									)
CREATE TABLE Universities_secretariat(
									id_Universities int not null foreign key references Universities(id),
									id_Classes int not null foreign key references Classes(id),
									number_secreterariat_positive int not null,
									lockdown_secretariat int not null
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
				id int not null foreign key references Organisations(id),
				status int not null,
				lockdown int not null
				)
CREATE TABLE Labors_department(
									id_Universities int not null foreign key references Labors(id),
									id_Classes int not null foreign key references Classes(id),
									number_department_positive int not null,
									lockdown_department int not null
									)
CREATE TABLE Public_Services(
							id_Public_Services int not null foreign key references Labors(id),
							lockdown int not null
							)
CREATE TABLE Companies(
					id int not null foreign key references Labors(id),
					lockdown int not null
					)



--register
-- need to be checked if username already exists
DECLARE @everythink_ok int
DECLARE @flag int
if (SELECT @flag = id
    FROM Organisations
    WHERE username = ?) is null
    begin
    insert Organisations values(?,?,?)
    insert NursingHomes values(?,?,?)
    select @everythink_ok = 0
    end
else
    begin
    select @everythink_ok = -1 --does it return?
    end
    --does it return?
--sign in
DECLARE @id_org int
SELECT @id_org = id --(1)
FROM Organisations
WHERE password = ? AND username = ?
--give data back
SELECT name, area, email
FROM Organisations
WHERE id = @id_org

SELECT N.count_carenPeople
FROM NursingHomes as N
WHERE id = @id_org
SELECT S.status
FROM Schools as S
WHERE id = @id_org
SELECT U.status
FROM Universities as U
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
WHERE E.id_Human = H.id AND E.id_NursingHomes = ?
SELECT H.name, H.surname, H.Afm /* LIKE toString() Human*/
FROM NursingHomes_carenPeople AS C, Human AS H
WHERE C.id_Human = H.id

