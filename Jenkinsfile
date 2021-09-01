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
          gv.buildApp()
        }
      }
    }
    
    stage("build image") {
      steps{
        script {
          gv.buildImg()
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