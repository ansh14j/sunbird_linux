pipeline {
    agent {
        docker {
            image 'markhobson/maven-chrome' 
            args '-v /Users/anshul/.m2:/Users/anshul/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B verify' 
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}
