def updateGithubStatus(state) {
    withCredentials([usernamePassword(credentialsId: 'igollfs_cicd_pipeline', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh """
            curl --location 'https://api.github.com/repos/igollfs/Learning_cicd_pipeline_process/statuses/${GIT_COMMIT}' \
            --header 'Content-Type: application/json' \
            --header 'Authorization: Bearer ${PASSWORD}' \
            --data '{"state": "${state}","context": "Dryrun","description": "Jenkins","target_url": "${BUILD_URL}"}'
        """
    }
}
return this