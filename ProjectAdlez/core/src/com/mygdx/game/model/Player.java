package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Michel on 2016-04-19.
 */
public class Player extends Character implements IPlayer {
    private int experience;

    private Weapon weapon;
    private Armor armor;

    private IItem swordEquipped;
    private IItem armorEquipped;
    private boolean isWepSlotEmpty = true;
    private boolean isArmorSlotEmpty = true;
    private List<IItem> inventory;
    private static final int INVENTORY_MAX_SIZE = 16;

    // This constructor should be used.
    public Player(int direction, float speed,
                  int width, int height,
                  float posX, float posY,
                  int maxHealth, int attackDamage, int gold, int mana) {
        
        super(direction, speed, width, height, 
                posX, posY, maxHealth, attackDamage, 
                gold, mana);
        
        inventory = new ArrayList<IItem>(INVENTORY_MAX_SIZE);
    }
    
    public void equipItem(IItem item) {
        if (item instanceof Weapon) {
            if(isWepSlotEmpty) {
                isWepSlotEmpty = false;
                swordEquipped = item;
                setAttackDamage(getAttackDamage() + item.getStats());
                removeItem(item);
            }
        } else if(item instanceof Armor) {
            if(isArmorSlotEmpty) {
                isArmorSlotEmpty = false;
                armorEquipped = item;
                setMaxHealth(getMaxHealth() + item.getStats());
                removeItem(item);
            }
        }
    }

    public void unEquipWeapon(IItem item) {
        if(!isWepSlotEmpty) {
            isWepSlotEmpty = true;
            swordEquipped = null;
            setAttackDamage(getAttackDamage() - item.getStats());
            lootItem(item);
        }
    }

    public void unEquipArmor(IItem item) {
        if(!isArmorSlotEmpty) {
            isArmorSlotEmpty = true;
            armorEquipped = null;
            setMaxHealth(getMaxHealth() - item.getStats());
            lootItem(item);
        }
    }

    public void lootItem(IItem item) {
        if(inventory.size() >= INVENTORY_MAX_SIZE) {
            // Temporary print.
            System.out.println("Inventory full");
        } else {
            inventory.add(item);
        }
    }

    public List<IItem> getInventory() {
        return inventory;
    }

    public void removeItem(IItem item) {
        Iterator<IItem> itr = inventory.iterator();
        while(itr.hasNext()) {
            IItem element = itr.next();
            if(element == item) {
                itr.remove();
            }
        }
    }

    public IItem getSwordEquipped() {
        return swordEquipped;
    }

    public IItem getArmorEquipped() {
        return armorEquipped;
    }
    
    @Override
    public void onCollide(Collidable other){
        super.onCollide(other);
    }
}
