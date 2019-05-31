///vars/pipeline.groovy

def call(String k8sDeploymentName,String nameSpace){
    pipeline{
    agent any
        environment {
        K8S_DEPLOYMENT_NAME = "${k8sDeploymentName}"
        NAME_SPACE= "${nameSpace}"
    }
    stages {
        stage('Git Pull'){
            steps{
                git credentialsId: 'jenkins_root', url: 'git@bitbucket.org:hxadmin/devops.git'
            }
        }
        stage('Deploy') {
            steps{
                echo "${K8S_DEPLOYMENT_NAME}"
                echo "${NAME_SPACE}"
                sh "printenv"
            }
        }
    }
}
}