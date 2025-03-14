package com.karasdominik.QuickCart.inventory.domain;

import com.karasdominik.QuickCart.common.dto.ProductId;
import com.karasdominik.QuickCart.inventory.domain.dto.StockLevelId;
import com.karasdominik.QuickCart.inventory.domain.dto.StockLevelTestData;
import com.karasdominik.QuickCart.inventory.domain.valueobjects.ProductQuantity;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class StockLevelsForTests {

    public static final class IPHONE_15_STOCK_LEVEL {
        public static final StockLevelId ID = StockLevelId.of("51841cc9-8d7b-471f-a0dd-0ead299d969c");
        public static final ProductId PRODUCT_ID = ProductId.of("a0b2f5b3-4b4b-4e4b-8b4b-4b4b4b4b4b4b");
        public static final ProductQuantity QUANTITY = ProductQuantity.of(10);
        public static final StockLevelTestData DATA = StockLevelTestData.builder()
                .id(ID)
                .productId(PRODUCT_ID)
                .quantity(QUANTITY)
                .build();
    }

    public static final class IPHONE_14_STOCK_LEVEL {
        public static final StockLevelId ID = StockLevelId.of("12345abc-de67-890f-gh12-345678ijkl90");
        public static final ProductId PRODUCT_ID = ProductId.of("b1c2d3e4-f5g6-h7i8-j9k0-l1m2n3o4p5q6");
        public static final ProductQuantity QUANTITY = ProductQuantity.of(20);
        public static final StockLevelTestData DATA = StockLevelTestData.builder()
                .id(ID)
                .productId(PRODUCT_ID)
                .quantity(QUANTITY)
                .build();
    }
}
