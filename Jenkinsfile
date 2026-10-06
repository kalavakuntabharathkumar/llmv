pipeline { agent any
 stages {
  stage('Test'){steps{sh 'mvn -q test'}}
  stage('Package'){steps{sh 'mvn -q package -DskipTests'}}
  stage('Docker'){steps{sh 'docker build -t liberty-lef-validation:${BUILD_NUMBER} .'}}
 }
}
