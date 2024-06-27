package repository;


import domain.Member;

import java.util.*;

public class MemberRepositoryImp implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static Long systemId = 0L;


    @Override
    public Member svae(String name) {
        Member member = new Member();
        member.setName(name);
        member.setId(systemId++);
        store.put(member.getId(), member); // key and value
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
