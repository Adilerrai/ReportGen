pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the repository
                git 'https://github.com/Adilerrai/ReportGen.git'
            }
        }

        stage('Build') {
            steps {
                // Build the project using Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Run tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Package the application
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                // Build the Docker image
                sh 'docker build -t invoice-app .'
            }
        }

        stage('Docker Push') {
            steps {
                // Push the Docker image to DockerHub
                withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    sh 'docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD'
                    sh 'docker push invoice-app'
                }
            }
        }

        stage('Cleanup') {
            steps {
                // Cleanup the workspace
                cleanWs()
            }
        }
    }
}
