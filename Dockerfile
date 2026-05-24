
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .

RUN chmod +x ./gradlew
RUN ./gradlew clean bootJar -x test

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Cambiamos la ruta para que busque cualquier .jar dentro de libs sin importar el nombre completo
COPY --from=build /app/build/libs/ app.jar
RUN mv /app/*.jar /app/app.jar 2>/dev/null || true

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
