FROM mysql:latest

# Copy the database schema to the container
COPY ./videos.sql /docker-entrypoint-initdb.d/

# Set environment variables
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=videos
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password

# Expose the MySQL port
EXPOSE 3305
