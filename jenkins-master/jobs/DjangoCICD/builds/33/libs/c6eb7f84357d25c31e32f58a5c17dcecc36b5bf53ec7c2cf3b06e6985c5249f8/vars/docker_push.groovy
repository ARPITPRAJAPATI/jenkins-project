def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubpass', usernameVariable: 'dockerHubuser')]) {
      sh "docker login -u ${dockerHubuser} -p ${dockerHubpass}"
  }
  sh "docker push ${dockerHubuser}/${Project}:${ImageTag}"
}
