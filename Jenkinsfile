pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /Users/anshul/.m2:/Users/anshul/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B verify' 
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