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

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts allowEmptyArchive: true,
                artifacts: '**/DarrensPetitions.war'
            }
        }

        stage('Deploy') {
            steps {
                script {
                       echo 'Starting deployment process...'
                       def userInput = input(
                           message: 'Do you want to deploy to Tomcat?',
                           parameters: [choice(
                               choices: 'Yes\nNo',
                               description: 'Choose Yes to deploy',
                               name: 'Deploy',
                               choiceType: 'PT_SINGLE_SELECT'
                           )]
                       )
                       if (userInput == 'Yes') {
                           echo 'Building Docker image...'
                           sh 'docker build -f Dockerfile -t darrenspetitionsapp .'

                           echo 'Removing existing Tomcat container (if any)...'
                           sh 'docker rm -f "darrenspetitionscontainer" || true'

                           echo 'Running Tomcat container...'
                           sh 'docker run --name "darrenspetitionscontainer" -p 9090:8080 --detach darrenspetitionsapp:latest'

                           echo 'Deployment completed.'
                       } else {
                           echo 'Deployment aborted.'
                       }
                   }
               }
            }
        }
    }
