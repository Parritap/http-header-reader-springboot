FROM gradle:9.7.1-jdk21 AS build

WORKDIR /home/gradle

COPY --chown=gradle:gradle gradlew settings.gradle build.gradle ./
COPY --chown=gradle:gradle gradle ./gradle
RUN chmod +x gradlew

COPY --chown=gradle:gradle src ./src
RUN ./gradlew --no-daemon clean bootJar

FROM eclipse-temurin:21-jre

WORKDIR /app
COPY --from=build /home/gradle/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
 