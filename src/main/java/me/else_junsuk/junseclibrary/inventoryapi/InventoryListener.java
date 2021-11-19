package me.else_junsuk.junseclibrary.inventoryapi;

import java.util.function.Consumer;

/**
 * 개발자 MinusKube님의 SmartInvAPI 입니다.
 */
public class InventoryListener<T> {

    private Class<T> type;
    private Consumer<T> consumer;

    public InventoryListener(Class<T> type, Consumer<T> consumer) {
        this.type = type;
        this.consumer = consumer;
    }

    public void accept(T t) { consumer.accept(t); }

    public Class<T> getType() { return type; }

}
