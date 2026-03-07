pipeline {
    agent any

    tools {
        maven 'M3'
    }

    environment {
        SONAR_HOST = "http://172.20.17.143:9000"
        SONAR_TOKEN = "sqa_a9fc1bfe288514ffb91bc72dc2001cd079722bd3"
    }

    stages {
        stage('Clone') {
            steps {
                echo "Clonage du projet"
                git branch: 'master', url: 'https://github.com/alae123499/3C-SDE1-AlaeYakoubi.git'
            }
        }

        stage('Build') {
            steps {
                echo "Compilation et packaging (tests skipped)"
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo "Lancement de l’analyse SonarQube"
                sh "mvn sonar:sonar -Dmaven.test.skip=true -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN}"
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Construction de l'image Docker"
                sh 'docker build -t alae_yakoubi_3c_sde1_springapp .'
            }
        }

        stage('Run Docker Container') {
            steps {
                echo "Lancement du container Docker"
                // Stops and removes the old container if it exists to prevent port conflicts
                sh 'docker stop spring-app-container || true'
                sh 'docker rm spring-app-container || true'
                sh 'docker run -d -p 8089:8080 --name spring-app-container alae_yakoubi_3c_sde1_springapp'
            }
        }
    }

    post {
        success {
            echo "Pipeline terminé avec succès"
        }
        failure {
            echo "Pipeline échoué, vérifier les logs"
        }
    }
}
