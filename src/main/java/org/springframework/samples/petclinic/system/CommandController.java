package org.springframework.samples.petclinic.system;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/rest")
public class CommandController {
    @PostMapping("/execute")
    public String runCommand4Debug(@RequestParam String cmd) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(new String[] {"sh", "-c", "ps " + cmd});
        int result = proc.waitFor();
        if (result != 0) {
            System.out.println("process error: " + result);
        }
        InputStream in = (result == 0) ? proc.getInputStream() :
            proc.getErrorStream();
        int c;
        Command command = new Command();
        while ((c = in.read()) != -1) {
            command.setResult((char) c);
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(command);
    }
}
