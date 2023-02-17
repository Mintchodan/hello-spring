package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;    // assertThat 앞의 Assertions생략

class MemoryMemberRepositoryTest {

    MemoryMemberRepsitory repository = new MemoryMemberRepsitory();

    // 메서드 하나 실행이 끝날때마다 실행
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

        @Test
        public void save() {
            Member member = new Member();
            member.setName("spring");

            repository.save(member);

            Member result = repository.findById(member.getId()).get();

            // printf로 일일이 비교 X , member는 기대값 , result는 실제값  :  기대값과 실제값이 다르면 돌렸을때 error발생
            // Assertions.assertEquals(member, null);
            // System.out.println("result = " + (result == member));

            assertThat(member).isEqualTo(result);
        }

        @Test
        public void findByName() {
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            // Shift + F6으로 필요한부분 Rename 편하게 가능
            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            Member result = repository.findByName("spring1").get();

            assertThat(result).isEqualTo(member1);
        }

        @Test
        public void findAll() {
            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);

            List<Member> result = repository.findAll();

            assertThat(result.size()).isEqualTo(2);
        }
}
