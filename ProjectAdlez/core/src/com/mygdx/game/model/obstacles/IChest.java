package com.mygdx.game.model.obstacles;

import com.mygdx.game.model.characters.items.IItem;
import com.mygdx.game.model.core.IWorldObject;
import com.mygdx.game.model.exceptions.InventoryFullException;
import com.mygdx.game.model.obstacles.IStationaryObject;

import java.util.List;

/**
 * Created by Pontus on 2016-04-29.
 */
public interface IChest extends IWorldObject, IStationaryObject {
    void addItem(IItem type) throws InventoryFullException;
    List<IItem> getItems();
    boolean isEmpty();
    int getSize();
    boolean isFull();
    void removeItem(IItem item);
    boolean isOpened();
    void setIsOpened(boolean isOpened);
}
