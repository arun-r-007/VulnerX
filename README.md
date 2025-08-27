# VulnerX - AI-powered Web-based Security Scanner

**VulnerX** is an AI-powered web-based security scanner that identifies system vulnerabilities using Nmap, banner grabbing, and intelligent threat detection techniques. Designed for ethical security testing, it provides deep insights into system exposures through an intuitive interface built with Spring Boot and Thymeleaf.

---

## Features

- **AI-Powered Vulnerability Detection**
- **Nmap-Based Network Scanning**
- **Banner Grabbing for Service Fingerprinting**
- **Dynamic Scan Result Dashboard**
- **Quick / Deep / Custom Scan Modes**
- **Modular Scanner Components**
- **Responsive UI with Thymeleaf Templates**

---

## Tech Stack

- **Java 17+**
- **Spring Boot**
- **Maven**
- **Thymeleaf (HTML templating)**
- **Nmap (System command integration)**
- **Font Awesome**
- **Custom CSS**

---

## Project Structure

```

VulnerX/
├── src/
│   ├── main/
│   │   ├── java/com/securitysystem/
│   │   │   ├── ai/                     # AI logic (optional)
│   │   │   ├── controller/             # Home and Scanner controllers
│   │   │   ├── idps/                   # Intrusion Detection components
│   │   │   ├── logger/                 # Logging and audit tools
│   │   │   ├── main/                   # Application entry point
│   │   │   ├── scanner/                # Core scanners (Nmap, banner grab, vuln)
│   │   │   └── service/                # Service classes
│   │   ├── resources/
│   │   │   ├── static/                 # CSS, JS, images (optional)
│   │   │   ├── templates/              # Thymeleaf HTML templates
│   │   │   │   ├── index.html
│   │   │   │   ├── scanner.html
│   │   │   │   └── scanResult.html
│   │   │   └── application.properties
│   └── test/                           # Unit and integration tests
├── db.sql                              # Database schema (optional)
├── pom.xml                             # Maven dependencies and build config
├── LICENSE                             # Project license
├── README.md                           # This file
├── mvnw / mvnw\.cmd                     # Maven wrapper scripts
└── .gitignore / .gitattributes         # Git configuration

````

---

## Getting Started

### Prerequisites

Make sure you have the following installed:

- Java 17+
- Maven (or use the included Maven Wrapper)
- Nmap installed and added to PATH ([https://nmap.org/download.html](https://nmap.org/download.html))

---

### How to Build and Run

#### 1. Clone the Repository
```bash
git clone https://github.com/arun-r-007/VulnerX.git
cd VulnerX
````

#### 2. Build All Dependencies

This will download and install all required libraries into your local Maven repository:

```bash
./mvnw clean install
```

#### 3. Run the Application

```bash
./mvnw spring-boot:run
```

Or with Maven installed globally:

```bash
mvn spring-boot:run
```

#### Access the Application

> Navigate to:
> [http://localhost:8080](http://localhost:8080)

---

## Web UI Routes

| Page         | URL           | Description                               |
| ------------ | ------------- | ----------------------------------------- |
| Home         | `/`           | Welcome page with scan entry button       |
| Start Scan   | `/scanner`    | Scan options UI (quick/deep/custom)       |
| Scan Results | `/scanResult` | Displays results in a table (safe/unsafe) |

---

## Running Tests

```bash
mvn test
```

---

## Example Use Cases

* Network port analysis via Nmap
* Checking banners for outdated or risky services
* Quick scanning for basic misconfigurations
* Deep vulnerability scanning using AI logic (custom module)

---

## Contributing

Contributions, bug reports, and feature requests are welcome!

```bash
# Steps to contribute
1. Fork this repo
2. Create a branch (`git checkout -b feature/my-feature`)
3. Commit your changes
4. Push and open a pull request
```

----

## Project Screenshots

![Screenshot1](https://github.com/user-attachments/assets/b258e43b-5dac-4f4d-a23b-9b2e056225df)
![Screenshot2](https://github.com/user-attachments/assets/0a7944af-986a-4003-ba51-c14ad5b57d2f)
![Screenshot3](https://github.com/user-attachments/assets/2fe13fdf-d22b-4ba8-a338-9d8c975a4766)
![Screenshot4](https://github.com/user-attachments/assets/462b2558-90df-4dc4-a142-abf5bdb86645)
