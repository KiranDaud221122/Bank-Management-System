# 🏦 Banking Application (Spring Boot + JPA + MySQL)

A simple and efficient **Banking Management System** built using **Spring Boot**, **Spring Data JPA**, and **MySQL**.  
This project allows users to **create accounts**, **deposit/withdraw money**, and **view transaction history**.  
It’s a great hands-on project for anyone learning backend development with Spring Boot.

---

## 🚀 Features

✅ Create new bank accounts  
✅ Deposit and withdraw funds  
✅ Maintain account balance automatically  
✅ Track all transactions (Deposit / Withdraw)  
✅ View all transactions for a specific account  
✅ RESTful API design using Spring Boot  
✅ Database integration using MySQL and Hibernate ORM  

---

## 🧩 Tech Stack

- **Java 17+**  
- **Spring Boot 3+**  
- **Spring Data JPA (Hibernate)**  
- **MySQL Database**  
- **Postman** (for API testing)  
- **IntelliJ IDEA / Eclipse** (for development)

---

## 📁 Project Structure

```
com.BankingAPPSpringBoot.BankingApplication
│
├── controller
│   ├── AccountController.java
│   └── TransactionController.java
│
├── dto
│   └── AccountDto.java
│
├── entity
│   ├── Account.java
│   └── TransactionHistory.java
│
├── mapper
│   └── AccountMapper.java
│
├── repository
│   ├── AccountRepository.java
│   └── TransactionHistoryRepository.java
│
├── service
│   ├── AccountService.java
│   └── impl
│       └── AccountServiceImpl.java
│
└── BankingApplication.java
```

---

## 🧠 API Endpoints

### 🔹 Account APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/accounts` | Create new account |
| `GET` | `/api/accounts` | Get all accounts |
| `GET` | `/api/accounts/{id}` | Get account by ID |
| `PUT` | `/api/accounts/{id}/deposit` | Deposit money |
| `PUT` | `/api/accounts/{id}/withdraw` | Withdraw money |

---

### 🔹 Transaction APIs

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `GET` | `/api/transactions/accounts/{accountId}` | Get all transactions of a specific account |

---

## 🧪 Sample JSON Responses

### ✅ Example: Transaction History Response

```json
[
  {
    "id": 1,
    "transactionType": "DEPOSIT",
    "amount": 1000,
    "dateTime": "2025-10-26T12:15:21",
    "account": {
      "id": 1,
      "accountHolderName": "Kiran Daud",
      "balance": 6000
    }
  },
  {
    "id": 2,
    "transactionType": "WITHDRAW",
    "amount": 1500,
    "dateTime": "2025-10-26T12:20:21",
    "account": {
      "id": 1,
      "accountHolderName": "Kiran Daud",
      "balance": 4500
    }
  }
]
```

---

## ⚙️ How to Run the Project

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/BankingApplication.git
   ```

2. **Open in IntelliJ IDEA / Eclipse**

3. **Configure MySQL Database**
   - Create a database in MySQL, e.g., `banking_app`
   - Update your `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/banking_app
     spring.datasource.username=root
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

4. **Run the Application**
   - Run `BankingApplication.java` as a Spring Boot Application.

5. **Test APIs using Postman**  
   Import the endpoints and perform CRUD operations easily.

---

## 🧰 Future Enhancements

- Add user authentication (Spring Security / JWT)
- Add transfer between accounts
- Integrate frontend using React or Angular
- Generate account statements as PDF

---

## 🧑‍💻 Author

**Kiran Daud**  
💼 Java Backend Developer | 💡 Spring Boot Enthusiast  
📧 [your-email@example.com]  
🔗 [LinkedIn Profile or Portfolio Link]
