def gv

pipeline {
  agent any
  stages {
    stage("init") {
      steps {
        script {
         gv = load "script.groovy" 
        }
      }
    }

    stage("build") {
      steps{
        script {
          echo 'build the application...'
          sh 'npm install'
        }
      }
    }
    
    stage("build image") {
      steps{
        script {
          echo 'build image the application...  '
          withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            sh 'docker build -t temporaryrk/demo:sp-4.0 .'
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh 'docker push temporaryrk/demo:sp-4.0'
          }
        }
      }
    }
    
    stage("deploy") {
      steps{
        script {
          def dockerCMD = "docker run -p 3080:3080 -d temporaryrk/demo:sp-4.0"
          sshagent(['aws-avinash']) {
            sh "ssh -o StrictHostKeyChecking=no ubuntu@18.223.195.108 ${dockerCMD}"
          }
        }
      }
    }
    
  }
}