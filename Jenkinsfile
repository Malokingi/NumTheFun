pipeline {
    agent any 
    tools {
        maven 'maven3'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building . . .' 
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing . . .'
                sh 'mvn test'
                sh 'mvn verify'
            }
        }
        //stage('Deploy') {
            //steps {
                //echo 'Deploying . . .'
                //sh kubectl apply -f Servicefile.yaml
                //sh kubectl apply -f Deploymentfile.yaml
                //sh 'mvn package'
            //}
        //}
    }
    post {
        success {
            echo 'Your deployment is ready and it built fine'
        }
        failure {
            echo 'Your deployment was unsuccessful'
        }
    }
}