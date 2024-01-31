def call() {
    // Define functions and variables here
}

def getCommitID() {
    return sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
}

def buildDockerImage(DOCKER_IMAGE, DOCKER_REGISTRY) {
    script {
        def COMMIT_ID = getCommitID()
        sh 'docker build -t ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:COMMIT_ID .'
        return COMMIT_ID
    }
}
