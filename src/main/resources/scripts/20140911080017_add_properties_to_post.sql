--// Create table comments
-- Migration SQL that makes the change goes here.
ALTER TABLE POST ADD COLUMN properties json;


--//@UNDO
-- SQL to undo the change goes here.
ALTER TABLE POST REMOVE COLUMN properties;


