package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.ICharacter;

/**
 * Created by martinso on 24/03/16.
 */
public interface ICharacterController extends IController{
    
    ICharacterView getView();

    // Basic characteristics for a player
//    public void moveDirection();

//    public void attackDirection();

}
