# db-migration-flyway-groovy

Minimum configuration to run db migration with flyway and groovy

No Maven. No Gradle. No Plugins.

## Prerequisite

```bash
# Install by sdkman: https://sdkman.io/
sdk install groovy

# Install by brew: https://brew.sh/
brew install --cask docker  # Docker Desktop
brew install libpq          # psql command line tool for testing
brew install pnpm           # (Optional) For running scripts in package.json
```

## Setup Postgres by docker compose

```bash
pnpm up      # run docker compose up
pnpm stop    # run docker compose stop
pnpm down    # run docker compose down
pnpm log     # show logs from docker compose
```

## Scripts

```bash
pnpm start   # run flyway migration
pnpm test    # run tests with simple query
pnpm drop    # drop the schema
```

## Step by step

1. Run postgres at port 6000 by docker

   ```bash
   pnpm up
   # docker compose -f docker-compose.yml -p flyway-migration up -d

   # check the logs from docker compose
   pnpm log
   # docker compose -f docker-compose.yml -p flyway-migration logs --follow
   ```

2. Run db migration with flyway

   ```bash
   pnpm start
   # ./migrate.groovy
   ```

3. Run test to query the db

   ```bash
   pnpm test
   # psql -h localhost -p 6000 -U postgres -c 'select * from flyway_demo.book'
   ```

4. Drop the postgres schema

   ```bash
   pnpm drop
   # psql -h localhost -p 6000 -U postgres -c 'drop schema if exists flyway_demo cascade'
   ```

5. Remove postgres docker container

   ```bash
   pnpm down
   # docker compose -f docker-compose.yml -p flyway-migration down
   ```
