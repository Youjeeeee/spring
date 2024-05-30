package service;

import domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMemberRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void join() {

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외() {

        //given
        Member member1 = new Member();
        member1.setName("spring");


        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        /*
        try {
            memberService.join(member2);
            fail("예외발생해야함");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");

        }*/
    }
}
/*
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}


 */