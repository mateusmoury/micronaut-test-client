package com.example

import io.micronaut.configuration.picocli.PicocliRunner
import jakarta.inject.Inject
import picocli.CommandLine.Command
import picocli.CommandLine.Option

@Command(
    name = "simpleclient",
    description = ["..."],
    mixinStandardHelpOptions = true,
)
class SimpleClientCommand : Runnable {
    @Inject
    lateinit var client: MyClient

    @Option(names = ["-v", "--verbose"], description = ["..."])
    private var verbose: Boolean = false

    override fun run() {
        // business logic here
        val response = client.hello("dummy")
        println(response)
    }

    companion object {
        @JvmStatic fun main(args: Array<String>) {
            PicocliRunner.run(SimpleClientCommand::class.java, *args)
        }
    }
}
