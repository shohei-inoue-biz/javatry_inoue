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
package org.docksidestage.javatry.basic;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of data type. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step03DataTypeTest extends PlainTestCase {

    // ===================================================================================
    //                                                                          Basic Type
    //                                                                          ==========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_datatype_basicType() {
        String sea = "mystic";
        Integer land = 416;
        LocalDate piari = LocalDate.of(2001, 9, 4);
        LocalDateTime bonvo = LocalDateTime.of(2001, 9, 4, 12, 34, 56);
        Boolean dstore = true;
        BigDecimal amba = new BigDecimal("9.4");

        piari = piari.plusDays(1);
        land = piari.getYear();
        bonvo = bonvo.plusMonths(1);
        land = bonvo.getMonthValue();
        land--;
        if (dstore) {
            BigDecimal addedDecimal = amba.add(new BigDecimal(land));
            sea = String.valueOf(addedDecimal);
        }
        log(sea); // your answer? => 18.4
    }
    // dstoreはtrueだからif文には入る
    // addedDecicalの値が出力される
    // amba(9.4)にland足した値がaddedDecimal
    // land = -1 + (9 + 1)
    // plathMonthはdate.plathMonthを利用
    // date型って内部ちゃんと計算されているんだ
    // 閏年とかのハンドリングとかってされているのかな？
    // #1on1: されてると思う。少なくとも昔のGregorianCalendarはサポートしてたはず。 (2026/09/01)
    // ちなみに、JapaneseImperialCalendar のコード見てみた。令和がちゃんと追加されていた！

    // ===================================================================================
    //                                                                           Primitive
    //                                                                           =========
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_primitive() {
        byte sea = 127; // max
        short land = 32767; // max
        int piari = 1;
        long bonvo = 9223372036854775807L; // max
        float dstore = 1.1f;
        double amba = 2.3d;
        char miraco = 'a';
        boolean dohotel = miraco == 'a';
        if (dohotel && dstore >= piari) {
            bonvo = sea;
            land = (short) bonvo;
            bonvo = piari;
            sea = (byte) land;
            if (amba == 2.3D) {
                sea = (byte) amba;
            }
        }
        if ((int) dstore > piari) {
            sea = 0;
        }
        log(sea); // your answer? => 2
    }
    // キャストしているからif文のdstoreは１なので入らない
    // dohotelは常にtrueだから一つ目のif文は入る
    // キャストされているからlandは元のまま
    //　同様にseaもlandがbyteでキャストされるから127
    // 最後に、amdaが入るから2

    // #1on1: $ロボットではキャストめっちゃ使ってた (2026/09/01)
    // 組み込み型では必要になることではあると思う。
    // 書かざるを得ない時はしょうがない。まあ可読性のためにコメントとかで補足しておくかな。
    //
    // 雑談:
    // $座標変換とかもやってた
    // 世の中のITの技術話、どうしても業務システム、webサービスベースで語られることが多い。

    // ===================================================================================
    //                                                                              Object
    //                                                                              ======
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_datatype_object_basic() {
        String originalStageName = "hangar";
        St3ImmutableStage stage = new St3ImmutableStage(originalStageName);
        String sea = stage.getStageName();
        log(sea); // your answer? => hanger
    }
    // コンストラクタを記述しているだけ
    // pythonと同じような記述
    // class名の関数を定義するとコンストラクタとして働くようなイメージで良いのかな？
    // #1on1: yes (2026/09/01)

    private static class St3ImmutableStage {

        private final String stageName;

        public St3ImmutableStage(String stageName) {
            this.stageName = stageName;
        }

        public String getStageName() {
            return stageName;
        }

        public St3ImmutableStage createWithSuffix(String suffix) {
            return new St3ImmutableStage(stageName + suffix);
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make new method to St3ImmutableStage that appends suffix to stageName keeping immutable concept. <br>
     * (St3ImmutableStage, immutableのコンセプトを維持したまま、stageNameにsuffixを追加するメソッドを追加してみましょう)
     */
    public void test_datatype_object_immutable_method() {
        St3ImmutableStage stage = new St3ImmutableStage("hangar");
        St3ImmutableStage newStage = stage.createWithSuffix("stage");

        log(stage.getStageName());
        log(newStage.getStageName());
    }

    // suffixってことは接頭語を追加するようなメソッドを作れば良いのかな
    // immutableのコンセプトということは書き換えるのではなく、新たにインスタンスを作るイメージ？
}
