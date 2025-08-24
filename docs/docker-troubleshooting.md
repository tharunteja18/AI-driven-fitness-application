This section documents the issues I faced while containerizing the application and how I solved them.

Initially, both my user-service application and the MySQL server were running directly on my local machine.
so, the user-service could easily connect to MySQL server because both are on the same host i.e local.
However, once I containerized the user-service, I faced a problem
The user-service application inside the container could not directly communicate with the MySQL server running on the host machine.

To fix this temporarily, I modified the application.yml file and used:
url: jdbc:mysql://host.docker.internal:3306/fitness_user_db
(note: MySQL server is listening on port 3306 & fitness_user_db is the database)

This worked, but it is not the recommended approach.
The recommended approach is to containerize the MySQL server as well, so that both services run inside containers and can communicate via a docker network.

Okay... Got it!

When pulling the official MySQL image from Docker Hub, the container starts with an empty database.
But in my case, I already had existing data in my local MySQL database that I wanted to preserve.

To solve this, I exported (dumped) the database from my local MySQL into an SQL file.
### mysqldump -u root -p fitness_app > D:/backup/fitness_app.sql
then, i mounted the SQL dump into the MySQL container, so that the container would initialize with my existing data.

### Steps Performed
## Created a Docker network using -> docker network create <give-the-network-name>
    note: To check the whether network is created or not you can use the command -> docker network ls.
          It will give the list of networks created

## Run MySQL container with mounted SQL dump
    docker run --name mysql-container /
      -e MYSQL_ROOT_PASSWORD=<provide-the-password> /
      -e MYSQL_DATABASE=fitness_app /
      -v "D:/backup/fitness_app.sql:/docker-entrypoint-initdb.d/fitness_app.sql" /
      --network fitness-net /
      -p 3306:3306 /
      -d mysql:8

## Run User Service container
    docker run --name user-service-container ^
      --network fitness-net ^
      -p 8082:8080 ^
      user-service-image



