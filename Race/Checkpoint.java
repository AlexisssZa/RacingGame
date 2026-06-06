import greenfoot.*;

/**
 * Чекпоинт (контрольная точка) на трассе.
 *
 * ЗАГЛУШКА — реализацию дописывает Разработчик Б.
 *
 * Что здесь должно быть (для Б):
 *   - Невидимый или полупрозрачный актор
 *   - Поле order — порядковый номер в маршруте
 *   - Логика обнаружения проезда машины (пересечение с Car)
 *   - Уведомление LapTimer о прохождении
 */
public class Checkpoint extends Actor {

    private int order; // порядковый номер: 0, 1, 2, ...

    public Checkpoint() {
        this(0);
    }

    public Checkpoint(int order) {
        this.order = order;
    }

    @Override
    public void act() {
        // TODO (Разработчик Б): проверять пересечение с Car и уведомлять LapTimer
    }

    /** Возвращает порядковый номер чекпоинта. Используется BotAI для сортировки маршрута. */
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
