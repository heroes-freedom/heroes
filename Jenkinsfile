pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v $HOME/.m2:/root/.m2'
    }

  }
  stages {
    stage('Build') {
      steps {
        slackSend color: 'good', message: 'Slack Message'
        sh 'mvn clean package'
      }
    }
  }
}