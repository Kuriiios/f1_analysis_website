# 🏁 F1 Analysis Website

This repository hosts the backend and API code for an interactive Formula 1 Data Analysis Dashboard. The core service is built using Java and the Spring Boot framework, designed to efficiently process and serve complex F1 data.

The project's primary goal is to provide a real-time (or post-session) analytical view of F1 sessions, with a strong focus on the 2025 season, enabling detailed teammate performance comparison and race strategy analysis via structured RESTful APIs.

## 🚧 Status: Under Development

This project is currently under active development and is not yet in a finished state.

While you are welcome to explore and test the existing features, please be aware that:

    Functionality is incomplete and may be buggy.

## 🚀 Getting Started

Prerequisites
    
    **Java 21+ (JDK):** Required to run the application.
    
    **Spring Boot 3+:** The core framework (handled by Maven).
    
    **Maven:** To manage dependencies and build the project.
    
    **Database:** PostgreSQL

## ⚙️ Architecture and Logic (Spring Boot)

    The application adheres to a clean, layered Spring Boot architecture to ensure maintainability and testability.
    
<img width="2565" height="1539" alt="Untitled" src="https://github.com/user-attachments/assets/816eaa2a-d4cd-46a7-a517-cce8562bc5b7" />

    
## Data Model / Entities

The following core entities have been modeled, providing comprehensive data coverage for F1 sessions:

    Session Metadata: EventRound, EventSession, SessionName
    
    Participants: Driver, Team
    
    Timing & Lap Data: Lap, PosData, CarData, DTA
    
    Track & External Factors: TrackStatus, Weather, Compound, DRS

## Key Java Functionality
    
    Data Ingestion/Source: Data ingestion logic is currently under development to load and normalize raw F1 data. (Note: This API is currently designed to fetch data from an external F1 API or a local file source.)

## Data Processing Services:

    Pace Normalization Service: Implements advanced pace comparison logic by normalizing lap times based on key variables: fuel load correction (estimated), tire compound, and degradation models.
    
    Data Transformation: Handles conversion of raw F1 data (intended to be fetched from an external source) into structured DTOs (Data Transfer Objects) for API responses.
    
    Qualifying Logic: Custom logic for handling various session ranges, especially the cut-off times in different qualifying segments (Q1, Q2, Q3).

## REST Controllers:

    Expose the structured data via clear endpoints.

## Time Formatting:
    
    API Response Formatting: Utility classes ensure all timing data is consistently returned in the M:SS.mmm format, optimized for direct rendering by the frontend dashboard.

## 👨‍💻 Author

Cyril Leconte 📍 Créteil, France

📧 cyril.leconte@proton.me

🔗 [LinkedIn](https://www.linkedin.com/in/cyril-leconte/) | [Kaggle](https://www.kaggle.com/cyrilleconte)
