package com.mygdx.game.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Pontus
 */
public class PlayerMoveTest {

    private Adlez adlez = Adlez.getInstance();
    private IPlayer player;
    private List<IEnemy> enemies;
    private List<IFriendlyNPC> friendlyNPCs;
    private List<IWorldObject> stationaryObjects;
    private List<IWall> walls;
    private List<IObstacle> obstacles;
    private List<IChest> chests;
    private List<IAreaConnection> areaConnections;
    private String name;
    private List<IManaFountain> manaFountains;

    @org.junit.Before
    public void setUp() throws Exception {
        enemies = new ArrayList<IEnemy>();
        friendlyNPCs = new ArrayList<IFriendlyNPC>();
        stationaryObjects = new ArrayList<IWorldObject>();
        walls = new ArrayList<IWall>();
        obstacles = new ArrayList<IObstacle>();
        chests = new ArrayList<IChest>();
        areaConnections = new ArrayList<IAreaConnection>();
        name = "Name";
        manaFountains = new ArrayList<IManaFountain>();

    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void moveWithoutCollision() throws Exception {
        float playerXposition = 0;
        float playerYposition = 0;

        Area area = new Area(playerXposition, playerYposition,
                enemies, friendlyNPCs, stationaryObjects, walls, obstacles, chests, areaConnections, name, manaFountains);
        // No worldobjects
        adlez.initiateArea(area);
        player = adlez.getPlayer();
        player.setSpeed(2);

        player.moveEast();
        assertTrue(player.getPosX() == player.getSpeed());
        assertTrue(player.getPosY() == 0);
        player.moveWest();
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        player.moveWest();
        assertTrue(player.getPosX() == -player.getSpeed());
        assertTrue(player.getPosY() == 0);
        player.moveSouth();
        assertTrue(player.getPosX() == -player.getSpeed());
        assertTrue(player.getPosY() == -player.getSpeed());
        player.moveNorth();
        assertTrue(player.getPosX() == -player.getSpeed());
        assertTrue(player.getPosY() == 0);
    }

    @org.junit.Test
    public void moveNorthWithCollision() throws Exception {
        float playerXposition = 0;
        float playerYposition = 0;
        float playerSpeed = 20;

        float objectSpeed = 0;
        float objectXpostion = 0;
        float objectYposition = playerSpeed - 1; // Should collide after first move to the north
        int objectWidth = 10;
        int objectHeight = 10;

        IEnemy stationaryEnemy = new Enemy(Direction.NORTH, objectSpeed,
                                       objectWidth, objectHeight,
                                       objectXpostion, objectYposition,
                                       0, 0, 0, 0, Enemy.DARK_ONE_LEVEL_ONE);
        enemies.add(stationaryEnemy);

        Area area = new Area(playerXposition, playerYposition,
                enemies, friendlyNPCs, stationaryObjects, walls, obstacles, chests, areaConnections, name, manaFountains);
        // With one stationary enemy to the north of player
        adlez.initiateArea(area);
        player = adlez.getPlayer();
        player.setSpeed(playerSpeed);

        player.moveNorth();
        // Should not have moved
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.NORTH);

        player.moveSouth();
        // Should have moved
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == -player.getSpeed());
        assertTrue(player.getDirection() == Direction.SOUTH);

        player.moveNorth();
        // Should have moved back to original position
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.NORTH);

        player.moveNorth();
        // Should not have moved again
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.NORTH);
    }

    @org.junit.Test
    public void moveWestWithCollision() throws Exception {
        float playerXposition = 0;
        float playerYposition = 0;
        float playerSpeed = 20;

        float objectSpeed = 0;
        float objectXpostion = -playerSpeed + 1; // Should collide after first move to the west
        float objectYposition = 0;
        int objectWidth = 10;
        int objectHeight = 10;

        IEnemy stationaryEnemy = new Enemy(Direction.NORTH, objectSpeed,
                objectWidth, objectHeight,
                objectXpostion, objectYposition,
                0, 0, 0, 0, Enemy.DARK_ONE_LEVEL_ONE);
        enemies.add(stationaryEnemy);

        Area area = new Area(playerXposition, playerYposition,
                enemies, friendlyNPCs, stationaryObjects, walls, obstacles, chests, areaConnections, name, manaFountains);
        // With one stationary enemy to the west of player
        adlez.initiateArea(area);
        player = adlez.getPlayer();
        player.setSpeed(playerSpeed);

        player.moveWest();
        // Should not have moved
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.WEST);

        player.moveEast();
        // Should have moved
        assertTrue(player.getPosX() == player.getSpeed());
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.EAST);

        player.moveWest();
        // Should have moved back to original position
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.WEST);

        player.moveWest();
        // Should not have moved again
        assertTrue(player.getPosX() == 0);
        assertTrue(player.getPosY() == 0);
        assertTrue(player.getDirection() == Direction.WEST);
    }
}