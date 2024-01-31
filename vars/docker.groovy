def call() {
    
}

def getCommitID() {
    return sh(script: 'git rev-parse --short HEAD', returnStdout: true).trim()
}

def buildDockerImage(DOCKER_IMAGE, DOCKER_REGISTRY, COMMIT_ID) {
    script {
        sh 'docker build -t ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${COMMIT_ID} .'
        return COMMIT_ID
    }
}
