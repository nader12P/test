def call(string dockerImage, dockerRegistery, buildNumber) {
    sh 'docker build -t ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER} .'
}