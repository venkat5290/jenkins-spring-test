pipeline {
    agent any
    environment {
        imageName = "venkat7010/springboot-app"
        dockerImage = ''
        dockerImageTag = "${imageName}:${BUILD_NUMBER}"
    }

    stages {

        stage("clone the git") {
            steps {
                echo "Cloning the git"
                git branch: 'master', url: 'https://github.com/venkat5290/jenkins-spring-test'
                echo "Git cloned"
            }
        }

       stage("build and push"){
           steps {
               script {
                    echo "Building docker image..."
                    dockerImage = docker.build(imageName)
                    println "Image Created is:${dockerImage}"
                    echo "Docker Image built succesfully"
               }

           }

       }

       stage("push to registry"){
           steps {
               script {
                   withDockerRegistry(credentialsId: 'docker') {
                       println "pushing docker image to dockerhub"
                       dockerImage.push("$BUILD_NUMBER")
                       dockerImage.push('latest')
                       println "Docker Image pushed Succesfully"
                    }
               }

           }

       }

       stage("deploy To K8s"){
           steps {
               script {
                   println "Deploying to Kubernetes"
                   kubernetesDeploy(kubeconfigId: "KUBERNETES_CONFIG",configs: "spring-app.yml")
                   println "Deployment success!!"
               }

           }

       }
    }
}