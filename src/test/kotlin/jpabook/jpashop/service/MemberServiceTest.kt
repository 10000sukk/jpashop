package jpabook.jpashop.service

import jpabook.jpashop.domain.Member
import jpabook.jpashop.repository.MemberRepository
import org.hamcrest.MatcherAssert.assertThat

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalStateException
import javax.persistence.EntityManager

@ExtendWith(SpringExtension::class)
@SpringBootTest
@Transactional
internal class MemberServiceTest {

    @Autowired lateinit var memberService: MemberService
    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var  em: EntityManager

    @Test
    fun 회원가입() {
        //given
        val member = Member();
        member.name = "kim"

        //when
        val saveId = memberService.join(member)
        //em.flush()

        //then
        assertEquals(member, memberRepository.findOne(saveId))
    }

    @Test
    fun 중복_회원_예외(){
        //given
        val member1 = Member()
        member1.name = "kim"

        val member2 = Member()
        member2.name = "kim"


        //when
        memberService.join(member1)

        //then
        assertThrows(IllegalStateException::class.java) {
            memberService.join(member2)
        }
    }
}
