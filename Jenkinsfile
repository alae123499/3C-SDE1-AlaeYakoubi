pipeline {
    agent any
    tools {
        maven 'M3'
    }
    environment {
        SONAR_HOST = "http://localhost:9000"
        SONAR_TOKEN = "sqa_7e5c1aaf8332dccd2d14eb7c339924e879b5c0cc"
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
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "mvn sonar:sonar -Dmaven.test.skip=true -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN}"
                }
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t alae_yakoubi_3c_sde1_springapp .'
            }
        }
    }
}
