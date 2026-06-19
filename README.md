# 🔧 Jenkins Master-Agent Project

A Jenkins CI/CD setup using a distributed Master-Agent architecture on AWS EC2, used to automate the build and deployment of a Django application using Docker.

---

## 🏗️ Architecture

```
                    ┌─────────────────┐
                    │  Jenkins Master  │
                    │  (EC2 Instance)  │
                    │  172.31.12.22   │
                    └────────┬────────┘
                             │
                    ┌────────▼────────┐
                    │  Jenkins Agent  │
                    │  (EC2 Instance)  │
                    │  172.31.38.205  │
                    └─────────────────┘
```

---

## 📁 Repository Structure

```
jenkins-project/
├── jenkins-master/
│   ├── config.xml              # Jenkins global configuration
│   ├── fast-jenkins/           # Jenkins setup scripts
│   └── jobs/
│       ├── DjangoCICD/         # Django CI/CD pipeline job
│       │   ├── config.xml      # Job configuration
│       │   └── builds/         # Build history & logs
│       └── pipeline/           # General pipeline job
│           ├── config.xml
│           └── builds/
└── jenkins-agent/
    ├── remoting.jar            # Jenkins agent runtime
    ├── remoting/               # Agent remoting data
    └── workspace/
        └── DjangoCICD/         # Django project workspace
            ├── Dockerfile
            ├── Jenkinsfile
            ├── docker-compose.yml
            ├── requirements.txt
            └── ...
```

---

## 🚀 Projects / Jobs

### 1. DjangoCICD
A complete CI/CD pipeline for a Django Notes application.

**Pipeline Stages:**
- Clone repository from GitHub
- Build Docker image
- Push image to Docker Hub
- Deploy using Docker Compose

**Tech Stack:** Python, Django, Django REST Framework, React, Nginx, Docker

---

### 2. Pipeline
A general Jenkins pipeline job for testing and experimentation.

---

## 🛠️ Infrastructure Setup

### Jenkins Master (EC2)
- **Instance:** `ip-172-31-12-22`
- **Role:** Manages jobs, triggers builds, delegates to agent
- **Jenkins Jobs:** DjangoCICD, pipeline, Aru_first_jenkins

### Jenkins Agent (EC2)
- **Instance:** `ip-172-31-38-205`
- **Role:** Executes build jobs sent by master
- **Workspace:** Contains cloned project files and build artifacts

---

## ⚙️ How It Works

1. Code is pushed to GitHub
2. GitHub webhook triggers Jenkins Master
3. Master delegates the job to the Agent
4. Agent clones the repo, builds Docker image, and deploys

---

## 📋 Prerequisites

- AWS EC2 instances (Ubuntu)
- Java (for Jenkins)
- Docker & Docker Compose
- Jenkins installed on Master
- Jenkins agent configured on Agent EC2

---

## 👤 Author

**Arpit Prajapati**  
GitHub: [@ARPITPRAJAPATI](https://github.com/ARPITPRAJAPATI)
