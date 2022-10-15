### Generating APP
1. Prepare the environment 
```
Java (I am using "1.8.0_192")
```
```
Maven (I am using apache-maven-3.3.9)
```

2. Create a new project:
```
https://start.spring.io/

```

3. Implement some methods
```
    @GetMapping
    public String getUsers(){
        return "HTTP GET";
    }
```

4. Run locally
```
mvn spring-boot:run
```

5. Run locally
```
http://localhost:8080/users
```
