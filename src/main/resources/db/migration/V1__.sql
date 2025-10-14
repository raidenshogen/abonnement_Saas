CREATE TABLE feature
(
    id           INT AUTO_INCREMENT NOT NULL,
    name         VARCHAR(255) NULL, `
    description` VARCHAR(255) NULL,
    type         VARCHAR(255) NULL, `
    limit`       INT          NOT NULL,
    CONSTRAINT pk_feature PRIMARY KEY (id)
);

CREATE TABLE feature_plan
(
    feature_id INT NOT NULL,
    plan_id    INT NOT NULL
);

CREATE TABLE plan
(
    id              INT AUTO_INCREMENT NOT NULL,
    plan            VARCHAR(255) NULL, `
    description`    VARCHAR(255) NULL,
    price           DECIMAL      NULL,
    duration        datetime     NULL,
    is_active       BIT(1)             NOT NULL,
    subscription_id INT          NULL,
    CONSTRAINT pk_plan PRIMARY KEY (id)
);

CREATE TABLE subscription
(
    id         INT AUTO_INCREMENT NOT NULL,
    user_id    INT          NOT NULL,
    plan_id    INT          NOT NULL,
    start_date datetime     NULL,
    end_date   datetime     NULL,
    statut     VARCHAR(255) NULL,
    created_at datetime     NULL,
    CONSTRAINT pk_subscription PRIMARY KEY (id)
);

CREATE TABLE ` usage`
(
    id              INT AUTO_INCREMENT NOT NULL,
    subscription_id INT  NOT NULL,
    feature_id      INT  NOT NULL,
    used_value      INT  NOT NULL,
    recorded_at     date NULL,
    usage_id        INT  NULL,
    CONSTRAINT pk_usage PRIMARY KEY (id)
);

ALTER TABLE ` usage`
    ADD CONSTRAINT uc_usage_usage UNIQUE (usage_id);

ALTER TABLE plan
    ADD CONSTRAINT FK_PLAN_ON_SUBSCRIPTION FOREIGN KEY (subscription_id) REFERENCES subscription (id);

ALTER TABLE ` usage`
    ADD CONSTRAINT FK_USAGE_ON_USAGE FOREIGN KEY (usage_id) REFERENCES feature (id);

ALTER TABLE feature_plan
    ADD CONSTRAINT fk_feapla_on_feature FOREIGN KEY (plan_id) REFERENCES feature (id);

ALTER TABLE feature_plan
    ADD CONSTRAINT fk_feapla_on_plan FOREIGN KEY (feature_id) REFERENCES plan (id);