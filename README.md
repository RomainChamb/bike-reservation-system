# README

## Pipeline Dashboard

![Commit Stage](https://github.com/RomainChamb/bike-reservation-system/actions/workflows/commit-stage.yml/badge.svg)

## Informations

**System name** : Bike Reservation System

**Contributor** : [Romain](https://github.com/RomainChamb)

**Licence** : MIT Licence

**Context** : This project is a TDD Sandbox Project. I made it to gain experience with TDD. It is part of the "TDD in legacy code" series
from [Optivem Journal](https://journal.optivem.com/) and [Valentina Jemuović](https://www.linkedin.com/in/valentinajemuovic/)


## Use Cases

### Booking a bike
A rider can book a bike for a given date and duration. He can choose the type of bike during the booking process.

### Changing bike
A rider can change the type of bike he booked before the start of his rental period.

### Adding a bike
The admin can add a bike to the stock.

### Removing a bike
The admin can remove a bike from the stock.

## External systems
System clock
PostgreSQL
Public API for zip code (http://api.zippopotam.us)

## Architecture Style
Monolith with templated frontnend

## Architecture diagram
```mermaid
graph LR
    A[USER] --> B[SYSTEM] --> C[ZIP CODE API]
```
```mermaid
graph TD
    subgraph USER
        H[USER]
    end
    subgraph Exrternal System
        I[ZIP Code API]
    end
    subgraph Spring boot Service
        A[Templated UI] --> B[Bookin Controller]
        C[REST API] --> B
        B --> DTOs
        B --> D[Booking Service]
        D --> E["System Clock"]
        D --> Models
        D --> F[Repository]
        F --> G[(PostgreSQL Database)]
    end
    H --> A
    D --> I
```

## Tech stack
Java / Spring boot / Gradle / PostgreSQL

## Repository strategye
Mono-repo

## Branching strategy
Trunk Based Development

## Deployment Model
Local only (as of now)

## Manually deploy the system
[Deployment procedure](./documentation/DEPLOYMENT)

## Manually test the system
[Test procedure](./documentation/TEST_PROCEDURE.md)

## Project board
[Project's board](https://github.com/users/RomainChamb/projects/4/views/1)

## Pipeline Tool
Github Action

## Docker Registry
[Docker Hub](https://hub.docker.com/repository/docker/barbebroux/bike-reservation-system/general)



