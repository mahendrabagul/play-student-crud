# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table student (
  id                        bigint not null,
  name                      varchar(255),
  address                   varchar(255),
  gender                    varchar(255),
  birth_date                varchar(255),
  department                varchar(255),
  last_update               timestamp not null,
  constraint pk_student primary key (id))
;

create sequence student_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists student;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists student_seq;

