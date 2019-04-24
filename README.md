# jsp-servlet-crud
This is simple CRUD Operations example using JSP, Servlet, JDBC, H2 database for in-memory operations. 

# Project requirements.
1. Java 8
2. Apache Tomcat8.5
3. h2 database v1.4.192 for in-memory database.
4. jstl-1.2.jar for the JSP core tags.

# Project Setup
Import the Project into Eclipse Oxygen 4.7.3a.

Configure your build path by right-clicking the project. Please refer to this link for [How to Configure build path](https://www.youtube.com/watch?v=L-DBitOKVxo).

Please refer to this link for [Adding Server Runtime](https://www.codejava.net/servers/tomcat/how-to-add-tomcat-server-in-eclipse-ide). Please make sure you select the Apache Tomcatv8.5 as your server. Since the minimum requirement for this Project is v8 or above.The example provided in the link refers to earlier version.

Once you have done the above step, add the Server Runtime to the build path by right clicking the project `select build path -> Configure Build Path -> Click Add Library button ->  Choose Server Runtime from the list -> and the list displays the previously added server runtime -> then click Finish button -> then click Apply and Close button`.

After all the above steps, the compilation errors will be vanished and you are ready to run the application. 

To run the application right click the project `Select Run As -> Run on Server`.

Open your browser and type [http://localhost:8080/TestServlet/](http://localhost:8080/TestServlet/)

For more info on JSP-Servlet example, you can refer to this link [CodeJava.net](https://www.codejava.net/coding/jsp-servlet-jdbc-mysql-create-read-update-delete-crud-example).
