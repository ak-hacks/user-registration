UserRegistration
----------------

This is a simple web application demonstrating a user registration system using Spring, Hibernate and MySQL. The web app also demostrates the use of org.springframework.core.task.TaskExecutor for multithreading. This has been tested on:

* Tomcat 6.0.32
* Spring 3.0.6
* Hibernate 3
* Java 1.6

The project also includes an ant build file called build.xml that can be used to get a packaged .war file ready to be deployed on a Tomcat instance.
The output of the build script goes into a folder called dist at the root level. A directory called wars inside the dist folder will contain the required UserRegistration.was file post execution.