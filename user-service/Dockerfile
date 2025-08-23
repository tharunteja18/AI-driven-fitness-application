#using multistage build

FROM gradle:8.10.1-jdk17 AS build
WORKDIR /home/gradle/project
COPY --chown=gradle:gradle . .
RUN ./gradlew clean build -x test


FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /home/gradle/project/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]


# note
# AS can be used in small_letters aswell, using it in Captial is the standard practice
# /home/gradle is the default path for gradle
# 2nd stage it is not mandatory use the WORKDIR /app, but it is a good practice
# COPY --from=build /home/gradle/project/build/libs/*.jar app.jar →
# copies the JAR from the build stage into the current working directory (/app) and renames it to app.jar.
# so inside the container file path is /app/app.jar
