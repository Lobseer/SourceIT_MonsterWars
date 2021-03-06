package api.service;

import impl.service.Sprite;

/**
 * Class description
 *
 * @author lobseer
 * @version 14.12.2016
 */

public interface GUIElement {

    int getWidth();

    int getHeight();

    int getRenderX();

    int getRenderY();

    Sprite getSprite(); ///Создадим enum с таким именем, заполним позже

    default String getParams() {
        return null;
    }

    void receiveClick(); /// Возвращаем результат клика
    //Параметр button определяет кнопку мыши, которой был сделан щелчок.

    // Здесь используется фишка Java 8 --- default методы в интерфейсах.
    // Если у вас более ранняя версия, вы можете использовать абстрактный класс
    // вместо интерфейса.
    default boolean isHit(int xclick, int yclick){
        return ( (xclick > getRenderX()) && (xclick < getRenderX()+this.getWidth()) )
                &&( (yclick > getRenderY()) && (yclick < getRenderY()+this.getHeight()) );
    }
}