# 🏥 ClaimCheck Pro

### Healthcare Billing Workflow Analytics & Automation Platform

ClaimCheck Pro is a full-stack healthcare claims analytics platform that simulates large-scale claim processing workflows, identifies rejection drivers, tracks operational KPIs, and automates claim validation using rule-based decisioning.

Built using **Java, Spring Boot, MySQL, React, SQL, and CSV-based analytics**, the platform processes and analyzes **100,000+ healthcare claims** to uncover workflow inefficiencies and improve operational performance.

---

## 🚀 Project Highlights

✅ Processed and analyzed **100K+ healthcare claims**

✅ Identified **21% data-quality issues** impacting claim acceptance

✅ Detected a dominant error contributing to **43% of claim rejections**

✅ Automated validation and decision-making through a rule engine

✅ Reduced manual review workload through rule-based processing

✅ Generated actionable analytics and KPI dashboards

---

## 📊 Key Features

### Claim Processing Engine

* Claim ingestion and validation
* Procedure code verification
* Amount validation
* Rule-based approval/rejection workflows

### Workflow Analytics

* Acceptance Rate
* Rejection Rate
* Top Rejection Drivers
* Error Distribution Analysis
* Workflow Performance Metrics

### Automation Engine

* Automatic claim approval
* Automatic claim rejection
* Review queue assignment
* Business rule execution

### Dashboard & Visualization

* Interactive KPI cards
* Rejection reason analysis
* Error distribution charts
* Real-time analytics updates

### Database Integration

* MySQL persistence layer
* SQL-based aggregations
* Historical claim analysis

---

## 🏗️ System Architecture

```text
React Frontend
      │
      ▼
REST APIs
      │
      ▼
Spring Boot Backend
      │
      ├── Validation Engine
      ├── Rule Engine
      ├── Analytics Engine
      │
      ▼
MySQL Database
      │
      ▼
KPI Dashboard
```

---

## 📂 Project Structure

```text
claimcheck-pro/
│
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   │   └── Upload.js
│   │   ├── pages/
│   │   │   ├── Dashboard.js
│   │   │   └── Claims.js
│   │   ├── api.js
│   │   └── App.js
│
├── backend/
│   ├── controller/
│   │   └── ClaimController.java
│   ├── service/
│   │   ├── ClaimService.java
│   │   ├── ValidationService.java
│   │   └── RuleEngine.java
│   ├── repository/
│   │   └── ClaimRepository.java
│   ├── model/
│   │   └── Claim.java
│   ├── util/
│   │   └── DataGenerator.java
│   └── resources/
│       └── application.properties
```

---

## 🔄 Application Flow

### Claim Upload

```text
User Uploads Claims
        │
        ▼
ClaimController
        │
        ▼
ClaimService
        │
        ├── ValidationService
        ├── RuleEngine
        │
        ▼
MySQL Database
```

### Analytics Dashboard

```text
Dashboard Request
        │
        ▼
Analytics API
        │
        ▼
SQL Aggregations
        │
        ▼
KPIs + Charts
```

---

## 📈 KPIs Tracked

| KPI                | Description                   |
| ------------------ | ----------------------------- |
| Acceptance Rate    | Percentage of approved claims |
| Rejection Rate     | Percentage of rejected claims |
| Total Claims       | Total processed claims        |
| Top Error Driver   | Most frequent rejection cause |
| Error Contribution | Impact of top error category  |

---

## ⚙️ Business Rules

### Validation Rules

* Missing Procedure Code → Reject
* Invalid Amount → Reject
* Invalid Procedure Code → Reject

### Review Rules

* High Claim Amount → Manual Review

### Approval Rules

* Valid Claims → Auto Approve

---

## 🗄️ Sample SQL Analytics

### Total Claims

```sql
SELECT COUNT(*) FROM claim;
```

### Acceptance Rate

```sql
SELECT
COUNT(CASE WHEN status='APPROVED' THEN 1 END) * 100.0 /
COUNT(*) AS acceptance_rate
FROM claim;
```

### Top Rejection Driver

```sql
SELECT error_code, COUNT(*)
FROM claim
GROUP BY error_code
ORDER BY COUNT(*) DESC;
```

---

## 🧪 Generate Large Dataset

The platform includes a custom claim generator capable of producing:

* 10K Claims
* 50K Claims
* 100K+ Claims

Used for:

* Performance testing
* Analytics validation
* Workflow simulation

---

## 🛠️ Tech Stack

### Backend

* Java 17
* Spring Boot
* Spring Data JPA
* Maven

### Frontend

* React.js
* Axios
* Recharts

### Database

* MySQL

### Analytics

* SQL
* CSV Processing
* KPI Computation

---

## ▶️ Getting Started

### Backend

```bash
cd backend

mvn clean install

mvn spring-boot:run
```

Backend runs on:

```text
http://localhost:8080
```

---

### Frontend

```bash
cd frontend

npm install

npm start
```

Frontend runs on:

```text
http://localhost:3000
```

---

## 🎯 Resume Impact

* Built a scalable healthcare claims analytics platform
* Processed and analyzed 100K+ simulated healthcare claims
* Designed KPI-driven dashboards for operational insights
* Implemented SQL-powered analytics and reporting
* Developed a rule-based automation engine to streamline claim processing

---

## 🚀 Future Enhancements

* JWT Authentication
* Role-Based Access Control
* SLA Monitoring Dashboard
* Excel Export & Reporting
* Predictive Rejection Analysis
* Docker Deployment
* Cloud Hosting (AWS/Azure)

---

### ⭐ If you found this project useful, consider giving it a star!
