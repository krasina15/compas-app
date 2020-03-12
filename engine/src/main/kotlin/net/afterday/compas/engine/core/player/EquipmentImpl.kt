package net.afterday.compas.engine.core.player

import net.afterday.compas.engine.core.inventory.items.Item

internal class EquipmentImpl() : Equipment {
    override var armor: Item? = null
        private set
    override var device: Item? = null
        private set
    override var booster: Item? = null

    /**
     * Use item to equipment
     * @return true when item used
     */
    override fun useItem(item: Item):Boolean {
        val desc = item.itemDescriptor
        when {
            desc.isArmor -> {
                armor?.isActive = false
                armor = item
            }
            desc.isDevice -> {
                device?.isActive = false
                device = item
            }
            desc.isBooster -> {
                booster?.isActive = false
                booster = item
            }
            else -> return false
        }

        item.isActive = true
        return true
    }

    override fun consumeArmor(delta: Long) {
        armor?.consume(delta)
    }

    override fun consumeBooster(delta: Long){
        booster?.consume(delta)
    }

    override fun consumeDevice(delta: Long) {
        TODO("Not yet implemented")
    }

    override val armorPercents: Double
        get() {return armor?.percentsLeft as Double}

    override val boosterPercents: Double
        get() {return booster?.percentsLeft as Double}

    override val devicePercents: Double
        get() {return device?.percentsLeft as Double}
}