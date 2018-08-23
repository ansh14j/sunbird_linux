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
sh # Modify the commands below to build your repository.
sh          - apt-get update; apt-get install -y gettext-base;
sh          - echo 'deb http://dl.google.com/linux/chrome/deb/ stable main' > /etc/apt/sources.list.d/chrome.list
sh          - wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -
sh          - set -x && apt-get update && apt-get install -y xvfb google-chrome-stable
sh          - wget -q -O /usr/bin/xvfb-chrome https://bitbucket.org/atlassian/docker-node-chrome-firefox/raw/ff180e2f16ea8639d4ca4a3abb0017ee23c2836c/scripts/xvfb-chrome
sh          - ln -sf /usr/bin/xvfb-chrome /usr/bin/google-chrome
sh          - chmod 755 /usr/bin/google-chrome
sh          - mvn -B verify # -B batch mode makes Maven less verbose
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
