package service;

import domain.Member;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입

    public Long join(Member member) {
        //같은이름 금지
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent( m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체회원조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne (Long memberId) {
        return memberRepository.findById(memberId);
    }

}