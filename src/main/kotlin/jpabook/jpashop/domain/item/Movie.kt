package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("M")
open class Movie(
    author:String? = null,
    isbn:String? = null
): Item() {
    open var author = author
    open var isbn = isbn
}
