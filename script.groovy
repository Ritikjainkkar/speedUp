def buildApp() {
  echo 'build the application...'
  sh 'npm install'
}

def buildImg() {
  echo 'build image the application...'
  withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t temporaryrk/demo:sp-2.0 ./build'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push temporaryrk/demo:sp-2.0'
  }
}