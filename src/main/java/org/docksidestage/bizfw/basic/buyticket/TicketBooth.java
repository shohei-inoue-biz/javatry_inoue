/*
 * Copyright 2019-2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds; // null allowed: until first purchase

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    // you can rewrite comments for your own language by jflute
    // e.g. Japanese
    // /**
    // * 1Dayパスポートを買う、パークゲスト用のメソッド。
    // * @param handedMoney パークゲストから手渡しされたお金(金額) (NotNull, NotMinus)
    // * @throws TicketSoldOutException ブース内のチケットが売り切れだったら
    // * @throws TicketShortMoneyException 買うのに金額が足りなかったら
    // */
    /**
     * Buy one-day passport, method for park guest.
     * @param handedMoney The money (amount) handed over from park guest. (NotNull, NotMinus)
     * @throws TicketSoldOutException When ticket in booth is sold out.
     * @throws TicketShortMoneyException When the specified money is short for purchase.
     */
    public void buyOneDayPassport(Integer handedMoney) {
        validatePurchase(handedMoney, ONE_DAY_PRICE);
        sellPassport(ONE_DAY_PRICE);
    }

    // TODO inoue twoDayにもJavaDocコメントをお願いします (日本語でOK) by jflute (2026/10/06)
    public int buyTwoDayPassport(Integer handedMoney) {
        validatePurchase(handedMoney, TWO_DAY_PRICE);
        sellPassport(TWO_DAY_PRICE);

        return handedMoney - TWO_DAY_PRICE;
    }

    private void validatePurchase(Integer handedMoney, Integer dayPrice) {
        // #1on1: $checkが納得いかない (2026/10/06) 
        // $validationの枠組みなのか？DDDの感覚だと...
        // 業務的なニュアンスで言うと、手渡し金額のチェック、在庫のチェック、と自然。
        // checkはちょっと曖昧な言葉で、具体的にどうチェックしてるか？が表現されない。
        // 表現したくないときはフィットする言葉。
        // もうちょい直接的な表現をしたいとなったら...
        // e.g. assertHandedMoneyEnough();
        //
        // 逆に、checkHandedMoneyShort(); とかは、どっちだと例外が発生する？がわかりにくくて、
        // 避ける傾向にある。(直接的な表現をしようとしてるのに、どっちが正しい業務か曖昧になる)
        //
        // あと、業務的な意味合いで言うと...
        // checkHandedMoney()は単なる入力チェック。 // validateイメージ
        // checkQuantity()はシステム内部の状態のチェック。 // コア処理のイメージ
        //  → ただ、validateでも両方やることはある。
        //
        checkHandedMoney(handedMoney, dayPrice);
        checkQuantity();
    }
    // #1on1: $他の人たちってjavatryってどういう風に進めてるのかな？ (2026/10/06)
    // step1,2,3,4は基礎、個性は5から。

    private void checkHandedMoney(Integer handedMoney, Integer dayPrice) {
        if (handedMoney == null) {
            throw new IllegalArgumentException("handedMoney is required");
        }
        if (handedMoney < dayPrice) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
    }

    private void checkQuantity() {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
    }

    private void sellPassport(Integer dayPrice) {
        addSalesProceeds(dayPrice);
        --quantity;
    }

    private void addSalesProceeds(Integer dayPrice) {
        if (salesProceeds != null) {
            salesProceeds += dayPrice;
        } else {
            salesProceeds = dayPrice;
        }
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
}
