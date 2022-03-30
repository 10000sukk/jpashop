package jpabook.jpashop.domain.delivery

import jpabook.jpashop.domain.Address
import jpabook.jpashop.domain.order.Order
import javax.persistence.*

@Entity
@Table(name = "DELIVERY")
open class Delivery (
    order: Order? = null,
    address: Address? = null,
    status: DeliveryStatus? = null
) {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    open var id:Long? = null

    @OneToOne(mappedBy = "delivery")
    open var order:Order? = order

    @Embedded
    open var address:Address? = address

    @Enumerated(EnumType.STRING)
    open var status:DeliveryStatus? = status // READY, COMP
}
