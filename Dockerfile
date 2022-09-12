# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13 AS base.jdk

LABEL image.author="Sikander Bhambhu"

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

COPY src ./src

FROM base.jdk AS test
CMD ["./mvnw", "test"]

FROM base.jdk AS development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

FROM base.jdk AS build
RUN ./mvnw package

FROM openjdk:11-jre-slim AS production
EXPOSE 8080
COPY --from=build /app/target/employee-service-0.0.1-SNAPSHOT.jar /employee-service.jar
#CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/employee-service.jar"]
ENTRYPOINT ["java", "-jar", "/employee-service.jar"]