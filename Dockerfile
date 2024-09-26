FROM openjdk:21-jdk-slim AS builder

RUN adduser --disabled-password --gecos '' gradleuser

WORKDIR /app

COPY gradlew gradlew
COPY gradlew.bat gradlew.bat
COPY gradle gradle
COPY build.gradle settings.gradle ./
COPY src ./src

RUN chown -R gradleuser:gradleuser /app

USER gradleuser

RUN chmod +x gradlew

RUN ./gradlew build --no-daemon --info

FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]