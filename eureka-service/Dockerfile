FROM gradle:8.10.1-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN ./gradlew clean build -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]