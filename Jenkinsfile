pipeline {
  agent any
  tools {
     jdk "OpenJDK17"
  }
  stages {
    stage('Update dependencies') {
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository', publisherStrategy: 'EXPLICIT') {
            sh 'mvn -s core/osate.releng/seisettings.xml org.codehaus.mojo:versions-maven-plugin:use-reactor \
                -DgenerateBackupPoms=false -Dtycho.mode=maven'
        }
      }
    }
    stage('Build Pull Request') {
      when {
        branch pattern: "PR-\\d+", comparator: "REGEXP"
      }
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository', publisherStrategy: 'EXPLICIT') {
          wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
            sh 'mvn -T 3 -s core/osate.releng/seisettings.xml clean verify -Plocal \
                -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false \
                -Dcodecoverage=true -Dspotbugs=true -Djavadoc=false -Dpr.build=true'
          }
        }
      }
    }
    stage('Build Products') {
      when {
        branch 'master'
      }
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository') {
          withCredentials([string(credentialsId: 'osate-ci_sonarcloud', variable: 'SONARTOKEN')]) {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
              sh 'mvn -s core/osate.releng/seisettings.xml clean verify sonar:sonar \
                  -Pfull -Dsonar.login=$SONARTOKEN \
                  -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false \
                  -Dcodecoverage=true -Dspotbugs=true -Djavadoc=true'
            }
          }
        }
      }
    }
    stage('Deploy') {
      when {
        branch 'master'
      }
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