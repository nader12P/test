def call(COMMIT_ID, DOCKER_IMAGE) {
    withCredentials([file(credentialsId: 'openshift', variable: 'OPENSHIFT_SECRET')]) {
        sh "oc project \${OPENSHIFT_PROJECT} --kubeconfig=$OPENSHIFT_SECRET"
        sh "oc delete dc,svc,deploy,ingress,route ${DOCKER_IMAGE} --kubeconfig=$OPENSHIFT_SECRET|| true"
        sh "oc new-app ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:20c9802 --kubeconfig=$OPENSHIFT_SECRET"
        sh "oc expose svc/${DOCKER_IMAGE} --kubeconfig=$OPENSHIFT_SECRET"
    }
}
