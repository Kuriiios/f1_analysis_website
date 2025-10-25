# 🏁 F1 Analysis Website

This repository hosts the backend and API code for an interactive Formula 1 Data Analysis Dashboard. The core service is built using Java and the Spring Boot framework, designed to efficiently process and serve complex F1 data.

The project's primary goal is to provide a real-time (or post-session) analytical view of F1 sessions, with a strong focus on the 2025 season, enabling detailed teammate performance comparison and race strategy analysis via structured RESTful APIs.

## 🚧 Status: Under Development

This project is currently under active development and is not yet in a finished state.

While you are welcome to explore and test the existing features, please be aware that:

    Functionality is incomplete and may be buggy.

## 🚀 Getting Started

Prerequisites
    
    Java 21+ (JDK)
    
    Spring Boot 3+
    
    Maven
    
    A PostgreSQL/H2 Database (for persistence and mock data)

## ⚙️ Architecture and Logic (Spring Boot)

    The application adheres to a clean, layered Spring Boot architecture to ensure maintainability and testability.

## Data Model / Entities

The following core entities have been modeled, providing comprehensive data coverage for F1 sessions:

    Session Metadata: EventRound, EventSession, SessionName
    
    Participants: Driver, Team
    
    Timing & Lap Data: Lap, PosData, CarData, DTA
    
    Track & External Factors: TrackStatus, Weather, Compound, DRS

## Key Java Functionality
    
    Data Ingestion Status: Data ingestion logic is currently under active development to load and normalize raw F1 data into the PostgreSQL/H2 database model.

## Data Processing Services:

    Pace Calculation: Implements core business logic for pace comparison, normalizing lap times based on track conditions, fuel load, and tire degradation.
    
    Data Transformation: Handles conversion of raw F1 data (intended to be fetched from an external source) into structured DTOs (Data Transfer Objects) for API responses.
    
    Qualifying Logic: Custom logic for handling various session ranges, especially the cut-off times in different qualifying segments (Q1, Q2, Q3).

## REST Controllers:

    Expose the structured data via clear endpoints.

## Time Formatting:
    
    Utility classes ensure all time values are converted and returned in the standard M:SS.mmm format, ready for frontend display.

## 👨‍💻 Author

Cyril Leconte 📍 Créteil, France
📧 cyril.leconte@proton.me
🔗 LinkedIn | GitHub
