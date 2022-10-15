### Dockerizing an Back End application (using Java)

1. Use a local Docker or a online service like:
```
https://labs.play-with-docker.com/
```

2. Create a new project or downloading a existing project:
```
git clone https://github.com/williansmartins/dockerizing-back-end-application.git
```

3. Set a Docker file
```
FROM openjdk:8-jdk-alpine

RUN apk update && apk upgrade && apk add bash
RUN mkdir -p /usr/local/dockerize

ADD  @project.build.finalName@.jar /usr/local/dockerize/

ADD run.sh run.sh

RUN chmod +x run.sh

CMD ./run.sh
```

4. Add maven plugin to generate image
```
<plugin>
    <artifactId>maven-resources-plugin</artifactId>
    <executions>
        <execution>
            <id>copy-resources</id>
            <phase>validate</phase>
            <goals>
                <goal>copy-resources</goal>
            </goals>
            <configuration>
                <outputDirectory>${basedir}/target/dockerfile</outputDirectory>
                <resources>
                    <resource>
                        <directory>src/main/docker</directory>
                        <filtering>true</filtering>
                    </resource>
                </resources>
            </configuration>
        </execution>
    </executions>
</plugin>
```
and
```
<plugin>
    <groupId>com.spotify</groupId>
    <artifactId>docker-maven-plugin</artifactId>
    <version>0.4.10</version>
    <configuration>
        <imageName>${docker.image.name}:${docker.image.tag}</imageName>
        <dockerDirectory>${basedir}/target/dockerfile</dockerDirectory>
        <resources>
            <resource>
                <targetPath>/</targetPath>
                <directory>${project.build.directory}</directory>
                <include>${project.build.finalName}.jar</include>
            </resource>
        </resources>
    </configuration>
</plugin>
```

5. Build an image
```
mvn clean package docker:build
``` 

6. Run a instance of image
```
docker run -t -p 8000:8080 --name dockerize williansmartins/dockerize-spring
```

6. Test your application (access by a expose port)
```
http://ip172-18-0-86-cd4v7rv91rrg00c84q0g-8000.direct.labs.play-with-docker.com/users
```
