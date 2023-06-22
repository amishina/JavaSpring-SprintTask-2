package bitlab.techorda.springboot.Sprinttask2.controller;

import bitlab.techorda.springboot.Sprinttask2.Models.ApplicationRequest;
import bitlab.techorda.springboot.Sprinttask2.repository.AppRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AppRequestRepository appRequestRepository;

    @GetMapping(value="/")
    public String indexPage(Model model){
        List<ApplicationRequest> appRequestList = appRequestRepository.findAll();
        model.addAttribute("appRequestList",appRequestList);
        return "index";
    }

    @GetMapping(value="/new-requests")
    public String newRequests(Model model){
        List<ApplicationRequest> newRequestList = appRequestRepository.findAllByHandledEquals(false);
        model.addAttribute("newRequestList",newRequestList);
        return "new-requests";
    }

    @GetMapping(value="add-request")
    public String addRequest(Model model){
        return "add-request";
    }

    @PostMapping(value="add-request")
    public String addRequest(ApplicationRequest appRequest){
        appRequestRepository.save(appRequest);
        return "redirect:/";
    }

    @GetMapping(value="/handled-requests")
    public String handledRequests(Model model){
        List<ApplicationRequest> handledRequestList = appRequestRepository.findAllByHandledEquals(true);
        model.addAttribute("handledRequestList",handledRequestList);
        return "handled-requests";
    }

    @GetMapping(value="/details/{reqId}")
    public String requestDetails(@PathVariable(name="reqId") Long id, Model model){
        ApplicationRequest appRequest = appRequestRepository.findById(id).orElse(null);
        model.addAttribute("appRequest", appRequest);
        return "details";
    }

    @PostMapping(value="/delete-request")
    public String deleteRequest(@RequestParam(name="id") Long id){
        appRequestRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping(value="/process-request")
    public String processRequest(ApplicationRequest appRequest){
        appRequest.setHandled(true);
        appRequestRepository.save(appRequest);
        return "redirect:/";
    }

}
