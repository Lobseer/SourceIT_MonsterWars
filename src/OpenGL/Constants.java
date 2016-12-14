package OpenGL;

/**
 * Class description
 *
 * @author lobseer
 * @version 14.12.2016
 */

public class Constants {
    ///Размер игровой ячейки
    public static final int CELL_SIZE = 32;
    public static final int CELL_MARGIN = 2;

    ///Размеры игрового поля в ячейках
    public static final int CELLS_COUNT_X = 30;
    public static final int CELLS_COUNT_Y = 18;

    ///Константы для создания окна, названия достаточно говорящие.
    public static final int SCREEN_WIDTH = CELLS_COUNT_X * CELL_SIZE + CELL_MARGIN * (CELLS_COUNT_X+1);
    public static final int SCREEN_HEIGHT = CELLS_COUNT_Y * CELL_SIZE + CELL_MARGIN * (CELLS_COUNT_Y+1);
    public static final String SCREEN_NAME = "My Game";

    ///Шанс появления ягод на старте в процентах.
    ///При выставленном значении спавнится 3-5 ягод.
    ///Не беспокойтесь, что значение слишком низкое, как минимум одна ягода создаётся отдельно.
    public static final int INITIAL_SPAWN_CHANCE = 1;//%

    ///В нашем случае змея проходит одну клетку за один фрейм.
    ///Значение 5 мне показалось оптимальным, но вы можете экспериментировать.
    public static final int FPS = 5;
}