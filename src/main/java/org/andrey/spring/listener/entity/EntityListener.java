package org.andrey.spring.listener.entity;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'") // root.args[0] = p0 / a0
    @Order(1)
    public void acceptEntityRead(EntityEvent event) {
        System.out.println("Event: " + event);
    }
}
