pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/.m2:/root/.m2'
    }
  }
  stages {
    stage('Build') {
      post {
        success {
          slackSend (color: '#00FF00', message: 'success: ${env.BUILD_URL}')
        }
        failure {
          slackSend (color: '#FF0000', message: 'failure: ${env.BUILD_URL}')
        }
      }
      steps {
        sh 'mvn clean package'
      }
    }
  }
}