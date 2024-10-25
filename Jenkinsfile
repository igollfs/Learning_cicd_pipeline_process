pipeline{
    agent any
    stages{
        stage("Hello"){
            steps{
                sh "python3 -m robot mytest.robot"
                robot (
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
            }
        }
    }
}