@Library('jenkins_lib@main') _

// def SONAR_SCANNER_HOME = tool "sonarqube"
// def SONAR_PROJECT = 'spring-boot'
// def SONAR_HOST = 'http://52.87.152.139:9000'

pipeline {
    agent any

    environment {
        DOCKER_IMAGE = 'spring-boot-app'
        DOCKER_REGISTERY = 'nader12bp'
        OPENSHIFT_SERVER = 'https://api.ocpuat.devopsconsulting.org:6443'
        OPENSHIFT_PROJECT = 'nader'
        APP_SERVICE_NAME = 'spring-boot-app'
        APP_PORT = '8080'
        APP_HOST_NAME = 'spring-boot-app.apps.ocpuat.devopsconsulting.org'
    }

    stages {
        stage('Local Build') {
            steps {
                script {
                    localBuild()
                }
            }
        }
        stage('Unit Test') {
            steps {
                script {
                    unitTest()
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                script {
                    sonarQube()         
                }   
            }
        }
        // stage('Build docker image') {
        //     steps {
        //         script {
        //             buildDockerImage()
        //         }
        //     }
        // }
        // stage('Push docker image') {
        //     steps {
        //         withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'DOCKER_REGISTRY_USERNAME', passwordVariable: 'DOCKER_REGISTRY_PASSWORD')]) {
        //             pushDockerImage()
        //         }
        //     }
        // }
        // stage('Deploy to openshift cluster') {
        //     steps {
        //         script {
        //             createApp()
        //         }
        //     }
        // }
    }
}
