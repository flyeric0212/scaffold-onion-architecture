CREATE TABLE IF NOT EXISTS `product` (
    `id`      VARCHAR(32) NOT NULL COMMENT '商品ID',
    `name`    VARCHAR(100) NOT NULL COMMENT '商品名称',
    `desc`    VARCHAR(512) NULL COMMENT '商品描述',
    `price`   DECIMAL(10,2) NOT NULL COMMENT '商品价格',
    `create_time`      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci;

INSERT INTO `product` VALUES ('1', 'iphone 12 pro max', 'apple iphone', 9600.00, now(), now());
INSERT INTO `product` VALUES ('2', 'ipad pro 11', 'apple ipad', 6500.00, now(), now());