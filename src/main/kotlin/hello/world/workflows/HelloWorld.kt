package hello.world.workflows

import io.infinitic.workflows.Workflow

interface HelloWorld : Workflow {
    fun greet(name: String?) : String
}