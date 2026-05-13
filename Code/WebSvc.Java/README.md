# Simple Web Service in Java

This is an example of a Jakarta Web Servlet.

You can run some simple unit tests (see the <i>unitTests</i> package), or run the full server. To do this latter, you must install the <a href="https://www.eclipse.org/downloads/packages/release/2025-12/r/eclipse-ide-enterprise-java-and-web-developers">Eclipse IDE for Web developers</a>.

This has been tested with <a href="https://tomcat.apache.org/">Tomcat</a> 11.0.

It also works with Tomcat <10.0, but in this case you shall replace the <a href="https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api">jakarta.servlet-api</a> library with the <a href="https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api">javax.servlet</a> lib. Find both them in the local "Lib" folder of this code repo.