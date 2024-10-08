# bootcamp-sb+

1. create spring-boot project
2. open file under a Correct path : 
   scr/main/java/com/example/{{artifactId}}, com.example is your groupId
3. Add dependency :lombok + spring web
4. Controller -> Add @Annotation:
   1.@Controller , 2. @ResponseBody
5. go to terminal , 'cd' to your project
6. command 'ls' to confirm your are in the correct path with file : pom.xml , then 'mvn clean install' 
   Target : BUILD SUCCESS
7. 'mvn spring-boot:run' -> open Server

####

- App1 demo-sb-helloworld
- App2 demo-sb-restapi (Spring web, lombok, devtools)