package de.datev.idv.queranw.integrationlayer.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    @Value("${de.datev.idv.queranw.integrationlayer.hello.apiurl}")
    private String appUrl;
    private final RestTemplate restTemplate;

    public SampleController(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .build();
    }

    @GetMapping("/sampleget")
    @ModelAttribute
    public String sampleGet(Model model)
    {
        String result = this.restTemplate.getForObject(appUrl,String.class);

        model.addAttribute("result",result);

        return "sampleget";
    }

    @GetMapping("/samplepost")
    public ModelAndView samplePost()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("samplepost");

        return mv;
    }
}
