import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Игровой мир — гоночная трасса.
 *
 * ЗАГЛУШКА — реализацию дописывает Разработчик Б.
 *
 * Что здесь должно быть (для Б):
 *   - Загрузка спрайта трассы как фона
 *   - Расстановка Checkpoint в правильном порядке
 *   - Создание PlayerCar и BotCar в зависимости от режима
 *   - Создание RaceManager и LapTimer
 *   - Проверка пикселя трассы для offRoad (вызов car.setOffRoad())
 *
 * Пока здесь минимум для тестирования физики машин.
 */
public class RaceWorld extends World {

    // Режимы игры — константы для передачи при создании мира
    public static final int MODE_VS_BOTS    = 0; // 1 игрок vs 5 ботов
    public static final int MODE_TIME_TRIAL = 1; // на время
    public static final int MODE_TWO_PLAYER = 2; // 2 игрока на одной клавиатуре

    private int gameMode;

    // ---------------------------------------------------------------
    //  Конструктор
    // ---------------------------------------------------------------

    public RaceWorld() {
        this(MODE_VS_BOTS);
    }

    public RaceWorld(int mode) {
        // 800x600 — базовый размер, Б может поменять под трассу
        super(800, 600, 1);
        this.gameMode = mode;
        setupTestScene();
    }

    // ---------------------------------------------------------------
    //  Временная сцена для тестирования физики (Разработчик А)
    // ---------------------------------------------------------------

    private void setupTestScene() {
        setBackground("track_1.png"); // TODO: Б заменит на настоящий фон

        // Тестовый игрок — стрелки
        PlayerCar player = new PlayerCar(PlayerCar.SCHEME_ARROWS, 1);
        addObject(player, 400, 500);

        // Тестовый бот
        BotCar bot = new BotCar(BotCar.MEDIUM, 0);
        addObject(bot, 370, 500);

        // Несколько чекпоинтов для теста BotAI
        addObject(new Checkpoint(0), 400, 300);
        addObject(new Checkpoint(1), 600, 200);
        addObject(new Checkpoint(2), 600, 500);
        addObject(new Checkpoint(3), 200, 200);
    }

    // ---------------------------------------------------------------
    //  Цикл мира
    // ---------------------------------------------------------------

    @Override
    public void act() {
        // TODO (Разработчик Б): добавить проверку offRoad по цвету пикселя трассы
        // TODO (Разработчик Б): вызывать RaceManager.update() и LapTimer.update()
    }

    // ---------------------------------------------------------------
    //  Геттеры
    // ---------------------------------------------------------------

    public int getGameMode() { return gameMode; }
}
