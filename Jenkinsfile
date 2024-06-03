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

//         stage('Docker Build') {
//             steps {
//                 script {
//                     docker.build("my-image:latest")
//                 }
//             }
//         }
//
//         stage('Docker Push') {
//             steps {
//                 script {
//                     docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
//                         docker.image("my-image:latest").push()
//                     }
//                 }
//             }
//         }
//     }

    post {
        success {
            echo 'Build succeeded!'
        }

        failure {
            echo 'Build failed!'
        }
    }
}
