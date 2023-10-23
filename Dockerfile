FROM eclipse-temurin:21-jdk-jammy
COPY target/thebestprototypeapi-0.0.1-SNAPSHOT.jar thebestprototypeapi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/thebestprototypeapi-0.0.1-SNAPSHOT.jar"]