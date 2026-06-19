def call(String projectName, String imageTag, String dockerUser) {

    echo "This is pushing the image to Docker Hub"

    withCredentials([usernamePassword(
        credentialsId: 'dockerHubCred',
        passwordVariable: 'dockerHubPass',
        usernameVariable: 'dockerHubUser'
    )]) {

        sh """
            docker login -u ${dockerUser} -p ${env.dockerHubPass}
            docker image tag ${projectName}:${imageTag} ${dockerUser}/${projectName}:${imageTag}
            docker push ${dockerUser}/${projectName}:${imageTag}
        """
    }
}
