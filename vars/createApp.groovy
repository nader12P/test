def call() {
    // it's not going to work, figure it out
    openshift.withCluster('ivolve-cluster') {
        openshift.withProject('nader'){
            sh "oc delete dc,svc,deploy,ingress,route \${DOCKER_IMAGE} || true"
            sh "oc new-app ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:15"
            sh "oc expose svc/${DOCKER_IMAGE}"
        }
    }
}