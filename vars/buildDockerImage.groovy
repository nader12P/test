def call() {
    // Define functions and variables here
}

def getCommitHash() {
    return sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
}

def buildDockerImage(DOCKER_REGISTRY, DOCKER_IMAGE) {
    script {
        def COMMIT_HASH = getCommitHash()
        sh 'docker build -t ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER} .'
        return COMMIT_HASH
    }
}
