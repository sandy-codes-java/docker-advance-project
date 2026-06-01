# 📘 Spring Boot + MySQL Dockerized Application

This project demonstrates how to run a Spring Boot application with MySQL using Docker and Docker Compose, following best practices for optimization, networking, volumes, and security.

#  Prerequisites

Make sure you have installed:

- Docker
- Docker Compose (v2+)
- Git (optional)

Verify installation:

```bash
docker --version
docker compose version
```

# ▶ Steps to Run the Application

### 1. created the repository
```bash
https://github.com/sandy-codes-java/docker-advance-project
```

### 2. Build and start containers
```bash
docker compose up --build
```

### 3. Access the application
- App: http://localhost:8080
- MySQL: localhost:3307

### 4. Stop containers
```bash
docker compose down
```


#  Assignment Summary

-  Multi-stage Docker build
-  Optimized image size
-  Custom Docker network
-  Named volumes and bind mounts
-  Backup and restore capability
-  Security best practices (non-root user, limits)
-  Docker Bench security audit support

---

# 💡 Key Commands

### Network
```bash
docker network ls
docker network inspect my-network
```

### Volume Backup
```bash
docker run --rm \
   -v docker_mysql-data:/volume \
   -v $(pwd):/backup \
   alpine tar czf /backup/mysql-backup.tar.gz /volume
```

### Volume Restore
```bash
docker run --rm \
   -v docker_mysql-data:/volume \
   -v $(pwd):/backup \
   alpine sh -c "rm -rf /volume/* && tar xzf /backup/mysql-backup.tar.gz -C /" 
```

### Security Scan
```bash
docker scout cves <image-name>
```

---

Assignment solution
1. Use Multi-Stage Builds
   Stages:
   Builder stage → compiles code using Maven
   Runtime stage → runs only compiled JAR
   Benefit:
   Removes unnecessary build tools (Maven not included in final image)
   Smaller and cleaner image
2.  Custom Docker Network
    networks:
    my-network:
    driver: bridge
    commands to inspect network -> docker network ls  && docker network inspect my-network
3. Create and Manage Docker Volumes
   volumes:
   mysql-data:
   app-logs:
   Benifit : Stores MySQL data persistently and Stores application logs
4. Named Volumes and Bind Mounts
   Named Volume: mysql-data:/var/lib/mysql
   Managed by Docker
   Used for database persistence
   app.log -> used to store the applicatin log 
   command to check the logs:  docker exec -it spring-app cat /app/logs/app.log
   Bind Mount: ./config:/app/config
   Useful for config files
5. Backup Volumes
   docker run --rm \
   -v docker_mysql-data:/volume \
   -v $(pwd):/backup \
   alpine tar czf /backup/mysql-backup.tar.gz /volume
   then delete the data from table AND stop the containers
6. Restore Volumes
   docker run --rm \
   -v docker_mysql-data:/volume \
   -v $(pwd):/backup \
   alpine sh -c "rm -rf /volume/* && tar xzf /backup/mysql-backup.tar.gz -C /" 
   then start the containers and we will see the table data again
7. Security Best Practices
   Non-root user: USER spring
   Container runs as non-root user
   Benefit:
    Reduces attack surface
    Prevents system-level access
8. Image Vulnerability Scanning
   docker scout cves --local docker-app
   Detect security vulnerabilities in Docker images
   It found 3 critical vulnerabilities due to tomcat version. so i upgraded the version from 11.0.21 to 11.0.22
9. Docker Bench for Security
   docker run --rm -it \
   --net host \
   --pid host \
   --cap-add audit_control \
   -v /var/lib:/var/lib \
   -v /var/run/docker.sock:/var/run/docker.sock \
   docker/docker-bench-security
   Docker Bench:
    Works → native Linux host
    Fails → WSL / Docker Desktop setups
   getting this error -> Error connecting to docker daemon



   


