package hello.hello_spring.controller;

import domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.MemberService;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    MemberService memberService = new MemberService();

    @GetMapping("/join")
    public String join (){
        return "join";
    }

    @PostMapping("/create")
    public String create (String name){

        memberService.jon(name);
        return "redirect:/";

    }

    @GetMapping("/findOne/{id}")
    @ResponseBody
    public Optional<Member> findOne(@RequestParam("id") Long id){

       return memberService.findOneById(id);

    }

    @GetMapping("/findAll")
    @ResponseBody
    public List<Member> findAll(){
        return memberService.findAll();
    }

    @DeleteMapping("/delete")
    public void delete(){
        memberService.clear();
    }


}
