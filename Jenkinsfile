pipeline {
  agent any
  
  stages {
    stage("build") {
      
      steps{
        echo 'build the application...'
        sh 'npm install'
      }
    }
    
    stage("build image") {
      
      steps{
        echo 'build image the application...'
        withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
          sh 'docker build -t temporaryrk/demo:sp-2.0 .'
          sh "echo $PASS | docker login -u $USER --password-stdin"
          sh 'docker push temporaryrk/demo:sp-2.0'
        }
      }
    }
    
    stage("deploy") {
      
      steps{
        echo 'deploying the application...'
      }
    }
    
  }
}