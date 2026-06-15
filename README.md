# Employee API
A Spring Boot REST API for managing employees and their vacation accrual.

---

## API Endpoints

| Method | Full URL | Body |
|--------|----------|------|
| GET | http://localhost:8080/api/employees | — |
| GET | http://localhost:8080/api/employees?type=HOURLY | — |
| GET | http://localhost:8080/api/employees?type=SALARIED | — |
| GET | http://localhost:8080/api/employees?type=MANAGER | — |
| GET | http://localhost:8080/api/employees/{id} | — |
| POST | http://localhost:8080/api/employees/{id}/work | {"daysWorked": 130} |
| POST | http://localhost:8080/api/employees/{id}/vacation | {"vacationDays": 2.5} |

---

## Employee IDs

| Type | IDs |
|------|-----|
| Hourly Employees | 1 - 10 |
| Salaried Employees | 11 - 20 |
| Managers | 21 - 30 |

---

## Vacation Accrual Rates

| Employee Type | Vacation Days Per Year |
|---------------|----------------------|
| Hourly | 10 days |
| Salaried | 15 days |
| Manager | 30 days |

---

## Tech Stack
- Java 17
- Spring Boot 3.2.5
- Maven

---

## Running the App
mvn spring-boot:run

The app will start on http://localhost:8080
