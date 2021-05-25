import com.sap.gateway.ip.core.customdev.processor.MessageImpl
import com.sap.gateway.ip.core.customdev.util.Message
import org.junit.jupiter.api.Test

class GroovyJsonTest {

    @Test
    void testJson() {
        // Load Groovy Script
        GroovyShell shell = new GroovyShell()
        def script = shell.parse(new File("./src/GroovyJson.groovy"))

        // Initialize message with body, header and property
        Message msg = new MessageImpl()

        // Execute script
        script.processData(msg)

        // Display results of script in console
        println("Body:\r\n" + msg.getBody())

    }
}
