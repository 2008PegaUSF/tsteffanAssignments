--Section 1.1
select "EmployeeId", "LastName", "Email" 
from "Employee" 
where "LastName" = 'King';

select "City", "State" 
from "Employee" 
where "FirstName" = 'Andrew' and "ReportsTo" is null;

--Section 1.2
select *
from "Album"
where "ArtistId" = '1';

--Section 1.3
select *
from "Album"
order by "Title" desc;

select "FirstName"
from "Customer"
order by "City" 

--Section 1.6
select *
from "Invoice"
where "BillingAddress" like 'T%';

--Section 1.7
select *
from "Invoice"
where "Total" between '15' and '50';

select *
from "Employee"
where "HireDate" between '2003-6-1' and '2004-3-1';

--Section 2.1
insert into "Genre" 
values (26, 'Salsa'), (27, 'EDM');

insert into "Employee"
values (9, 'Steffan', 'Taylor', 'Software Engineer', 6, '1989-10-7', '2015-09-02', '1235 Circly Circle', 'Lakeland', 'FL', 'USA', '33811', '+1 (813) 123-4567', '+1 (813) 987-6543', 'taylor.steffan@revature.net'),
       (10, 'Doe', 'John', 'Destroyer of Worlds', 6, '1000-1-1', '2019-12-19', '1233 Purgatory Ln', 'Detroit', 'MI', 'USA', '12345', '+1 (888) 555-3049', '+1 (888) 556-3029', 'mrdestroyer@yahoo.com');

insert into "Customer"
values (60, 'Stan', 'Lee', null, '123 Comic Ln', 'LA', 'California', 'USA', '12345', '+1 (234) 567-8901', null, 'excelsior@aol.com', 3),
       (61, 'Todd', 'Howard', null, '657 Bethesda Ct', 'LA', 'California', 'USA', '67890', '+1 (838) 423-6982', null, 'escrollsruiner@hotmail.com', 4);
       
--Section 2.2
update "Customer" set "FirstName" = 'Robert' where "FirstName" = 'Aaron';
update "Customer" set "LastName" = 'Walter' where "LastName" = 'Mitchell';

update "Artist" set "Name" = 'CCR' where "Name" = 'Creedence Clearwater Revival';

--Section 2.3
alter table "Customer" drop constraint "FK_CustomerSupportRepId";
alter table "Invoice" drop constraint "FK_InvoiceCustomerId";
delete from "Customer" where "FirstName" = 'Robert' and "LastName" = 'Walter';
alter table "Customer" add constraint "FK_CustomerSupportRepId" FOREIGN KEY ("SupportRepId") REFERENCES "Employee"("EmployeeId");
insert into "Customer" values (32, 'Bill', 'Paxton', null, '1337 Alien Ln', 'LV-426', 'Aliens', 'USA', '55555', '+1 (555) 234-2349', 'null', 'gameoverman@ymail.com');
alter table "Invoice" add constraint "FK_InvoiceCustomerId" FOREIGN KEY ("CustomerId") REFERENCES "Customer"("CustomerId");

--Section 3.1
select CURRENT_TIME;

select "Name", length("Name")
as "Length of Name"
from "MediaType";

--Section 3.2
select avg("Total") from "Invoice";

select max("UnitPrice") from "Track";

--Section 3.3
select avg("UnitPrice") from "InvoiceLine";

select * from "Employee"
where "BirthDate" > '1968-12-31';

--Section 4.1
create or replace function numberSet()
returns trigger as $$
begin 
	if(TG_OP = 'Insert') then 
	update "Employee" 
	set "Phone" = '867-5309' where new."EmployeeId" = "Employee"."EmployeeId";
	end if;
	return new;
end
$$ language plpgsql

create trigger phone_insert_after
after insert on "Employee"
for each row 
execute function numberSet();

--Section 4.2
create or replace function setRevature()
returns trigger as $$
begin 
	if (TG_OP = 'Insert') then 
	new."Company" = 'Revature';
	end if;
	return new;	
end
$$ language plpgsql

create trigger revInsert
before insert on "Customer"
for each row 
execute function setRevature();

--Section 5.1
select "FirstName", "LastName", "InvoiceId"
from "Customer"
inner join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";

--Section 5.2
select "Customer"."CustomerId", "FirstName", "LastName", "InvoiceId", "Total"
from "Customer"
full outer join "Invoice" on "Customer"."CustomerId" = "Invoice"."CustomerId";

--Section 5.3
select "Name", "Title"
from "Artist" 
right join "Album" on "Artist"."ArtistId" = "Album"."ArtistId";

--Section 5.4
select "Title", "Name"
from "Artist"
cross join "Album" 
order by "Name";

--Section 5.5
select e."FirstName", e."LastName", r."FirstName", r."LastName"
from "Employee" e
inner join "Employee" r 
on e."ReportsTo" = r."EmployeeId";

--Section 6.1
select "FirstName", "LastName", "Phone"
from "Employee"
union
select "FirstName", "LastName", "Phone" 
from "Customer";

--Section 6.2
select "City", "State", "PostalCode"
from "Customer"
except all
select "City", "State", "PostalCode" 
from "Employee";
