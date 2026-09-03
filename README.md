# Spring Security Authentication System

A Spring Boot REST API implementing user registration and authentication using Spring Security, Spring Data JPA, MySQL, BCrypt, ModelMapper, and Swagger.

 =>Structure

```text
src/main/java/com/project/dcl
│
├── config
│   └── AppConfig.java
│
├── control
│   └── DemoController.java
│
├── dto
│   └── Userdto.java
│
├── entity
│   └── User.java
│
├── Exception
│   └── AppException.java
│
├── repo
│   └── Userrepo.java
│
├── request
│   ├── Registerrequest.java
│   └── Loginrequest.java
│
├── response
│   └── ApiResponse.java
│
├── service
│   └── UserService.java
│
└── servimp
    ├── servimp.java
    ├── UserDetailsimp.java
    └── UserSDetailsservimp.java
```

=> Architecture

                 Client
                   │
                   ▼
              Controller
                   │
                   ▼
               Service
                   │
                   ▼
              Repository
                   │
                   ▼
             MySQL Database
```

=> Spring Security Architecture


              Login Request
                    │
                    ▼
          AuthenticationManager
                    │
                    ▼
        DaoAuthenticationProvider
                    │
                    ▼
        Custom UserDetailsService
                    │
                    ▼
             UserRepository
                    │
                    ▼
             MySQL Database
                    │
                    ▼
        BCrypt Password Verification
                    │
                    ▼
          Authentication Result
```

=> Registration Flow

POST /user/register
        ↓
Controller
        ↓
Service
        ↓
Check Existing Email
        ↓
BCrypt Password Encoding
        ↓
Repository
        ↓
MySQL
        ↓
Response
```

 => Login Flow

POST /user/login
        ↓
AuthenticationManager
        ↓
DaoAuthenticationProvider
        ↓
Custom UserDetailsService
        ↓
UserRepository
        ↓
MySQL
        ↓
BCrypt Password Verification
        ↓
Authentication Result
```

=>Tech Stack

Java 17 • Spring Boot • Spring Security • Spring Data JPA • MySQL • BCrypt • ModelMapper • Swagger.
