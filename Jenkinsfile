pipeline {
    agent any

    stages {
        stage("Hello") {
            steps {
                // รัน Robot Framework tests
                sh "python3 -m robot mytest.robot"

                // สร้างรายงานจากผลการทดสอบ Robot Framework
                robot(
                    outputPath: './',
                    outputFileName: 'output.xml',
                    reportFileName: 'report.html',
                    logFileName: 'log.html',
                    disableArchiveOutput: false,
                    passThreshold: 100.0,
                    unstableThreshold: 100.0,
                    otherFiles: '*-png,*-jpg',
                    onlyCritical: false
                )

                // ส่งข้อความไปยัง Slack (สามารถเปิดใช้งานได้เมื่อจำเป็น)
                // slackSend(channel: "#newjoin_test_noti_slack", message: "igollfs_noti_slack")
            }
        }
        
        stage('Dryrun') {
            steps {
                script {
                    // โหลดสคริปต์ common.groovy
                    common = load "common.groovy"
                    // อัปเดตสถานะ GitHub เป็น "pending"
                    common.updateGithubStatus("pending")
                    echo "test"
                }
            }
            post {
                always {
                    script {
                        // อัปเดตสถานะ GitHub ตามผลลัพธ์การสร้าง
                        if ("${currentBuild.currentResult}" == 'SUCCESS') {
                            common.updateGithubStatus("success")
                        } else {
                            common.updateGithubStatus("failure")
                        }
                    }
                }
            }
        }
    }
}
