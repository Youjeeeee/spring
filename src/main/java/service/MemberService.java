package service;

import domain.Member;
import org.springframework.stereotype.Service;
import repository.MemberRepositoryImp;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepositoryImp memberRepositoryImp = new MemberRepositoryImp();

    public void jon (String name){
        memberRepositoryImp.svae(name);
    }

    public Optional<Member> findOneById (Long id){
        return memberRepositoryImp.findById(id);
    }

    public List<Member> findAll(){
        return memberRepositoryImp.findAll();
    }

    public void clear(){
        memberRepositoryImp.clearStore();
    }


}
