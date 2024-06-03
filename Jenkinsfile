pipeline {
    agent any

    tools {
        maven 'mvn'
        jdk 'java17'
        // Make sure Docker is installed and configured in Jenkins
        docker 'docker'
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
