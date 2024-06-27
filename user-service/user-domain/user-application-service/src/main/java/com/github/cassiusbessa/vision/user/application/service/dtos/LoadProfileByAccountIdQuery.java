package com.github.cassiusbessa.vision.user.application.service.dtos;

import java.util.UUID;

public class LoadProfileByAccountIdQuery {

        private final UUID id;

        public LoadProfileByAccountIdQuery(UUID id) {
            this.id = id;
        }

        public UUID getId() {
            return id;
        }
}
