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
                // tm = token marco
            script{
                String failed = tm('${ROBOT_FAILED}')
                String failed = tm('${ROBOT_PASSED}')
                slackSend(channel: "#igollfs_test_noti_slack", message: "igollfs_noti_slack")
                slackSend(channel: "#igollfs_test_noti_slack", message: "igollfs_noti_slack\nPASSED " ${passed}\nFAILED:${failed}")
            }
            }
        }
    }
}
