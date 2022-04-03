package jpabook.jpashop.domain



import jpabook.jpashop.domain.order.Order
import javax.persistence.*

@Entity
@Table(name = "MEMBER")
open class Member(
    name:String? = null,
    address: Address? = null
        ) {
    @Id @GeneratedValue
    @Column(name = "member_id")
    open var id:Long? = null

    open var name:String? = name

    @Embedded
    open var address:Address? = address

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL])
    open var orders:MutableList<Order> = mutableListOf()

    fun addOrders(order: Order) {
        this.orders.add(order)
        order.member = this
    }

}
