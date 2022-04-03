package jpabook.jpashop.domain.item

import jpabook.jpashop.domain.Category
import javax.persistence.*

@Entity
@Table(name = "ITEM")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
abstract class Item (
    name:String? = null,
    price:Int? = null,
    stockQuantity:Int? = null
) {
    @Id @GeneratedValue
    @Column(name = "item_id")
    open var id:Long? = null

    open var name:String? = name

    open var price:Int? = price

    open var stockQuantity:Int? = stockQuantity

    //실무에서는 다대다는 안씀!!
    @ManyToMany(mappedBy = "items")
    open var categories:MutableList<Category> = mutableListOf()


    fun addCategory(category: Category) {
        this.categories.add(category)
        category.items.add(this)
    }






}
