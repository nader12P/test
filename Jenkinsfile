@Library('jenkins_lib@main') _

def SONAR_PROJECT = 'spring-boot'
def SONAR_HOST = 'http://54.91.99.36:9000'

def DOCKER_IMAGE = 'spring-boot-app'
def DOCKER_REGISTERY = 'nader12bp'


pipeline {
    agent any

    environment {
        OPENSHIFT_SERVER = 'https://api.ocpuat.devopsconsulting.org:6443'
        OPENSHIFT_PROJECT = 'nader'
    }

    stages {
        // stage('Local Build') {
        //     steps {
        //         script {
        //             localBuild()
        //         }
        //     }
        // }
        // stage('Unit Test') {
        //     steps {
        //         script {
        //             unitTest()
        //         }
        //     }
        // }
        // stage('SonarQube Analysis') {
        //     steps {
        //         script {
        //                sonarQube(SONAR_HOST, SONAR_PROJECT)   
        //         }   
        //     }
        // }
        // stage('Build docker image') {
        //     steps {
        //         script {
        //             dockerize.buildDockerImage(DOCKER_IMAGE, DOCKER_REGISTERY)
        //         }
        //     }
        // }
        // stage('Push docker image') {
        //     steps {
        //         script {
        //             COMMIT_ID = dockerize.pushDockerImage(DOCKER_IMAGE, DOCKER_REGISTERY)
        //         }
        //     }
        // }
        stage('Deploy to openshift cluster') {
            steps {
                script {
                    COMMIT_ID = dockerize.getCommitID()
                    createApp(COMMIT_ID, DOCKER_IMAGE, DOCKER_REGISTERY)
                }
            }
        }
    }
}
