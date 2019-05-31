///vars/pipeline.groovy

def call(string k8sDeploymentName,string nameSpace){
    pipeline{
    agent any
    stages {
        stage('Git Pull'){
            steps{
                git credentialsId: 'jenkins_root', url: 'git@bitbucket.org:hxadmin/devops.git'
            }
        }
        stage('Deploy') {
            steps{
                echo "${k8sDeploymentName}"
                echo "${nameSpace}"
                sh "printenv"
            }
        }
    }
}
}