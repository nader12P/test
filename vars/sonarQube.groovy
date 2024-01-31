def call(SONAR_HOST, SONAR_PROJECT, SONAR_SCANNER_HOME) {
    withCredentials([string(credentialsId: sonarToken, variable: 'SONAR_TOKEN')]) {
        sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner -X -Dsonar.projectKey=${SONAR_PROJECT} -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN} -Dsonar.scm.provider=git  -Dsonar.java.binaries=build/classes" 
        sh 'rm -rf build'
    } 
}
