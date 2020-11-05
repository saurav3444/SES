pipeline {
    agent any

    tools {
        maven 'Maven-3.6.3'
    }

    environment {
        JAR_FILENAME = "email-service"
        JAR_VERSION = "1.0.0"
        APP_NAME = "sapient-email"
        APP_VERSION = "1.0.0"
    }

    stages {
        stage("clean and install") {
            steps {
                sh "mvn clean install"
            }
        }
    }
    post {
        success {
            archiveArtifacts artifacts: "target/${JAR_FILENAME}-${JAR_VERSION}.jar", followSymlinks: false
        }
    }
}