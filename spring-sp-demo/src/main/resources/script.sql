CREATE DATABASE `spdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `employees` (
  `employeeID` int(11) NOT NULL,
  `firstName` varchar(50) NOT NULL,
  `lastName` varchar(50) NOT NULL,
  `address` varchar(100) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into employees (employeeID,  firstName,  lastName,   address) values (001,"Diane","Murphy","19,Quaker Ridge Rd,06801");
insert into employees (employeeID,  firstName,  lastName,   address) values (002,"Jeff","Firrelli","1000,Coney Island Ave,11230");
insert into employees (employeeID,  firstName,  lastName,   address) values (003,"Gerard","Bondur","2962,Dunedin CvGermantown,38138");
insert into employees (employeeID,  firstName,  lastName,   address) values (004,"Vanauf","George","1500,Vance Ave Memphis,38104");
insert into employees (employeeID,  firstName,  lastName,   address) values (005,"King","Tom","1577,Lobby Ave,38804");

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_addition`(
IN firstNumber INT,
IN secondNumber INT,
OUT total INT
)
BEGIN
select sum(firstNumber+secondNumber) as total;
END

CREATE DEFINER=`root`@`localhost` PROCEDURE `get_all_employees`()
BEGIN
select * from employees;
END

