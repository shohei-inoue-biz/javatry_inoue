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
public abstract class Ticket {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // TODO done inoue countOfDays, 相対的にはほぼ問題ないけど、単体で見ると、max or 残り日数なのかが曖昧になる by jflute (2026/10/22)
    // 有効日数だからvalidDaysが自然かな
    private final int displayPrice; // written on ticket, park guest can watch this
    private final int validDays; // available days for park guest, e.g. 1 or 2
    private int usedDays; // used days, unavailable when reaching validDays

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Ticket(int displayPrice, int validDays) {
        this.displayPrice = displayPrice;
        this.validDays = validDays;
    }

    // ===================================================================================
    //                                                                             In Park
    //                                                                             =======
    /**
     * Do in-park as daytime (default: isNight = false).
     */
    public void doInPark() {
        doInPark(false);
    }

    /**
     * Do in-park specifying whether it is night or daytime.
     * @param isNight Whether it is nighttime in-park or not.
     */
    public void doInPark(boolean isNight) {
        if (isAlreadyIn()) {
            throw new IllegalStateException("Already in park by this ticket: displayedPrice=" + displayPrice);
        }
        // チケット固有の条件（夜限定など）をサブクラスで判定
        assertSpecialCondition(isNight);

        usedDays++;
    }

    /**
     * Assert special in-park condition specific to the ticket (implemented by subclass).
     * @param isNight Whether it is nightTime in-park or not.
     * @throws IllegalStateException When the condition is not satisfied.
     */
    protected abstract void assertSpecialCondition(boolean isNight);

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getDisplayPrice() {
        return displayPrice;
    }

    public int getValidDays() {
        return validDays;
    }

    // #1on1: いいね、互換性のキープもしっかりできてる (2026/10/22)
    // 元々の alreadyIn の解釈と一致している。(元コードの変数のコメントに書いてあった)
    public boolean isAlreadyIn() {
        return usedDays >= validDays; // 規定の日数を使い切っていたら true
    }

    public boolean isTwoDay() {
        return validDays == 2;
    }
}
