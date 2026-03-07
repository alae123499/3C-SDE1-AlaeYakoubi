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
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/alae123499/3C-SDE1-AlaeYakoubi.git'
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
                sh 'docker build -t alae_yakoubi_3c_sde1_springapp .'
            }
        }
    }
}
