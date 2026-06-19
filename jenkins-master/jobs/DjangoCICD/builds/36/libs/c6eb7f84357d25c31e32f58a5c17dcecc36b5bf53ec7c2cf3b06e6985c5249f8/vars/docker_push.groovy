def call(String Project, String ImageTag, String dockerHubuser){
  withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'dockerHubpass', usernameVariable: 'dockerHubuser')]) {
      sh "docker login -u ${dockerHubuser} -p ${dockerHubpass}"
  }
  sh "docker push ${dockerHubuser}/${Project}:${ImageTag}"
}
