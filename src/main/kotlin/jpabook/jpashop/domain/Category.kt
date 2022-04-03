package jpabook.jpashop.domain

import jpabook.jpashop.domain.item.Item
import javax.persistence.*

@Entity
@Table(name = "CATEGORY")
open class Category (
    name:String? = null,
    parent:Category? = null,
        ) {

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    open var id:Long? = null

    open var name:String? = name

    @ManyToMany
    @JoinTable(
        name = "category_item",
        joinColumns = [JoinColumn(name = "category_id")],
        inverseJoinColumns = [JoinColumn(name = "item_id")]
    )
    open var items:MutableList<Item> = mutableListOf()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    open var parent:Category? = parent

    @OneToMany(mappedBy = "parent", cascade = [CascadeType.ALL])
    open var child:MutableList<Category> = mutableListOf()

    fun addItems(item: Item) {
        this.items.add(item)
        item.categories.add(this)
    }

    fun changeParent(parent: Category) {
        this.parent = parent
        parent.child.add(this)
    }

    fun addChild(child: Category) {
        this.child.add(child)
        child.parent = this
    }
}
