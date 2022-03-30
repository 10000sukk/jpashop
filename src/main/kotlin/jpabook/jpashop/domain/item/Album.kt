package jpabook.jpashop.domain.item

import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue("A")
open class Album(
    artist: String? = null,
    ect: String? = null
): Item() {
    open var artist = artist

    open var ect = ect
}
