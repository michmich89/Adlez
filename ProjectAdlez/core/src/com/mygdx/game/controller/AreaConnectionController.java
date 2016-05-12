package com.mygdx.game.controller;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.model.Adlez;
import com.mygdx.game.model.IAreaConnection;
import com.mygdx.game.view.GateView;
import java.util.List;

/**
 * Created by martinso on 11/05/16.
 */
public class AreaConnectionController implements IController {

    private GateView gateView;
    private Adlez adlez;
    private List<IAreaConnection> gates;

    public AreaConnectionController(List<IAreaConnection> gates, String gateImg) {
        adlez = Adlez.getInstance();
        this.gates = gates;
        gateView = new GateView(gateImg);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch batch) {
        gateView.generateGate(gates, batch);
    }
}