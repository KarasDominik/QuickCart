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
        public static final ProductId PRODUCT_ID = ProductId.of("3c3a3015-a786-4d6b-9508-80167cf59dc5");
        public static final ProductQuantity QUANTITY = ProductQuantity.of(10);
        public static final StockLevelTestData DATA = StockLevelTestData.builder()
                .id(ID)
                .productId(PRODUCT_ID)
                .quantity(QUANTITY)
                .build();
    }

    public static final class IPHONE_14_STOCK_LEVEL {
        public static final StockLevelId ID = StockLevelId.of("aff2bdf1-f851-4ebf-9130-779e6aac8ed3");
        public static final ProductId PRODUCT_ID = ProductId.of("f6265a93-1379-4366-8679-78f86badc880");
        public static final ProductQuantity QUANTITY = ProductQuantity.of(20);
        public static final StockLevelTestData DATA = StockLevelTestData.builder()
                .id(ID)
                .productId(PRODUCT_ID)
                .quantity(QUANTITY)
                .build();
    }
}
