create role tsteffan login password 'lockandkey' noinherit createdb;

--Creates Account Table
create table Accounts(
accountID serial primary key,
Balance int not null,
CustomerID int not null
);

--Creates Customer Table
create table Customer(
CustomerID serial primary key,
username varchar(50) not null,
password varchar(50) not null,
FirstName varchar(50) not null,
LastName varchar(50) not null
);

--Links Customers and Accounts with a foreign key, CustomerID
alter table accounts
add constraint fk_customer_account
foreign key (CustomerID) references customer(customerid)
on delete cascade;

--Unique username constraint
alter table customer
add constraint uc_username unique (username);

--Little modifier commands to tweak things
alter table accounts
alter column Balance
set default 0.0;

--Functions
create or replace function delete_from_accounts(in int)
returns boolean as $$ 
begin
	delete from accounts where accountid = $1;
	return true;
end
$$ language plpgsql

create or replace function delete_from_users(in varchar)
returns boolean as $$ 
begin
	delete from customer where username = $1;
	return true;
end
$$ language plpgsql