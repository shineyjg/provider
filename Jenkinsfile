pipeline {
    agent {
        docker {
            image 'maven:3.5.3'
            args '-v /Users/yangjianguang/.m2:/root/.m2'
        }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn -B -DACTIVE_PROFILE=test test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
    post {
        success {
            emailext (
                subject: "'${env.JOB_NAME} [${env.BUILD_NUMBER}]' 单元测试正常",
                body: """
                '${env.JOB_NAME} [${env.BUILD_NUMBER}]'
                ${env.BUILD_URL}
                """,
                to: "yangjianguang@zhuojianchina.com",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }   
        failure {
            emailext (
                subject: "'${env.JOB_NAME} [${env.BUILD_NUMBER}]' 单元测试失败",
                body: """
                '${env.JOB_NAME} [${env.BUILD_NUMBER}]'
                ${env.BUILD_URL}
                """,
                to: "yangjianguang@zhuojianchina.com",
                recipientProviders: [[$class: 'DevelopersRecipientProvider']]
            )
        }
    }
}
