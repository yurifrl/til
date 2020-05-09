# Ref
- http://www.mkyong.com/maven/how-to-create-a-java-project-with-maven/
- Maven auto run plugin:
    - http://stackoverflow.com/questions/15869784/how-to-run-a-maven-created-jar-file-using-just-the-command-line
    - https://www.tutorialspoint.com/maven/maven_plugins.htm
- https://github.com/aistrate/AlgorithmsSedgewick
- http://stackoverflow.com/questions/4955635/how-to-add-local-jar-files-in-maven-project
- http://stackoverflow.com/questions/4491199/build-maven-project-with-propriatery-libraries-included/4491343#4491343

## To compile and run
mvn package
java -cp target/app-1.0-SNAPSHOT.jar com.app.App
java -cp target/app-1.0-SNAPSHOT.jar com.app.BinarySearch

## Compile and run using tool
mvn clean compile exec:java

## Maven init project
mvn archetype:generate -DgroupId={project-packaging}
                       -DartifactId={project-name}
                       -DarchetypeArtifactId=maven-archetype-quickstart
                       -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.app \
                       -DartifactId=app \
                       -DarchetypeArtifactId=maven-archetype-quickstart \
                       -DinteractiveMode=false

## Maven add jar
mvn install:install-file  -Dfile=./vendor/algs4.jar \
                          -DgroupId=com.algs4 \
                          -DartifactId=com.algs4 \
                          -Dversion=1.0 \
                          -Dpackaging=jar

mvn install:install-file -Dfile=./vendor/algs4.jar \
                         -DgroupId=com.algs4 \
                         -DartifactId=com.algs4 \
                         -Dversion=1.0 \
                         -Dpackaging=jar \
                         -DgeneratePom=true


## Pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.app</groupId>
  <artifactId>app</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>app</name>
  <url>http://maven.apache.org</url>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>edu.princeton.cs.introcs</groupId>
      <artifactId>stdlib-package</artifactId>
      <version>1.0</version>
      <scope>system</scope>
      <systemPath>${project.basedir}/src/main/resources/stdlib.jar</systemPath>
    </dependency>

    <dependency>
      <groupId>edu.princeton.cs</groupId>
      <artifactId>algs4</artifactId>
      <version>1.0.2</version>
      <scope>system</scope>
      <systemPath>${project.basedir}/src/main/resources/algs4.jar</systemPath>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.2.1</version>
        <configuration>
          <mainClass>com.app.App</mainClass>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>
```
