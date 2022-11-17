# Point to Point
A simple app to support a push clock app


## Technologies

This program was build with:
- Java Language Programming
- Spring Boot Java Framework
- Lombok
- MySQL
- Docker
- Eclipse IDE
- Git && Github
- Clean Architecture
***


## Get started

	1. Download the repository from Github
	2. Certify you have already installed Java LTS, Lombok and MySQL in your machine
		2.1. You can use docker to set up database

```bash
docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=point_to_point -e MYSQL_USER=alcides -e MYSQL_PASSWORD=123456 mysql
```

	4. Run the application

```bash
./mvnw install
./mvnw spring-boot:run
```
	
	5. Enjoy!