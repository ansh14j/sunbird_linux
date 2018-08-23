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
sh          apt-get update
sh apt-get install -y gettext-base
sh          echo 'deb http://dl.google.com/linux/chrome/deb/ stable main > /etc/apt/sources.list.d/chrome.list'
sh          set -x && apt-get update && apt-get install -y xvfb google-chrome-stable
sh                   mvn -B verify
            
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
