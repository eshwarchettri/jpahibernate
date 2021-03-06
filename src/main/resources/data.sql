insert into course(id, name, last_update_date_time, create_date_time)
values (1001L, 'Hibernate Test 1', sysdate(), sysdate());
insert into course(id, name, last_update_date_time, create_date_time)
values (1002L, 'Spring Boot Test 1', sysdate(), sysdate());
insert into course(id, name, last_update_date_time, create_date_time)
values (1003L, 'Java Test 1', sysdate(), sysdate());



insert into passport(id, number)
values (3001L, 'E123456');
insert into passport(id, number)
values (3002L, 'N123456');
insert into passport(id, number)
values (3003L, 'L123456');

insert into student(id, name, passport_id)
values (2001L, 'Ranga', 3001);
insert into student(id, name, passport_id)
values (2002L, 'Sham', 3002);
insert into student(id, name, passport_id)
values (2003L, 'Jane', 3003);

insert into review(id, rating, description, course_id)
values (4001L, '3', 'Good videos', 1001);
insert into review(id, rating, description, course_id)
values (4002L, '4', 'Awesome', 1001);
insert into review(id, rating, description, course_id)
values (4003L, '5', 'Wonderful', 1003);

insert into student_course(student_id, course_id) values(2001,1001);
insert into student_course(student_id, course_id) values(2002,1001);
insert into student_course(student_id, course_id) values(2001,1002);
insert into student_course(student_id, course_id) values(2001,1002);