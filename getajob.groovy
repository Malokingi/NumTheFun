pipelineJob('do-tests') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/Malokingi/NumTheFun')
                    }
                    branch('*/master')
                }
            }
            lightweight()
        }
    }
}