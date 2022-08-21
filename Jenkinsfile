pipeline {
    agent any

    stages {
        stage ('Compile') {
            steps {
			    echo '***************** Compile Source Code ***************'
                bat 'mvn clean package install -DskipTests'
            }
        }
        stage ('Test') {
            steps {
	            echo '****************** Run Tests  ******************'
                bat 'mvn test'
            }
        }
        stage('Build'){
            steps{
             echo '****************** Build Docker Image ****************'
             bat 'docker build -t football-service:1.0.0 --no-cache -f Dockerfile .'
            }
        }
        stage('Pre-Deploy-check') {
            steps {
                echo '****************************** remove existing ***************************************'
                script {
                   containerID = sh (returnStdout: true, script:'docker container ls --all | grep -w c_football-service | awk "{print $1}"')
                   if(containerID)
				   {
              		 bat "docker stop ${containerID}"
			   		 bat "docker rm -f ${containerID}"
			       }
			    }
			}       
        }
	    stage('Deploy'){
            steps{
			 echo '****************** Deploy Docker Image *************************'
             bat 'docker container run --name c_football-service -d -p 8080:8080 -t football-service:1.0.0'
            }
        }	
    }
}