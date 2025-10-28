CREATE TABLE feature
(
    id            INT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255)       NULL,
    `description` VARCHAR(255)       NULL,
    type          VARCHAR(255)       NULL,
    `limit`       INT                NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE plan
(
    id              INT AUTO_INCREMENT NOT NULL,
    plan            VARCHAR(255)       NULL,
    `description`   VARCHAR(255)       NULL,
    price           DECIMAL            NULL,
    duration        DATETIME           NULL,
    is_active       BIT(1)             NOT NULL,
    subscription_id INT                NULL,
    PRIMARY KEY (id)
);

CREATE TABLE subscription
(
    id         INT AUTO_INCREMENT NOT NULL,
    user_id    INT                NOT NULL,
    plan_id    INT                NOT NULL,
    start_date DATETIME           NULL,
    end_date   DATETIME           NULL,
    statut     VARCHAR(255)       NOT NULL,
    created_at DATETIME           NULL,
    PRIMARY KEY (id)
);

CREATE TABLE `usage_table`  -- Renamed from 'usage' to avoid reserved keyword
(
    id              INT AUTO_INCREMENT NOT NULL,
    subscription_id INT                NOT NULL,
    feature_id      INT                NOT NULL,
    used_value      INT                NOT NULL,
    recorded_at     DATE               NULL,
    usage_id        INT                NULL,
    PRIMARY KEY (id)
);

CREATE TABLE feature_plan
(
    feature_id INT NOT NULL,
    plan_id    INT NOT NULL,
    PRIMARY KEY (feature_id, plan_id)
);

-- Add unique constraint
ALTER TABLE `usage_table`
    ADD CONSTRAINT uc_usage_usage UNIQUE (usage_id);

-- Add foreign key constraints in correct order
ALTER TABLE plan
    ADD CONSTRAINT FK_PLAN_ON_SUBSCRIPTION FOREIGN KEY (subscription_id) REFERENCES subscription (id);

ALTER TABLE `usage_table`
    ADD CONSTRAINT FK_USAGE_ON_FEATURE FOREIGN KEY (feature_id) REFERENCES feature (id);

ALTER TABLE `usage_table`
    ADD CONSTRAINT FK_USAGE_ON_SUBSCRIPTION FOREIGN KEY (subscription_id) REFERENCES subscription (id);

ALTER TABLE `usage_table`
    ADD CONSTRAINT FK_USAGE_ON_USAGE FOREIGN KEY (usage_id) REFERENCES feature (id);

ALTER TABLE feature_plan
    ADD CONSTRAINT fk_feapla_on_feature FOREIGN KEY (feature_id) REFERENCES feature (id);

ALTER TABLE feature_plan
    ADD CONSTRAINT fk_feapla_on_plan FOREIGN KEY (plan_id) REFERENCES plan (id);