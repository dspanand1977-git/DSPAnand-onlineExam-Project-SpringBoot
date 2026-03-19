# Online Exam Portal

A sleek, modern, and secure web application built with **Spring Boot** and **Thymeleaf**, designed for taking and administering professional exams. The platform features a premium Zoho-like portal design and is fully containerized for easy cloud deployment.

![Java](https://img.shields.io/badge/Java-21-orange.svg) 
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.x-brightgreen.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED.svg)

## 🌟 Key Features

### For Students
* **Clean Authentication:** Sleek, modern login and registration interfaces.
* **Student Dashboard:** View all assigned or available exams in a clean, card-based interface.
* **Distraction-Free Exams:** A polished, secure, and focused exam-taking interface.
* **Instant Results:** Automatic grading and immediate visual feedback upon submission.

### For Administrators
* **Secure Access:** Dedicated Admin Portal protected by master credentials.
* **Exam Management:** Create new exams and set precise time limits.
* **Question Engine:** Easily add multiple-choice questions (A/B/C/D) and set correct answers.

## 🛠️ Tech Stack

* **Backend**: Java 21, Spring Boot, Spring Data JPA, Hibernate
* **Frontend**: Thymeleaf templates, Custom Vanilla CSS (Modern Glassmorphic UI)
* **Database**: MySQL Server
* **Build Tool**: Maven
* **Deployment**: Docker Support Included

---

## 🚀 Running Locally

### Prerequisites
* Java 17 or 21 installed (`JAVA_HOME` configured)
* MySQL Server (running on port `3306`)
* Maven (optional, wrapper is included)

### Setup Steps
1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd onlineexam
   ```

2. **Configure Database:**
   Ensure you have a local MySQL database named `online_exam`. If the password for `root` is not `password`, open `src/main/resources/application.properties` and update your credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/online_exam
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Build and Run:**
   ```bash
   ./mvnw clean package -DskipTests
   ./mvnw spring-boot:run
   ```

4. **Access the Application:**
   * Open your browser and navigate to `http://localhost:8080`
   * **Student Login**: Click "Student Login" on the home page.
   * **Admin Access**: Navigate to `/admin/login` or click "Admin Panel". The master password is **`Anand@CKS`**.

---

## ☁️ Free Cloud Deployment Guide

This project is fully automated for deployment using Docker and secure Environment Variables.

### 1. Database Setup (Aiven)
1. Register at [Aiven.io](https://aiven.io/) for a **free** hosted MySQL database.
2. Obtain your Connection URI from the Aiven Console.
3. Convert the strict URI into JDBC format. Example: `jdbc:mysql://your-host.aivencloud.com:20392/defaultdb`.

### 2. Application Deployment (Render)
1. Push this code to a public or private GitHub repository.
2. Go to [Render.com](https://render.com/), click **New** -> **Web Service**.
3. Connect your GitHub repository. It will automatically detect the provided `Dockerfile`.
4. Add the following **Environment Variables**:
   * `DB_URL`: *(Your Aiven JDBC URL)*
   * `DB_USERNAME`: *(Your Aiven username, usually `avnadmin`)*
   * `DB_PASSWORD`: *(Your Aiven password)*
5. Deploy the application! Render will inject these variables securely into the Spring Boot backend. 

---
*Developed by Anand • CKS*
