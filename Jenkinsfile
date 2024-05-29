pipeline {
    agent any

    environment {
        GIT_URL = 'https://github.com/Adilerrai/ReportGen.git'
        GIT_BRANCH = 'main'  // Mettez à jour cela si votre branche est différente
    }

    tools {
        git 'Default'  // Assurez-vous que l'outil Git par défaut est configuré
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    def gitTool = tool name: 'Default', type: 'GitTool'
                    env.GIT_HOME = "${gitTool}"
                }
                // Cloner le code du répertoire en spécifiant l'outil Git
                checkout([$class: 'GitSCM',
                          branches: [[name: "*/${env.GIT_BRANCH}"]],
                          doGenerateSubmoduleConfigurations: false,
                          extensions: [[$class: 'CleanBeforeCheckout']],
                          submoduleCfg: [],
                          userRemoteConfigs: [[url: "${env.GIT_URL}"]]
                ])
            }
        }

        stage('Build') {
            steps {
                // Construire le projet en utilisant Maven
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                // Exécuter les tests
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Emballer l'application
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                // Construire l'image Docker
                sh 'docker build -t invoice-app .'
            }
        }

        stage('Docker Push') {
            steps {
                // Pousser l'image Docker sur DockerHub
                withCredentials([usernamePassword(credentialsId: 'dockerHubCredentials', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    sh 'docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD'
                    sh 'docker push invoice-app'
                }
            }
        }

        stage('Cleanup') {
            steps {
                // Nettoyer l'espace de travail
                cleanWs()
            }
        }
    }
}
