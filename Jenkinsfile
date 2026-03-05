pipeline {
    agent any
    environment {
        SONAR_HOST = "http://localhost:9000"
        SONAR_TOKEN = "sqa_803defb1b5975175dd6bb36577da2155fe29e15e"
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/alae123499/3C-SDE1-AlaeYakoubi.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package -Dmaven.test.skip=true'
            }
        }
        stage('Sonar') {
            steps {
                sh "mvn sonar:sonar -Dmaven.test.skip=true -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN}"
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t alae123499_3c_sde1_springapp .'
            }
        }
    }
}
