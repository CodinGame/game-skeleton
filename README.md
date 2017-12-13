This project is the skeleton for the creation of a game using the Game Engine Toolkit of [CodinGame](https://codingame.com). Check the documentation on the [Game Engine repository](https://github.com/CodinGame/codingame-game-engine) github page.

## Note about the game turn implementation
There are 2 ways to implement your game turn according to the game you want to create. **The simultaneous mode** or the **Turn by Turn mode**.

### The simultaneous mode
It's a game mode where all players receive the game data and execute their actions in the same turn. (eg: Race, Pong, ...)

```java
for (SkeletonPlayer player : gameManager.getActivePlayers()) {
    player.sendInputLine(input);
    player.execute();
}

for (SkeletonPlayer player : gameManager.getActivePlayers()) {
    try {
        List<String> outputs = player.getOutputs();
        // Check validity of the player output and compute the new game state
    } catch (TimeoutException e) {
        player.deactivate(String.format("$%d timeout!", player.getIndex()));
    }
}

// Check if there is a win / lose situation and call gameManager.endGame(); when game is finished
```

### The Turn by Turn mode:
It's a game mode where only one player execute an action during a turn. (eg: TicTacToe, Chess)

```java
SkeletonPlayer player = gameManager.getPlayer(turn % playerCount);
player.sendInputLine(input);
player.execute();
try {
    List<String> outputs = player.getOutputs();
    // Check validity of the player output and compute the new game state
} catch (TimeoutException e) {
    player.deactivate(String.format("$%d timeout!", player.getIndex()));
    player.setScore(-1);
    gameManager.endGame();
}

// Check if there is a win / lose situation and call gameManager.endGame(); when game is finished
```

## Loading assets
Assets are expected to be placed in the `src/main/resources/view/assets` folder of your game's project.
```javascript
export const assets = {
  baseUrl: 'assets/',
  images: {
    //Each image will be added to the texture cache with the given key.
    background: 'MyBackround.jpg'
  },
  spines: {
    //Not yet implemented
  },
  sprites: [
    //Each frame of the sprite will be added to the texture cache with the key from the json.
    //see https://www.leshylabs.com/apps/sstool/
    'spriteSheet.json'
  ],
  fonts: [
    'myBitmapFont.fnt',
  ],
  others: [
    //Will launch a request for the resource, but cannot yet be used.
  ]
};
```
You can then use the images in the texture cache with the Entity Module:
```java
entityManager.createSprite.setImage("background");
```
