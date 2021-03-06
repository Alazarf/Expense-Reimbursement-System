CREATE table employees (
	id int auto_increment PRIMARY KEY NOT NULL,
	first_name VARCHAR (50),
	last_name VARCHAR (50),
	email VARCHAR (50),
	emp_username VARCHAR (50) NOT NULL,
	emp_password VARCHAR (50) NOT NULL,
	emp_type VARCHAR (50)
);

insert into employees values (default,'John', 'Smith', 'johnsmith@mail.com', 'smithj', 'smith123', null );
insert into employees values (default, 'Big', 'Smith', 'bigmith@mail.com', 'bigj', 'big456', 'manager' );

CREATE Table reimbursements (
	id int auto_increment PRIMARY KEY NOT NULL,
	employee_id int NOT NULL,
	title VARCHAR (50),
	amountrequested numeric(20,2),
	status VARCHAR (50),
	constraint fk_employee
		foreign key (employee_id) 	
			references employees(id)
);