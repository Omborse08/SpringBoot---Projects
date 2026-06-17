# 🛒 Amazon Clone - Full-Stack Spring Boot & Vanilla JS Portal

Bhai, yeh ek full-fledged eCommerce full-stack application hai jisme clean aur modern UI ke saath secure backend layers, custom business metrics integration aur robust transactional validation pipeline lagayi gayi hai.

---

## 👥 Authorship & Collaboration Roles

* **Backend Architecture & Database Integration:** Handled entirely by me (Spring Boot API validation layers, Repository mappings, Transactional state controls, and Custom Exception payload handlers).
* **Frontend UI & Client Interaction Engine:** Engineered via AI Assistance (A synchronized, vanilla asynchronous responsive layout built purely using static CSS and dynamic JavaScript state managers).

---

## 🚀 Key System Features

1.  **Dynamic Warehouse Grid Management:**
    * Full CRUD setup (Create, Read, Update, Delete) for Products.
    * Dynamic asset loading directly via HTTP image URLs.
    * Automatic placeholder rendering fallback if asset loads fail.

2.  **State-driven Session Customer Cart:**
    * Independent session tracking using unique Customer Profile IDs.
    * Real-time aggregated Bill calculations run instantly on content state modification.

3.  **Advanced Stock Protection Controls:**
    * Automatic synchronization between the available inventory and the active items placed inside consumer carts.
    * Strict transactional boundaries preventing double-allocations or negative inventory updates.

4.  **Centralized Validation & Custom Fault Mapping:**
    * Strict data limits (e.g., product pricing between ₹3,000 and ₹300,000, username size boundaries).
    * Graceful, client-friendly error toasts displaying localized field errors immediately upon processing failure.

---

## 🛠️ Technology Stack Used

* **Backend Engine:** Java 17+, Spring Boot (Spring Web, Spring Data JPA, Jakarta Validation).
* **Database Schema Container:** MySQL / H2 Relational Database.
* **Frontend Layer:** Responsive Semantic HTML5, Amazon-Vibe Custom CSS Variables, and Vanilla Asynchronous DOM JavaScript (Fetch API Engine).

---

## 📂 Project Architecture Layout

```text
├── src/main/java/com/example/AmazoneClone/
│   ├── controller/          # Exposed REST Endpoints (CrossOrigin mapped)
│   ├── modul/               # Core Database Entities & Data Models (Product, Customer, Cart, Bill)
│   ├── repository/          # JPA Hibernate Data access interfaces
│   ├── service/             # Centralized Business Logic Layers & Stock Managers
│   └── globalException/     # @RestControllerAdvice interception hub with Custom DTOs
└── frontend/
    └── index.html           # Full Single-page reactive application dashboard

```

## ⚙️Quick Installation & Setup Guide
1. Run the Spring Boot Application
Open the backend source code inside your favorite IDE (IntelliJ IDEA / Eclipse).
Configure your database dialect settings inside the src/main/resources/application.properties file.
Boot the application up by executing AmazoneCloneApplication.java. The local server engine will spin up on port 8080.

2. Launch the Front-End User Interface
Navigate to the frontend/index.html directory.
Directly double-click or open index.html using any modern web browser (Chrome, Edge, Brave, Firefox).
Register a user profile, enter your Customer Session ID, and start adding products to your marketplace cart!
