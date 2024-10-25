def updateGithubStatus(state) {
    withCredentials([usernamePassword(credentialsId: 'github_dryrun_training', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh """
            curl --location 'https://api.github.com/repos/${USER}/jenkins_training/statuses/${GIT_COMMIT}' \
            --header 'Content-Type: application/json' \
            --header 'Authorization: Bearer ${PASSWORD}' \
            --data '{
                "state": "${state}",
                "context": "Dryrun",
                "description": "Jenkins",
                "target_url": "${BUILD_URL}"
            }'
        """
    }
}
return this