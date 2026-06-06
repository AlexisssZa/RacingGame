import greenfoot.*;

/**
 * Машина игрока.
 *
 * Поддерживает два режима управления:
 *   - SCHEME_ARROWS : стрелки + клавиши Down/Up для газа/тормоза  (Игрок 1)
 *   - SCHEME_WASD   : W/A/S/D                                      (Игрок 2, режим 2P)
 */
public class PlayerCar extends Car {

    // --- Константы схем управления ---
    public static final int SCHEME_ARROWS = 0;
    public static final int SCHEME_WASD   = 1;

    private final int controlScheme;

    // --- Отображение HUD ---
    private int playerNumber; // 1 или 2 (для отображения в RaceWorld)

    // ---------------------------------------------------------------
    //  Конструкторы
    // ---------------------------------------------------------------

    /**
     * Создаёт машину игрока со стрелками (по умолчанию — одиночная игра).
     */
    public PlayerCar() {
        this(SCHEME_ARROWS, 1);
    }

    /**
     * Создаёт машину игрока с заданной схемой управления.
     *
     * @param scheme       SCHEME_ARROWS или SCHEME_WASD
     * @param playerNumber 1 или 2
     */
    public PlayerCar(int scheme, int playerNumber) {
        this.controlScheme = scheme;
        this.playerNumber  = playerNumber;
    }

    // ---------------------------------------------------------------
    //  Главный цикл
    // ---------------------------------------------------------------

    @Override
    public void act() {
        readInput();
        handleCarCollisions();
        updatePhysics();
    }

    // ---------------------------------------------------------------
    //  Ввод
    // ---------------------------------------------------------------

    private void readInput() {
        if (controlScheme == SCHEME_ARROWS) {
            if (Greenfoot.isKeyDown("up"))    accelerate();
            if (Greenfoot.isKeyDown("down"))  brake();
            if (Greenfoot.isKeyDown("left"))  turnLeft();
            if (Greenfoot.isKeyDown("right")) turnRight();
        } else {
            // WASD
            if (Greenfoot.isKeyDown("w")) accelerate();
            if (Greenfoot.isKeyDown("s")) brake();
            if (Greenfoot.isKeyDown("a")) turnLeft();
            if (Greenfoot.isKeyDown("d")) turnRight();
        }
    }

    // ---------------------------------------------------------------
    //  Геттеры
    // ---------------------------------------------------------------

    public int getPlayerNumber() { return playerNumber; }
    public int getControlScheme(){ return controlScheme; }
}
