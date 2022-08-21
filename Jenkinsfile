pipeline {
    agent any
	
	tools {
        maven 'maven3'
    }

    stages {
        stage ('Compile') {
            steps {
			    echo '***************** Compile Source Code ***************'
                sh 'mvn clean package install -DskipTests'
            }
        }
        stage ('Test') {
            steps {
	            echo '****************** Run Tests  ******************'
                sh 'mvn test'
            }
        }
        stage('Build'){
            steps{
             echo '****************** Build Docker Image ****************'
             sh 'docker build -t football-service:1.0.0 --no-cache -f Dockerfile .'
            }
        }
        stage('Pre-Deploy-check') {
            steps {
                echo '****************************** remove existing ***************************************'
                script {
                   containerID = sh (returnStdout: true, script:'docker container ls --all | grep -w c_football-service | awk "{print $1}"')
                   if(containerID)
				   {
              		 sh "docker stop ${containerID}"
			   		 sh "docker rm -f ${containerID}"
			       }
			    }
			}       
        }
	    stage('Deploy'){
            steps{
			 echo '****************** Deploy Docker Image *************************'
             sh 'docker container run --name c_football-service -d -p 8080:8080 -t football-service:1.0.0'
            }
        }	
    }
}