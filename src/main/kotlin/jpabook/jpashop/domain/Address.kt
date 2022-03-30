package jpabook.jpashop.domain

import javax.persistence.*

@Embeddable
open class Address(
    city:String? = null,
    street:String? = null,
    zipcode:String? = null) {

//    @Id @GeneratedValue
//    @Column(name = "address_id")
//    open var id:Long? = null
    open var city:String? = city
    open var street:String? = street
    open var zipcode:String? = zipcode
}
