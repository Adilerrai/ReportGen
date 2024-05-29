pipeline {
    agent any

    tools {
        maven 'mvn'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Adilerrai/ReportGen.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean'

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
