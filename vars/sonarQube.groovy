def call(string sonarToken, sonarHost, sonarProject, sonarHome) {
    // this probably won't work, try to keep the withCredentials part int he jenkinsfile and see what happens
    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_TOKEN')]) {
        sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner -X -Dsonar.projectKey=${SONAR_PROJECT} -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN} -Dsonar.scm.provider=git  -Dsonar.java.binaries=build/classes" 
        sh 'rm -rf build'
    } 
}