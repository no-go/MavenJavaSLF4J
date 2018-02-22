# MavenJavaSLF4J
My mini Tutorial and private first steps with maven, java and a binding to a logging plugin

## Install

You need java and maven!

## Create a maven project

On Linux: type this line to create a `my-logtest` project folder:

    $ mvn archetype:generate -DgroupId=logtest -DartifactId=my-logtest \
    -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

go into this new folder:

    $ cd my-logtest

Importent files are: `pom.xml` and `src/main/java/logtest/App.java`. The
xml-File holds the maven magic. The `App.java` file is a simple Hello World
code.

## Compile

To compile the java code and make a jar package, do this in the  `my-logtest`
project folder:

    $ mvn package

## Start

It is possible to start the package with this maven command:

    $ mvn exec:java -Dexec.mainClass="logtest.App"

## Add the slf4j.Logger

I want to use a alien package in my maven project. I add this two line
in my java code below the `package logtest;` :

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
```

I use it in the main methode:

```java
public class App {
    public static void main( String[] args ) {
        Logger logger = LoggerFactory.getLogger(App.class);
        logger.info("Hello World");
        System.out.println( "Hello World!" );
    }
}
```

## Add slf4j to the pom.xml

Adding these two dependencies (the version number may vary a bit) worked for me:

```xml
<dependency>
  <groupId>org.slf4j</groupId>
  <artifactId>slf4j-api</artifactId>
  <version>1.7.24</version>
</dependency>
<dependency> 
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>1.0.13</version>
</dependency>
```

## clean and compile

Cleanup the package and rebuild it:

    $ mvn clean

output:

    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] Building my-logtest 1.0-SNAPSHOT
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ my-logtest ---
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 0.587 s
    [INFO] Finished at: 2018-02-22T13:50:22+01:00
    [INFO] Final Memory: 7M/147M
    [INFO] ------------------------------------------------------------------------

Rebuild it:

    $ mvn package

output:

    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] Building my-logtest 1.0-SNAPSHOT
    [INFO] ------------------------------------------------------------------------
    Downloading from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.24/slf4j-api-1.7.24.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.24/slf4j-api-1.7.24.pom (3.8 kB at 1.4 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-parent/1.7.24/slf4j-parent-1.7.24.pom
    Downloaded from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-parent/1.7.24/slf4j-parent-1.7.24.pom (14 kB at 75 kB/s)
    Downloading from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.24/slf4j-api-1.7.24.jar
    Downloaded from central: https://repo.maven.apache.org/maven2/org/slf4j/slf4j-api/1.7.24/slf4j-api-1.7.24.jar (41 kB at 210 kB/s)
    [INFO] 
    [INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ my-logtest ---
    [WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
    [INFO] skip non existing resourceDirectory /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/src/main/resources
    [INFO] 
    [INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ my-logtest ---
    [INFO] Changes detected - recompiling the module!
    [WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
    [INFO] Compiling 1 source file to /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/target/classes
    [INFO] 
    [INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ my-logtest ---
    [WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
    [INFO] skip non existing resourceDirectory /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/src/test/resources
    [INFO] 
    [INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ my-logtest ---
    [INFO] Changes detected - recompiling the module!
    [WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
    [INFO] Compiling 1 source file to /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/target/test-classes
    [INFO] 
    [INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ my-logtest ---
    [INFO] Surefire report directory: /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/target/surefire-reports
    
    -------------------------------------------------------
     T E S T S
    -------------------------------------------------------
    Running logtest.AppTest
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.018 sec
    
    Results :
    
    Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
    
    [INFO] 
    [INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ my-logtest ---
    [INFO] Building jar: /home/tux/Dokumente/hhu/sem4/_Projektarbeit/logtest/my-logtest/target/my-logtest-1.0-SNAPSHOT.jar
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 7.848 s
    [INFO] Finished at: 2018-02-22T13:57:15+01:00
    [INFO] Final Memory: 18M/160M
    [INFO] ------------------------------------------------------------------------


Because my system did not have the `slf4j-api` with version `1.7.24`, maven makes a download!!

## run it

If you do not want to have trouble with all the special jar files, the easiest
way to run the project is:

    $ mvn exec:java -Dexec.mainClass="logtest.App"

output:

    [INFO] Scanning for projects...
    [INFO] 
    [INFO] ------------------------------------------------------------------------
    [INFO] Building my-logtest 1.0-SNAPSHOT
    [INFO] ------------------------------------------------------------------------
    [INFO] 
    [INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ my-logtest ---
    13:57:28.505 [logtest.App.main()] INFO  logtest.App - Hello World
    Hello World!
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    [INFO] Total time: 1.916 s
    [INFO] Finished at: 2018-02-22T13:57:28+01:00
    [INFO] Final Memory: 11M/208M
    [INFO] ------------------------------------------------------------------------


**Were are the compiled file?** Look at the `target/` folder :-D

## Hint about Unit-Tests

The java test example code is at `src/test/java/logtest/AppTest.java`.
