pipeline {
    agent any

    tools {
        maven 'mvn'  // Assurez-vous que "mvn" correspond à l'installation Maven configurée
        jdk 'openjdk:11-jdk-slim'  // Assurez-vous que "jdk11" correspond à l'installation JDK configurée
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Adilerrai/ReportGen.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }

    post {
        success {
            echo 'Build succeeded!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
