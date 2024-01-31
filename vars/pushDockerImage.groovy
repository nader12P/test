def call(string dockerImage, dockerRegistery, buildNumber) {
    sh "echo \${DOCKER_REGISTRY_PASSWORD} | docker login -u \${DOCKER_REGISTRY_USERNAME} --password-stdin"
    sh "docker push ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER}"
    sh "docker rmi ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER}"
}