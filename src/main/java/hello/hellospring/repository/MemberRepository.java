package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);     // Optional은 가져올때 없으면 null반환

    Optional<Member> findByName(String name);
    List<Member> findAll();
}
