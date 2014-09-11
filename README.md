flyway_poc
==========

Prerequisites:

Postgres 9 or above.

Task	Description	Parameters
migrateInit	- Create migrations repository structure
migrateBootstrap	- Use an existing database structure as an starting point for migrations
migrateStatus	- Shows current database status
migrateNew	- Create a new migration file.	description, template
migrateUp	- Apply any pending migration following creation order.	steps
migrateDown	 - Rewinds the database to a previous stage.	steps

Passing environments:

example:
gradle migrateUp -Penv=prod


Creating new migrations:
gradle migrateNew -Pdescription="Create table comments"


Ref:https://github.com/marceloemanoel/gradle-migrations-plugin
Ref:http://mybatis.github.io/migrations/





