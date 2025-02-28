# HOW TO DEPLOY

## Local deployment

### Prerequisit
You must install docker and clone the project repository

### Step by step

- Start docker using this command
```shell
sudo systemctl start docker
```

- Create the db
```shell
mkdir <path-to-repo>/bike-reservation-system
./runPostgresqlDockerForDev.sh
```

- Start the application
```shell
./gradlew bootRun
```

### Access the application
The OpenAPI Documentation is available at http://localhost:8080/swagger-ui/index.html

The application is available at http://localhost:8080/

