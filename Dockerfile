#
# Build stage
#
FROM 3.9.0-eclipse-temurin-21-alpine AS build
COPY . .
RUN mvn clean package -Pprod -DskipTests

#
# Package stage
#
FROM openjdk:21
COPY --from=build /target/thebestprototypeapi-0.0.1-SNAPSHOT.jar thebestprototypeapi-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/thebestprototypeapi-0.0.1-SNAPSHOT.jar"]