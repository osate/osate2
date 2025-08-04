pipeline {
  agent any
  tools {
     jdk "OpenJDK21"
  }
  stages {
    stage('Update dependencies') {
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository', publisherStrategy: 'EXPLICIT') {
            sh 'mvn -s releng/osate.releng/seisettings.xml org.codehaus.mojo:versions-maven-plugin:use-reactor \
                -DgenerateBackupPoms=false -Dtycho.mode=maven -Dcodecoverage=true'
        }
      }
    }
    stage('Build Pull Request') {
      when {
        branch pattern: "PR-\\d+", comparator: "REGEXP"
      }
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository', publisherStrategy: 'EXPLICIT') {
          withCredentials([string(credentialsId: 'osate-ci_sonarcloud', variable: 'SONARTOKEN')]) {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
              sh 'mvn -s releng/osate.releng/seisettings.xml clean verify \
                  -Plocal -Dsonar.token=$SONARTOKEN \
                  -Dsonar.pullrequest.provider=GitHub \
                  -Dsonar.pullrequest.github.repository=$(echo $CHANGE_URL | cut -d/ -f4,5) \
                  -Dsonar.pullrequest.key=$CHANGE_ID \
                  -Dsonar.pullrequest.branch=$CHANGE_BRANCH \
                  -Dsonar.pullrequest.base=$CHANGE_TARGET \
                  -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false \
                  -Dcodecoverage=true -Dspotbugs=true -Djavadoc=false -Dpr.build=true'
            }
          }
        }
      }
    }
    stage('Build Products') {
      when {
        expression { env.GIT_BRANCH == 'origin/master' }
      }
      steps {
        withMaven(maven: 'M3', mavenLocalRepo: '.repository') {
          withCredentials([string(credentialsId: 'osate-ci_sonarcloud', variable: 'SONARTOKEN')]) {
            wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
              sh 'mvn -s releng/osate.releng/seisettings.xml clean verify \
                  -Pfull -Dsonar.token=$SONARTOKEN \
                  -Dtycho.disableP2Mirrors=true -DfailIfNoTests=false \
                  -Dcodecoverage=true -Dspotbugs=true -Djavadoc=true'
            }
          }
        }
      }
    }
    stage('Deploy') {
      when {
        expression { env.GIT_BRANCH == 'origin/master' }
      }
      steps {
        sh 'bash ./deploy.sh'
      }
    }
  }
    
  post {
    always {
      recordCoverage(tools: [[parser: 'JACOCO']], id: 'jacoco', name: 'JaCoCo Coverage')
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