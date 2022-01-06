package Hello.HelloSpring.repository;

import Hello.HelloSpring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // 여기 class랑 interface 다른거 주목
    Member save(Member member);
    Optional<Member> findById(Long id); // 엔터치는습관(?)
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

