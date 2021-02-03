package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DebugController {
    @GetMapping("/debug")
    public String initDebugForm() {
        return "debug/debug";
    }
}
