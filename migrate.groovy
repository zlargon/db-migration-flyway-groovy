#!/usr/bin/env groovy
@Grab('org.postgresql:postgresql:42.5.1')
@Grab('org.flywaydb:flyway-core:9.8.1')
import org.flywaydb.core.Flyway

def db_url = "jdbc:postgresql://localhost:6000/postgres?currentSchema=flyway_demo"
def db_username = "postgres"
def db_password = ""

Flyway.configure()
  .dataSource(db_url, db_username, db_password)
  .locations("db_migration")
  .load()
  .migrate()

println("\nFlyway Migration Done")
