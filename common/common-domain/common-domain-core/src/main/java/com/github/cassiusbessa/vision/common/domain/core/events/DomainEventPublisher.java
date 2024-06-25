package com.github.cassiusbessa.vision.common.domain.core.events;

public interface DomainEventPublisher<T extends DomainEvent> {

    void publish(T domainEvent);
}
