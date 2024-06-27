package repository;


import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member svae(String name);
    Optional<Member> findById(Long id);
    List<Member> findAll();


}
