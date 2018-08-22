pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
        docker {
            image 'selenium/node-chrome:3.14.0-arsenic'
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}