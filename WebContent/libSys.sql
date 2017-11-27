create database `library_mangement_system`;
use  `library_mangement_system`;

DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
	`reader_id` VARCHAR(20) PRIMARY KEY,
	`password` VARCHAR(50) NOT NULL,
	`reader_type` VARCHAR(10) NOT NULL,  
	`reader_name` VARCHAR(50) NOT NULL,
	`register_date` DATE,
	`gender` VARCHAR(10), 
	`phone` VARCHAR(20),
	`email` VARCHAR(30)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert `reader` values(
	'15090128', '123456', '1', '杨家浩', '2017-10-24',
	 '男', '13806188295', '374084857@qq.com' 
);
insert `reader` values(
	'15090130', '123456', '2', '姚集霸', '2017-11-02',
	 '男', '13806188296', '474084857@qq.com' 
);
insert `reader` values(
	'15090146', '123456', '3', '钱诗慧', '2017-10-13',
	 '女', '13806188297', '574084857@qq.com' 
);


DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
	`book_id` INT PRIMARY KEY,
	`book_name` VARCHAR(50) NOT NULL,
	`book_kind` VARCHAR(10) NOT NULL,
	`author` VARCHAR(50) NOT NULL,
	`translator` VARCHAR(50),
	`isbn` VARCHAR(50),
	`price` FLOAT,
	`press` VARCHAR(50),
	`position` VARCHAR(50),
	`is_borrowed` Boolean NOT NUll
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert `book` values(
	1, 'c程序设计语言', '计算机', 'K&R', '小明', '000-000-000-000-0',
	 '100', '机械工业出版社', '1号阅览室H-3', 0
);
insert `book` values(
	2, 'c++prime', '计算机', '小红', '小明', '000-000-000-000-1',
	 '100', '机械工业出版社', '1号阅览室H-4', 0
);
insert `book` values(
	3, '算法导论', '计算机', '小黑', '小明', '000-000-000-000-2',
	 '100', '机械工业出版社', '1号阅览室H-3', 0
);
insert `book` values(
	4, '数据结构', '计算机', '小绿', '小明', '000-000-000-000-3',
	 '100', '清华大学出版社', '1号阅览室H-5', 0
);
insert `book` values(
	5, 'java编程思想', '计算机', '小钱', '小明', '000-000-000-000-4',
	 '120', '机械工业出版社', '1号阅览室H-3', 0
);


DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
	`admin_id` INT PRIMARY KEY,
	`password` VARCHAR(50) NOT NULL,
	`admin_name` VARCHAR(50) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert `admin` values(
	123456, '123456', 'admin'
);


DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
	`book_id` INT PRIMARY KEY,
	`reader_id` VARCHAR(20),
	`borrow_time` DATE NOT NULL,
	`back_time` DATE NOT NULL,
	`is_backed` Boolean NOT Null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert `borrow` values(
	1, '15090128', '2017-11-02', '2017-12-02', 0
);
insert `borrow` values(
	2, '15090128', '2017-10-30', '2017-11-30', 1
);
insert `borrow` values(
	3, '15090128', '2017-10-30', '2017-11-27', 1
);
insert `borrow` values(
	4, '15090128', '2017-10-30', '2017-11-26', 0
);
insert `borrow` values(
	5, '15090128', '2017-10-30', '2017-11-02', 0
);


DROP TABLE IF EXISTS `borrow_history`;
CREATE TABLE `borrow_history` (
	`book_id` INT NOT NULL,
	`book_name` VARCHAR(50) NOT NULL,
	`reader_id` VARCHAR(20) NOT NULL,
	`reader_name` VARCHAR(50) NOT NULL,
	`borrow_time` DATE NOT NULL,
	`back_time` DATE,
	`fine` FLOAT
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP VIEW IF EXISTS `reader_view`;
CREATE VIEW `reader_view`(`reader_id`, `reader_name`, `reader_type`, `borrow_cnt`) AS 
SELECT reader.reader_id, reader.reader_name, `reader_type`, COUNT(borrow_history.book_id)
FROM `reader`, `borrow_history` WHERE reader.reader_id=borrow_history.reader_id;


