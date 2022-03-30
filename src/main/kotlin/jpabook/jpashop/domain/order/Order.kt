package jpabook.jpashop.domain.order

import jpabook.jpashop.domain.Member
import jpabook.jpashop.domain.OrderItem
import jpabook.jpashop.domain.delivery.Delivery
import java.time.LocalDateTime
import java.time.ZoneId
import javax.persistence.*

@Entity
@Table(name = "ORDERS")
open class Order(
    member: Member? = null,
    delivery: Delivery? = null,
    orderDate: LocalDateTime? = LocalDateTime.now(ZoneId.of("Asia/Seoul")),
    status: OrderStatus? = null
) {

    @Id @GeneratedValue
    @Column(name = "order_id")
    open var id:Long? = null

    @ManyToOne
    @JoinColumn(name = "member_id")
    open var member:Member? = member

    @OneToMany(mappedBy = "order")
    open var orderItems:MutableList<OrderItem> = mutableListOf()

    @OneToOne
    @JoinColumn(name = "delivery_id")
    open var delivery = delivery

    open var orderDate = orderDate

    @Enumerated(EnumType.STRING)
    open var status = status // ORDER, CANCEL
}
