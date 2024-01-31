pipeline {
    agent any

    environment {
        SONAR_SCANNER_HOME = tool "sonarqube"
        SONAR_PROJECT = 'spring-boot'
        SONAR_HOST = 'http://54.91.99.36:9000'
        DOCKER_IMAGE = 'spring-boot-app'
        DOCKER_REGISTERY = 'nader12bp'
        OPENSHIFT_SERVER = 'https://api.ocpuat.devopsconsulting.org:6443'
        OPENSHIFT_PROJECT = 'nader'
        APP_SERVICE_NAME = 'spring-boot-app'
        APP_PORT = '8080'
        APP_HOST_NAME = 'spring-boot-app.apps.ocpuat.devopsconsulting.org'
    }

    stages {
        stage('Build and unit test') {
            steps {
                script {
                    sh 'chmod 777 ./gradlew'
                    sh './gradlew dependencies'
                    sh './gradlew build --stacktrace'
                    sh './gradlew test'
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    // Run SonarQube analysis
                    withCredentials([string(credentialsId: 'sonartoken', variable: 'SONAR_TOKEN')]) {
                        sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner -X -Dsonar.projectKey=${SONAR_PROJECT} -Dsonar.host.url=${SONAR_HOST} -Dsonar.login=${SONAR_TOKEN} -Dsonar.scm.provider=git  -Dsonar.java.binaries=build/classes" 
                    }                
                }   
            }
        }
        stage('Build docker image') {
            steps {
                script {
                    sh 'docker build -t ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER} .'
                }
            }
        }
        stage('Push docker image') {
            steps {
                 withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_REGISTRY_USERNAME', passwordVariable: 'DOCKER_REGISTRY_PASSWORD')]) {
                    
                    sh "echo \${DOCKER_REGISTRY_PASSWORD} | docker login -u \${DOCKER_REGISTRY_USERNAME} --password-stdin"
                    sh "docker push ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER}"
                    sh "docker rmi ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:${BUILD_NUMBER}"
                }
            }
        }
        stage('Deploy to openshift cluster') {
            steps {
                script {
                    openshift.withCluster('ivolve-cluster') {
                        openshift.withProject('nader'){
                            sh "oc delete dc,svc,deploy,ingress,route \${DOCKER_IMAGE} || true"
                            sh "oc new-app ${DOCKER_REGISTERY}/${DOCKER_IMAGE}:15"
                            sh "oc expose svc/${DOCKER_IMAGE}"
                        }
                    }
                }
            }
        }
    }
}
