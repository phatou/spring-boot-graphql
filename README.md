# Spring Boot GraphQL

## Reference

https://www.javadevjournal.com/spring-boot/spring-boot-graphql/

## Usage

#### Start the application

you can run the application using ./mvnw spring-boot:run. Or you can build the JAR file with ./mvnw clean package. Then you can run the JAR file:

java -jar target/spring-boot-graphql-0.1.0.jar

Now that the service is running, point your browser at http://localhost:8080/graphiql

#### Query

Get id, login, name from all users

```graphql
query {
  users {
    id
    login
    name
  }
}
```

Add new user and get id as result

```graphql
mutation {
  createUser (
    login: "phatou"
    name: "Phatou"
  ) {
   id 
  }
}
```

Get id, name from users from range 2 to 4

```graphql
query {
  users(first: 2, last: 4) {
    id
    name
  }
}
```