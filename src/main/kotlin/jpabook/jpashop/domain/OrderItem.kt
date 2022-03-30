package jpabook.jpashop.domain

import jpabook.jpashop.domain.item.Item
import jpabook.jpashop.domain.order.Order
import javax.persistence.*

@Entity
@Table(name = "ORDERITEM")
open class OrderItem (
    item: Item? = null,
    order: Order? = null,
    orderPrice:Int? = null,
    count:Int? = null
        ){

    @Id @GeneratedValue
    @Column(name = "orderitem_id")
    open var id:Long? = null

    @ManyToOne
    @JoinColumn(name = "item_id")
    open var item:Item? = item

    @ManyToOne
    @JoinColumn(name = "order_id")
    open var order:Order? = order

    open var orderPrice:Int? = orderPrice

    open var count:Int? = count
}
