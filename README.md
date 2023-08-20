# Sapp-App

<div align="center">
  <img src="C:\Users\patro\OneDrive\Pulpit\256x256bb.jpg" alt="Project Icon">
</div>

## Description
This repository contains a Spring Boot project named "Sapp-App," designed to function as a robust Security Application. The project employs the Spring Boot Starter Parent version 2.5.6 and is developed using Java 11.

## Profiles 🚀
The project encompasses several distinct profiles:

- **dev**: Development profile
- **docker**: Docker profile
- **prod**: Production profile
- **ci**: Continuous Integration profile (active by default)

## Dependencies 📦
The project relies on the following key dependencies:

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Security Taglibs
- Spring Boot Starter Web
- Spring Boot Starter Actuator
- Tomcat Embed Jasper
- JSTL
- PostgreSQL (runtime scope)
- Lombok (optional)
- Spring Boot Starter Test
- Spring Security Test

## Build Configuration 🛠️
The project build is adeptly managed through Maven plugins:

- **Spring Boot Maven Plugin**
  - Excludes the Lombok library from the final artifact.
- **Tomcat7 Maven Plugin**
  - Tailored for remote deployment to a Tomcat server.
- **Maven War Plugin**
  - Version 3.2.2 (Configuration commented out)
- **Maven Antrun Plugin**
  - Displays the current active profile during the generate-resources phase.

## How to Build and Run ▶️
1. Verify the presence of Java 11 on your system.
2. Execute the following Maven command to initiate the build process:
   ```bash
   mvn clean install
