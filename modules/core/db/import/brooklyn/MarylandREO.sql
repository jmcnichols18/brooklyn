-- Create new columns
alter table MarylandREO add column ID varchar(32) ;
update MarylandREO set ID = newid() where ID is null ;
alter table MarylandREO modify column ID varchar(32) not null ;
alter table MarylandREO add constraint PK_MarylandREO primary key (ID) ;
