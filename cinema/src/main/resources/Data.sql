
insert into projection(id,start_time,end_time)
values(1,TO_TIMESTAMP('2018-12-17 13:35:00', 'YYYY-MM-DD HH24:MI:SS'),
TO_TIMESTAMP('2018-12-17 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));
insert into projection(id,start_time,end_time)
values(2,TO_TIMESTAMP('2018-12-15 16:35:00', 'YYYY-MM-DD HH24:MI:SS'),
TO_TIMESTAMP('2018-12-15 15:00:00', 'YYYY-MM-DD HH24:MI:SS'));


insert into User(id,name,login,projection_id) values (1,'Adam','adam@gmail.com',1);
insert into User(id,name,login,projection_id) values (2,'Gabor','gabor@gmail.com',1);





insert into Room(id,number,projection_id)values(1,22,1);
insert into Room(id,number,projection_id)values(2,23,2);

insert into Movie(id,name,projection_id)values(1,'Függetlenség napja',1);
insert into Movie(id,name,projection_id)values(2,'Macskafogo',2);


insert into matrix(id,room_id)values(1,1);

insert into element(id,matrix_id,row,columns,state)
values(1,1,1,1,'ures');
insert into element(id,matrix_id,row,columns,state)
values(2,1,1,2,'ures');
insert into element(id,matrix_id,row,columns,state)
values(3,1,1,3,'ures');
insert into element(id,matrix_id,row,columns,state)
values(4,1,2,1,'foglalt');
insert into element(id,matrix_id,row,columns,state)
values(5,1,2,2,'ures');
insert into element(id,matrix_id,row,columns,state)
values(6,1,2,3,'foglalt');