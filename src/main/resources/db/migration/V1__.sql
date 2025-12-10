CREATE TABLE feature
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)       NULL,
    `description` VARCHAR(255)       NULL,
    type          VARCHAR(255)       NULL,
    feature_limit DOUBLE             NOT NULL,
    plan_id       INT                NULL,
    CONSTRAINT pk_feature PRIMARY KEY (id)
);

CREATE TABLE plan
(
    id            INT AUTO_INCREMENT NOT NULL,
    plan          VARCHAR(255)       NULL,
    `description` VARCHAR(255)       NULL,
    price         DECIMAL            NULL,
    CONSTRAINT pk_plan PRIMARY KEY (id)
);

CREATE TABLE subscription
(
    id         INT AUTO_INCREMENT NOT NULL,
    user_id    varchar(36)         NULL,
    start_date date               NULL,
    end_date   date               NULL,
    statut     VARCHAR(255)       NOT NULL,
    created_at date               NULL,
    plan_id    INT                NULL,
    CONSTRAINT pk_subscription PRIMARY KEY (id)
);

CREATE TABLE usage_table
(
    id              INT AUTO_INCREMENT NOT NULL,
    subscription_id INT                NOT NULL,
    used_value      INT                NOT NULL,
    recorded_at     date               NULL,
    feature_id      INT                NULL,
    CONSTRAINT pk_usage_table PRIMARY KEY (id)
);

ALTER TABLE subscription
    ADD CONSTRAINT uc_subscription_plan UNIQUE (plan_id);

ALTER TABLE usage_table
    ADD CONSTRAINT uc_usage_table_feature UNIQUE (feature_id);

ALTER TABLE feature
    ADD CONSTRAINT FK_FEATURE_ON_PLAN FOREIGN KEY (plan_id) REFERENCES plan (id);

ALTER TABLE subscription
    ADD CONSTRAINT FK_SUBSCRIPTION_ON_PLAN FOREIGN KEY (plan_id) REFERENCES plan (id);

ALTER TABLE usage_table
    ADD CONSTRAINT FK_USAGE_TABLE_ON_FEATURE FOREIGN KEY (feature_id) REFERENCES feature (id);