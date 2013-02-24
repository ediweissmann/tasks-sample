# Tasks schema

# --- !Ups

create sequence s_tasks_id;

create table tasks (
  id    bigint DEFAULT nextval('s_tasks_id'),
  title  varchar(128)
);

insert into tasks(title) values('Remember the milk');
insert into tasks(title) values('Don''t forget the keys');


# --- !Downs

drop table tasks;
drop sequence s_tasks_id;