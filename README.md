# Course Registration Program

Developed as a project for the 'Procedural Thinking and Programming' course in the first semester of 2024, this is a **Java Swing-based Course Registration Simulation Program**. It manages student information, course details, and enrollment records, providing an efficient visual interface for the course registration process.

## 🚀 Key Features

- **Course Lookup & Search**: View all registered courses and search based on specific conditions.

- **Enrollment & Cancellation**: Students can enroll in courses or cancel existing enrollments.

- **Conflict Prevention**: Prevents duplicate enrollments and schedule conflicts (time overlaps).

- **Capacity Management**: Enforces capacity limits for each course.

- **Credit Limit Management**: Prevents students from exceeding their maximum allowed credits.

- **MySQL Database Integration**: Business data (courses, enrollments) is persistently stored and managed in a database.

- **Intuitive GUI**: Provides a user-friendly graphical interface using Java Swing.

## 🛠️ Tech Stack

- **Language**: Java 17

- **GUI Framework**: Java Swing

- **Database**: MySQL

- **JDBC Driver**: `mysql-connector-j-9.3.0.jar`

- **Other Libraries**: `commons-codec-1.9.jar`

## 📁 Project Structure

```
📦 CourseRegistration
┣ 📂 src                     # Source Code
┃  ┣ 📂 constant            # Constants (Messages, Strings)
┃  ┣ 📂 controller          # Business Logic & Event Handling
┃  ┃  ┗ 📂 strategy        # Directory Navigation Strategies
┃  ┣ 📂 dao                 # Data Access Objects
┃  ┣ 📂 database            # Database Connection Helper
┃  ┣ 📂 model               # Data Models
┃  ┗ 📂 view                # User Interface (Java Swing)
┃     ┗ 📂 panel           # UI Panels
┣ 📂 resources               # Resources
┃  ┣ 📂 sql            # SQL Scripts
┃  ┃  ┗ 📜 insert.sql        # Initial Data Setup
┃  ┗ 📂 image               # Images
┣ 📂 lib                     # External Libraries (JARs)
┃  ┣ 📜 commons-codec-1.9.jar
┃  ┗ 📜 mysql-connector-j-9.3.0.jar
┗ 📜 README.md
```

## ⚙️ How to Run

This project requires a Java and MySQL environment.

### 1. Prerequisites

- **Java 17 or higher**: JDK/JRE must be installed.

- **MySQL Server**: A MySQL database server must be running.

- **MySQL JDBC Driver**: Ensure `mysql-connector-j-9.3.0.jar` is in the `lib` folder.

- **Commons Codec**: Ensure `commons-codec-1.9.jar` is in the `lib` folder.

### 2. Database Setup

1. Connect to your MySQL server.

2. Execute the `resources/database/insert.sql` file to create the necessary tables and insert initial data.
   
   - Note: The SQL script assumes a database schema or you might need to create a database first (e.g., `CREATE DATABASE course_db; USE course_db;`). Check `Constants.java` for the DB name used.

3. Update the DB connection settings (URL, Username, Password) in `src/constant/Constants.java` (under `database` class) to match your local environment.

### 3. Build & Run

1. **Clone the Project**:
   
   ```bash
   git clone https://github.com/Suehyun666/2024_1-1_Course_Register.git
   cd 2024_1-1_Course_Register
   ```

2. **Library Configuration**:
   
   - Add the `.jar` files from the `lib` folder as **External Libraries** in your IDE (IntelliJ IDEA, Eclipse, etc.).

3. **Compile & Execute**:
   
   - **IDE**: Run `src/Main.java`.
   
   - **Terminal**:
     
     ```bash
     cd src
     
     # Compile (Adjust classpath separator: ';' for Windows, ':' for Mac/Linux)
     javac -cp ".;../lib/mysql-connector-j-9.3.0.jar;../lib/commons-codec-1.9.jar" Main.java
     
     # Run
     java -cp ".;../lib/mysql-connector-j-9.3.0.jar;../lib/commons-codec-1.9.jar" Main
     ```

## 🏛️ Architecture Overview

The program follows the **MVC (Model-View-Controller) Pattern**:

- **Model**: Manages core data (Course, Student, Enrollment) and interacts with the database (DAO).

- **View**: Handles the visual representation using Java Swing components.

- **Controller**: Processes user inputs and orchestrates interactions between the Model and View.

This separation ensures independent management of components, improving maintainability and scalability.
