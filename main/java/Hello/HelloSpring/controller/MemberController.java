package Hello.HelloSpring.controller;

import Hello.HelloSpring.domain.Member;
import Hello.HelloSpring.service.memberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller //컴포넌트 스캔
public class MemberController {
    private final memberService MemberService;

    @Autowired
    public MemberController(memberService memberService1) {
        MemberService = memberService1;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        MemberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = MemberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
