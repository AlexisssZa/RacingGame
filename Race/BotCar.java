import greenfoot.*;

/**
 * Машина бота.
 * Управление полностью делегировано в BotAI.
 *
 * Уровень сложности влияет на точность поворотов и реакцию BotAI.
 */
public class BotCar extends Car {

    // --- Уровни сложности ---
    public static final int EASY   = 0;
    public static final int MEDIUM = 1;
    public static final int HARD   = 2;

    private final int   difficulty;
    private final BotAI ai;

    // Индивидуальный модификатор скорости (небольшой разброс между ботами)
    private final double speedMultiplier;

    // ---------------------------------------------------------------
    //  Конструктор
    // ---------------------------------------------------------------

    /**
     * @param difficulty  EASY / MEDIUM / HARD
     * @param botIndex    порядковый номер бота (0-4), влияет на спред скорости
     */
    public BotCar(int difficulty, int botIndex) {
        this.difficulty  = difficulty;
        this.ai          = new BotAI(this, difficulty);

        // Небольшой разброс скорости: боты не едут строго в ряд
        double spread = 0.04 * botIndex - 0.08; // от -0.08 до +0.08
        this.speedMultiplier = 1.0 + spread;
    }

    /** Конструктор по умолчанию для тестирования в Greenfoot-редакторе. */
    public BotCar() {
        this(MEDIUM, 0);
    }

    // ---------------------------------------------------------------
    //  Главный цикл
    // ---------------------------------------------------------------

    @Override
    public void act() {
        ai.update();           // ИИ принимает решение (вызывает accelerate/brake/turnLeft/turnRight)
        applySpeedMultiplier();
        handleCarCollisions();
        updatePhysics();
    }

    // ---------------------------------------------------------------
    //  Применение множителя скорости
    // ---------------------------------------------------------------

    private void applySpeedMultiplier() {
        // Корректируем MAX_SPEED через изменение текущей скорости
        double effectiveMax = MAX_SPEED * speedMultiplier;
        if (speed > effectiveMax) speed = effectiveMax;
    }

    // ---------------------------------------------------------------
    //  Геттеры для BotAI
    // ---------------------------------------------------------------

    public int getDifficulty()  { return difficulty; }

    /** Передаёт угол машины в AI для расчёта поворота. */
    public double getCarAngle() { return angle; }
}
