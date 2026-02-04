# Database Initialization Scripts

This directory contains SQL scripts to initialize the MySQL 'world' database.

## How to populate this directory:

### Step 1: Export your current 'world' database

Run this command **in your project root directory** (where your docker-compose.yml is located):

```bash
mysqldump -u root -proot world > init-scripts/world-database.sql
```

**Note:** 
- `-proot` means password is "root" (no space between -p and the password)
- Run this in your IDE terminal at the project location
- This will create `init-scripts/world-database.sql` in your project

### Step 2: Verify the dump file

Check that `init-scripts/world-database.sql` was created and contains data.

You can check the file size or open it to see SQL statements.

### How it works:

When the MySQL container starts for the first time, it automatically executes all `.sql` files in `/docker-entrypoint-initdb.d` (mapped to `./init-scripts`) in alphabetical order.

This means your 'world' database will be automatically created and populated with all the sample data when you run `docker-compose up`.

## Important Notes:

- The initialization only happens on **first run** (when the volume is empty)
- If you need to re-initialize, delete the Docker volume: `docker-compose down -v`
- The SQL file should be committed to your repository so the database is always available
- The dump file might be large depending on the sample data size
