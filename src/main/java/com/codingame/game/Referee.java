package com.codingame.game;
import java.util.Properties;

import com.codingame.gameengine.core.AbstractReferee;
import com.codingame.gameengine.core.GameManager;
import com.codingame.gameengine.module.entities.GraphicEntityModule;
import com.google.inject.Inject;

public class Referee extends AbstractReferee {
    @Inject private GameManager<Player> gameManager;
    @Inject private GraphicEntityModule graphicEntityModule;

    @Override
    public Properties init(Properties params) {
        // Params contains all the game parameters that has been to generate this game
        // For instance, it can be a seed number, the size of a grid/map, ...  
        return params;
    }

    @Override
    public void gameTurn(int turn) {
        // Code your game logic.
        // See README.md if you want some code to bootstrap your project.
    }
}
