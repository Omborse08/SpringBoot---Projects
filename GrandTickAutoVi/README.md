# 🏎️ Grand Tick Auto VI Hub

Welcome to **Grand Tick Auto VI Hub** – A premium, dynamic web application dashboard built to track countdowns across multiple regional timezones, manage live Vice City bulletins, and provide an integrated Gemini AI explainer for breaking updates. 

This repository contains the full enterprise-grade backend infrastructure powered by Spring Boot, Spring Security, and Spring AI.

---

## 🚀 Features

* **🔒 Admin Workspace Active:** Secure restriction boundaries for admins to post, update, and drop bulleted news updates.
* **🌐 Timezone-Aware Countdown Engine:** Real-time synchronized countdown modules supporting adaptive local clocks (Mumbai, New York, London, Global UTC).
* **🛡️ Robust CORS & Security Handshake:** Fully configured interceptor rules allowing custom tracking parameters without browser pre-flight interruptions.
* **🧠 Embedded Gemini Explainer:** Utilizes advanced LLM capabilities via Spring AI to break down complex inner gaming updates interactively.

---

## 🛠️ Tech Stack

* **Backend:** Java 17, Spring Boot 3.x, Spring Security, Spring Data JPA
* **AI Integration:** Spring AI (ChatModel / Gemini)
* **Database:** MySQL / H2 Relational Database Engine
* **Frontend Integration:** RESTful APIs, Vanillajs Fetch API, Responsive Neon CSS Theme Engine

---

## ⚙️ Architecture & Security Profile

The ecosystem relies on an **Intercepting Filter Pattern** driven by a customized Spring Security filter layer. 

### Key Security Protocols:
1.  **CORS Explicit Trust Configuration:** Maps incoming origins and registers explicit standard verification routines for verbs like `POST`, `PUT`, `DELETE`, and `OPTIONS`.
2.  **Custom Token Expositions:** Whitelists payload parameters such as `Authorization`, `id`, and `user_message` directly through response boundaries.
3.  **Role-Based Separation Criteria:**
    * `/api/news/public/**` & `/api/countdown/**` ➡️ `permitAll()` (Anonymous Visitors)
    * `/api/news/admin/**` ➡️ `hasRole("ADMIN")` (Privileged Superusers)

---

## 📋 Security Configuration Snippet

```java
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
    security
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                    .requestMatchers("/api/news/public/**").permitAll()
                    .requestMatchers("/api/countdown/**").permitAll()
                    .requestMatchers("/api/news/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults());
    return security.build();
}
```

## 🗄️ Database Setup & SQL Scripts

-- 1. Create the dedicated schema space
CREATE DATABASE IF NOT EXISTS grand_tick_auto_vi;
USE grand_tick_auto_vi;

-- 2. Drop the table if it already exists to refresh schema state
DROP TABLE IF EXISTS `news`;

-- 3. Design structural entity table mirroring JPA Specifications
CREATE TABLE `news` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `about` TEXT NOT NULL,
  `image_data` VARCHAR(500) NOT NULL,
  `date` DATE DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 4. Inject Initial Seed Bulletins for immediate user display
INSERT INTO `news` (`title`, `about`, `image_data`, `date`) VALUES 
('Grand Theft Auto VI Pre-Orders Live', 'Rockstar Games has officially launched pre-orders across certified distribution networks. Official digital pricing tiers are now visible inside global storefront networks.', '[https://res.cloudinary.com/dlwfd8r9h/image/upload/v17825611.jpg](https://res.cloudinary.com/dlwfd8r9h/image/upload/v17825611.jpg)', '2026-06-18'),
('Massive Drop: High-Resolution Screenshots Released', 'An unprecedented technical look into Vice City reveals updated runtime physics, dynamic neon rendering reflections, and fully polished protagonist mechanics.', '[https://res.cloudinary.com/dlwfd8r9h/image/upload/v17825612.jpg](https://res.cloudinary.com/dlwfd8r9h/image/upload/v17825612.jpg)', '2025-05-06');

## 💻 Getting Started

git clone [https://github.com/your-username/GrandTickAutoVi.git](https://github.com/your-username/GrandTickAutoVi.git)

spring.datasource.url=jdbc:mysql://localhost:3306/grand_tick_auto_vi
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

mvn spring-boot:run
