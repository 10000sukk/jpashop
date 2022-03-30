package jpabook.jpashop.domain

import javax.persistence.*

@Embeddable
data class Address(
    private var city: String? = null,
    private var street: String? = null,
    private var zipcode: String? = null
)
