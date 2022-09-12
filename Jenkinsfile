pipeline {
  agent any
  tools {
    maven 'maven_3.6.3'
  }
  
  stages {
    stage('Build') {
      parallel {
        stage('Git Checkout') {
          steps {
            git(url: 'https://github.com/student-service.git', branch: 'main', credentialsId: 'GitHub')
          }
        }

        stage('Compile') {
          steps {
            bat 'mvn clean compile'
          }
        }
      }
    }

    stage('SonarQube Analysis') {
      steps {
        withSonarQubeEnv(credentialsId: 'sonarQube_localhost', installationName: 'My SonarQube Server') {
          bat '''
              mvn install sonar:sonar ^
                -Dsonar.sonar.projectKey=student-service ^
                -Dsonar.sonar.projectName=Stundent-Registration ^
                -Dsonar.sonar.projectVersion=0.0.1-SNAPSHOT ^
                -Dsonar.sonar.sources=src ^
                -Dsonar.sonar.binaries=target/classes ^
                -Dsonar.sonar.language=Java ^
                -Dsonar.sonar.sourceEncoding=UTF-8
              '''
        }
      }
    }

    stage('Quality Gate') {
      steps {
        timeout(time: 2, unit: 'MINUTES') {
          // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
          // true = set pipeline to UNSTABLE, false = don't
          waitForQualityGate abortPipeline: true
        }
      }
    }

    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }

    stage('Report') {
      parallel {
        stage('Test Report') {
          steps {
            junit 'target/surefire-reports/TEST-*.xml'
          }
        }

        stage('Package') {
          steps {
            bat 'mvn package'
            archiveArtifacts 'target/student-service-*.jar'
          }
        }

      }
    }

    stage('Upload to Artifactory'){
      steps {
        rtUpload (
          serverId: 'jfrog-artifactory',
          spec: '''{
                "files": [
                  {
                    "pattern": "target/student-service-*.jar",
                    "target": "student-mvn-dev-local/student-service/"
                  }
              ]
          }'''
          // Optional - Associate the uploaded files with the following custom build name and build number,
          // as build artifacts.
          // If not set, the files will be associated with the default build name and build number (i.e the
          // the Jenkins job name and number).
          // buildName: 'holyFrog',
          // buildNumber: '42',
          // Optional - Only if this build is associated with a project in Artifactory, set the project key as follows.
          // project: 'my-project-key'
        )
      }
    }
  }

  post {
    failure {
      emailext body: '$DEFAULT_CONTENT', recipientProviders: [developers(), requestor()], subject: '$DEFAULT_SUBJECT'
    }
  }
}