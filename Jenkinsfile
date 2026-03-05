pipeline {
    agent {
        docker {
            image 'maven:3.9.4-eclipse-temurin-17'
            args '-v /root/.m2:/root/.m2' // optional: cache Maven dependencies
        }
    }
    environment {
        SONAR_HOST = "http://localhost:9000"
        SONAR_TOKEN = "sqa_830b7635e9726e44390925530889470dd1417b38"
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
                sh 'docker build -t alae_yakoubi_3c_sde1_springapp .'
            }
        }
    }
}
