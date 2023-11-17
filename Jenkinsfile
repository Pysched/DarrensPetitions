pipeline {
    agent any

    stages {
        stage('Get Project') {
            steps {
                git 'https://github.com/Pysched/DarrensPetitions'
            }
        }

         stage('Build') {
            steps {
                sh 'mvn clean:clean'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}