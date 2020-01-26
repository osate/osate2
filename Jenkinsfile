pipeline {
  agent any
  stages {
    stage('Build Products') {
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository') {
          wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
            sh(script: '''
                mvn -T 3 -s core/osate.releng/seisettings.xml clean verify -Pfull \
                    -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false \
                    -Dcodecoverage=true -Dspotbugs=true
            ''')
          }
          withCredentials([string(credentialsId: 'osate-ci_sonarcloud', variable: 'SONARTOKEN')]) {
            sh(script: '''
                mvn -s core/osate.releng/seisettings.xml sonar:sonar \
                    -Dsonar.login=$SONARTOKEN
            ''')
          }
        }
      }
    }
    stage('Deploy') {
      steps {
        sh 'bash ./deploy.sh'
      }
    }
  }
    
  post {
    always {
      jacoco execPattern: '**/**.exec', exclusionPattern: '**/ba/**,**/tests/**,**/src-gen/**', classPattern: '**/classes', sourcePattern: '**/src', sourceInclusionPattern: '**/*.java'
      recordIssues tool: spotBugs(pattern: '**/spotbugsXml.xml', reportEncoding: 'UTF-8'), sourceCodeEncoding: 'UTF-8'
    }
    success {
      emailext (
         subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
         body: """<p>SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
          <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
      )
    }
    failure {
      emailext (
         subject: "FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
         body: """<p>FAILED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
          <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
      )
    }
    unstable {
      emailext (
         subject: "UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
         body: """<p>UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
          <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
      )
    }
    fixed {
      emailext (
         subject: "FIXED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
         body: """<p>FIXED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
          <p>Check console output at "<a href="${env.BUILD_URL}">${env.JOB_NAME} [${env.BUILD_NUMBER}]</a>"</p>""",
         recipientProviders: [[$class: 'DevelopersRecipientProvider']]
      )
    }
  } 
}