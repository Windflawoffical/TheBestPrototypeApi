#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM eclipse-temurin:21-jdk-jammy
COPY --from=build /target/thebestprototypeapi-0.0.1-SNAPSHOT.jar thebestprototypeapi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/thebestprototypeapi-0.0.1-SNAPSHOT.jar"]