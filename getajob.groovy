pipelineJob('do-tests-202009242020') {
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