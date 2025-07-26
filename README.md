
# 🛒 E-Commerce Product Management Web App

This is a full-stack e-commerce product management application built with **React**, **Spring Boot**, and **PostgreSQL**. It allows users to browse products, view detailed info, and add items to a cart. Admin users can manage products (add, update, delete) with ease.
## 🚀 Features

- 📦 Product listing with images, brand, and pricing
- 🔍 Product detail view with stock, description, and date
- 🛒 Add to Cart functionality
- ✏️ Admin controls to add/update/delete products
- 🔗 RESTful API communication between frontend and backend
- 🔧 Backend built on MVC architecture with Spring Boot

---

## 🧰 Tech Stack

### Frontend:
- [React.js]
- Axios (for API calls)
- React Router
- CSS / Material UI

### Backend:
- Java + Spring Boot
- Spring MVC, Spring Data JPA
- PostgreSQL (Database)
- Maven (Build tool)

---

## 🗂️ Project Structure

```
frontend/         # React app
 └── src/
     └── components/
backend/          # Spring Boot project
 └── src/main/java/com/example/
     ├── controller/         # ProductController.java
     ├── model/              # Product.java
     └── repository/         # productRepo.java
```

---

## 📦 API Endpoints

| Method | Endpoint           | Description                  |
|--------|--------------------|------------------------------|
| GET    | `/products`        | Get all products             |
| GET    | `/product/{id}`    | Get product by ID            |
| POST   | `/product`         | Add a new product            |
| PUT    | `/product/{id}`    | Update an existing product   |
| DELETE | `/product/{id}`    | Delete a product             |

## 🛠️ Setup Instructions

### Backend (Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/ecommerce-app.git
   cd ecommerce-app/backend
   ```

2. Configure `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Run the app:
   ```bash
   mvn spring-boot:run
   ```

---

### Frontend (React)

1. Open a new terminal:
   ```bash
   cd ecommerce-app5
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the React app:
   ```bash
   npm run dev
   ```
