Калькулятор отпускных

Микросервис на Spring Boot для расчёта отпускных на основе средней месячной зарплаты и периода отпуска.
Поддерживает как ручной ввод количества дней, так и расчёт по диапазону дат с учётом выходных и праздников.

⸻

Возможности
•	Расчёт отпускных по количеству дней или диапазону дат
•	Исключение выходных и праздничных дней (при указании диапазона)
•	Сохранение истории расчётов в PostgreSQL
•	REST API + Swagger UI
•	Полная контейнеризация через Docker и Docker Compose

⸻

Используемые технологии
•	Java 11
•	Spring Boot 2.7
•	Spring Data JPA
•	PostgreSQL 14
•	Docker и Docker Compose
•	OpenAPI (Swagger)
•	JUnit 5 + Mockito
•	Git + GitFlow

⸻

Как запустить (Docker)

./gradlew clean build
docker-compose up --build

Открой в браузере: http://localhost:8080/swagger-ui.html

⸻

Примеры API-запросов

GET /calculate?averageSalary=60000&vacationDays=10

GET /calculate?averageSalary=60000&startDate=2024-05-01&endDate=2024-05-12

GET /calculate/history

⸻

Структура проекта

src/
├── api           → Контроллеры и DTO
├── application   → Бизнес-логика
├── domain        → Доменные модели и enum'ы
├── infrastructure → Репозитории и доступ к данным
└── config        → Конфигурации Spring
