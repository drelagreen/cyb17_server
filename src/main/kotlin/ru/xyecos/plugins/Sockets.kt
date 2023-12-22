package ru.xyecos.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.xyecos.service.FormsNotifier
import java.time.Duration

fun Application.configureSockets() {
    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }
    routing {
        var i = 0
        get("/test") {
            FormsNotifier.notifyFormOpened(i++)
        }

        webSocket("/forms") {
            var connected = true
            val job = launch(Dispatchers.IO) {
                FormsNotifier.openedForms.collect {
                    try {
                        outgoing.send(Frame.Text(it.toList().toString()))
                    } catch (e: Throwable) {
                        println(e.localizedMessage)
                        connected = false
                    }
                }
            }
            while (connected) {
                delay(500)
            }
            job.cancel()
        }
    }
}
