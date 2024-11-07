# Intruder Alert

Intruder Alert is a Java-based game where players take on the roles of a burglar and a residence owner in a tense showdown within a house. The game involves moving through rooms, making choices, and engaging in fights.

## Features
- Navigate through different 7 rooms in the house.
- Both players freely roam between rooms until fight starts.
- Engage in a dynamic fight system with attack and defense mechanics.
- Both players have special skills which can be triggered each fighting turn by 25%.
- Each player's special moves are valid only for 3 turns.
- Interactive menu system with delayed text output for enhanced experience.
- ASCII art for visual enhancement during gameplay.

## Gameplay
1. **Initialization**: Players are welcomed and presented with a login menu.
2. **Room Navigation**: The burglar and the residence owner move through connected rooms.
3. **Fighting**: When both characters meet in the same room, a fight ensues.

## Classes
- **Main**: Entry point of the game, initializing the game and menu.
- **Menu**: Handles menu options and prints messages with delays.
- **Game**: Manages game initialization, room navigation, and interactions.
- **Fight**: Manages the fight mechanics between the burglar and the residence owner.
- **Entity**: Abstract class for characters, providing basic attributes and methods for combat.

## Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/meteturkan/intruder-alert.git
    ```
2. Navigate to the project directory:
    ```bash
    cd intruder-alert
    ```
3. Compile the Java files:
    ```bash
    javac -d bin src/se/meteturkan/game/*.java src/se/meteturkan/characters/*.java src/se/meteturkan/common/*.java src/se/meteturkan/fight/*.java src/se/meteturkan/rooms/*.java
    ```
4. Run the game:
    ```bash
    java -cp bin se.meteturkan.game.Main
    ```

## How to Play
- Start the game and log in.
- Navigate through the rooms by selecting options.
- Engage in fights when the burglar and residence owner meet in the same room.
- Make strategic choices to survive and win the game.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Author
Mete Turkan
