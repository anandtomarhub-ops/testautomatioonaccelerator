# 🚀 Test Automation Accelerator
### Selenium Framework by Anand Singh Tomar

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=for-the-badge&logo=selenium&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=for-the-badge&logoColor=white)

---

## 📖 About This Project

This is a robust **Selenium-based Test Automation Framework** built to accelerate UI testing for web applications. The framework follows industry best practices including Page Object Model (POM), data-driven testing, and modular design — making it easy to scale and maintain.

---

## 🏗️ Project Structure

```
testautomatioonaccelerator/
│
├── 📁 Seniumframwork/
│   ├── 📁 src/
│   │   ├── 📁 main/java/
│   │   │   ├── base/          → Base classes (BaseTest, DriverManager)
│   │   │   ├── pages/         → Page Object Model classes
│   │   │   └── utils/         → Utility/Helper classes
│   │   │
│   │   └── 📁 test/java/
│   │       └── tests/         → Actual Test classes
│   │
│   ├── 📁 testsuites/         → TestNG XML suite files
│   ├── 📁 bin/                → Compiled class files
│   └── pom.xml                → Maven dependencies
│
├── .classpath
└── .project
```

---

## ⚙️ Tech Stack

| Technology | Purpose |
|---|---|
| **Java** | Core programming language |
| **Selenium WebDriver** | Browser automation |
| **TestNG** | Test execution & reporting |
| **Maven** | Build & dependency management |
| **Page Object Model** | Framework design pattern |

---

## 🔧 Prerequisites

Before running this project, make sure you have:

- ✅ Java JDK 8 or above installed
- ✅ Maven installed and configured
- ✅ Chrome/Firefox browser installed
- ✅ Eclipse or IntelliJ IDE
- ✅ Git installed

---

## 🚀 Getting Started

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/anandtomarhub-ops/testautomatioonaccelerator.git
cd testautomatioonaccelerator
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Run Tests

```bash
# Run all tests
mvn test

# Run specific test suite
mvn test -DsuiteXmlFile=testsuites/smoke.xml
```

---

## 🌿 Branching Strategy

```
master          → Stable production-ready code
├── develop     → Integration branch
├── feature/*   → New features (e.g. feature/login-tests)
├── bugfix/*    → Bug fixes
└── release/*   → Release preparation
```

---

## 📝 How to Contribute

1. Create a new branch from `master`
   ```bash
   git checkout -b feature/your-feature-name
   ```

2. Make your changes and commit
   ```bash
   git add .
   git commit -m "feat: add your meaningful message here"
   ```

3. Push your branch
   ```bash
   git push origin feature/your-feature-name
   ```

4. Raise a **Pull Request** on GitHub

---

## 📋 Commit Message Convention

Use clear and meaningful commit messages:

| Prefix | Use For |
|---|---|
| `feat:` | New feature or test case added |
| `fix:` | Bug fix |
| `refactor:` | Code improvement |
| `docs:` | Documentation update |
| `chore:` | Build/config changes |

**Example:** `feat: add login page test cases`

---

## 👨‍💻 Author

**Anand Singh Tomar**
- GitHub: [@anandtomarhub-ops](https://github.com/anandtomarhub-ops)
- Company: Cognizant

---

## 📄 License

This project is for internal use and learning purposes.

---

> ⭐ If you find this framework helpful, don't forget to **star** the repo!
