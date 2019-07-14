package org.arunm.aws.appforfun.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SimpleController {

    @Value('${spring.application.name}')
    String appName

    @GetMapping('/')
    String homePage(Model model) {
        model.addAttribute("appName",appName)
        "home"
    }
}
