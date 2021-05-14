drop TABLE scoreboard;

create table scoreboard(pid number,pname varchar2(30),pscore number);

insert into scoreboard(pid,pname,pscore) values(101,'Joey',10);
insert into scoreboard(pid,pname,pscore) values(102,'Phoebe',30);
insert into scoreboard(pid,pname,pscore) values(103,'Monica',50);
insert into scoreboard(pid,pname,pscore) values(108,'Chandler',70);
insert into scoreboard(pid,pname,pscore) values(109,'Ross',60);
insert into scoreboard(pid,pname,pscore) values(110,'Rachel',50);


select * from scoreboard;

select * from scoreboard where pid='101';