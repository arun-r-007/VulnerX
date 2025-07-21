# 🔍 NMAP AI Security Scanner

**NMAP AI Security Scanner** is a Spring Boot–based web application designed for intelligent network security assessment. It integrates tools like **Nmap**, **Banner Grabbing**, and **AI-assisted Vulnerability Detection** within a user-friendly web interface powered by **Thymeleaf**.

---

## 🚀 Features

- ✅ AI-powered scanning modules (Quick, Deep, Custom)
- 🧠 Vulnerability detection using internal heuristics
- 🌐 Nmap-based network analysis
- 🛰️ Banner grabbing for service info
- 💻 Web interface with Thymeleaf templates
- 📊 Clean and animated frontend with scan result display

---

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Maven
- Thymeleaf (HTML Templating)
- CSS / FontAwesome
- Nmap (for scanning)
- Custom AI module (under `/ai`)
  
---

## 📂 Project Structure

```

NMAP/
├── src/
│   ├── main/
│   │   ├── java/com/securitysystem/
│   │   │   ├── ai/                     # AI logic
│   │   │   ├── controller/             # Web Controllers (Home, Scanner)
│   │   │   ├── idps/                   # Intrusion detection logic
│   │   │   ├── logger/                 # Logging utilities
│   │   │   ├── main/                   # Main app class, runner
│   │   │   ├── scanner/                # Scanning logic (vulnerabilities, banners)
│   │   │   └── service/                # Nmap scan service
│   │   ├── resources/
│   │   │   ├── static/                 # Static assets (CSS/JS/images)
│   │   │   ├── templates/              # Thymeleaf HTML files
│   │   │   │   ├── index.html
│   │   │   │   ├── scanner.html
│   │   │   │   └── scanResult.html
│   │   │   └── application.properties  # App config (port, templates, etc.)
│   └── test/
│       └── java/com/securitysystem/   # Unit and integration tests
├── db.sql                             # SQL dump if using a database
├── pom.xml                            # Maven config and dependencies
├── README.md                          # You are here!
├── LICENSE                            # License file
├── mvnw / mvnw\.cmd                    # Maven wrapper
└── .gitignore / .gitattributes        # Git config

````

---

## 🔧 Setup Instructions

### 1. Clone the repository

```bash
git clone https://github.com/your-username/nmap-security-scanner.git
cd nmap-security-scanner
````

### 2. Run the application

If you have Maven installed:

```bash
mvn spring-boot:run
```

Or using the Maven wrapper:

```bash
./mvnw spring-boot:run
```

> The application starts at:
> 👉 [http://localhost:8080](http://localhost:8080)

---

## 🌐 Web Pages

| Page         | URL           | Description                              |
| ------------ | ------------- | ---------------------------------------- |
| Home         | `/`           | Welcome page, start scan button          |
| Scanner      | `/scanner`    | Scan options UI                          |
| Scan Results | `/scanResult` | Table showing scan outcome (safe/unsafe) |

---

## 🧪 Running Tests

Run all unit tests:

```bash
mvn test
```

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

> ⚠️ For educational and ethical hacking purposes only.

---

## 🤝 Contributing

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 🙏 Acknowledgments

* [Spring Boot](https://spring.io/)
* [Thymeleaf](https://www.thymeleaf.org/)
* [Nmap](https://nmap.org/)
* [Font Awesome](https://fontawesome.com/)

---