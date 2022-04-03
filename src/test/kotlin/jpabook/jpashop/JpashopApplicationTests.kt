package jpabook.jpashop

import jpabook.jpashop.domain.Address
import jpabook.jpashop.domain.delivery.Delivery
import jpabook.jpashop.domain.order.Order
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class JpashopApplicationTests {

	@Test
	fun contextLoads() {
		var delivery = Delivery()
		var order = Order()
		delivery.changeOrder(order)
	}

}
