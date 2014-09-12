--// First migration.
-- Migration SQL that makes the change goes here.
create table POST (
    ID int not null,
    NAME varchar(100) not null
);

INSERT INTO POST VALUES (1,'ifaber' );
INSERT INTO POST VALUES (2,'ta' );
INSERT INTO POST VALUES (3,'tw' );


--//@UNDO
-- SQL to undo the change goes here.

Delete from POST;
DROP table POST;


