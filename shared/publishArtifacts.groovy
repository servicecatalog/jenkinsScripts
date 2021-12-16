/*****************************************************************************
 *                                                                           *
 * Copyright FUJITSU LIMITED 2021                                            *
 *                                                                           *
 * Creation Date: 16-12-2021                                                 *
 *                                                                           *
 ****************************************************************************/

void execute(String PATH = '/target/surefire-reports/**/*') {

    post {
        always {
            archiveArtifacts artifacts: ${PATH}, fingerprint: true
        }
    }

}

return this