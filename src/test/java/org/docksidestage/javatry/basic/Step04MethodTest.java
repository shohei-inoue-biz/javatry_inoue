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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of method. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step04MethodTest extends PlainTestCase {

    // ===================================================================================
    //                                                                         Method Call
    //                                                                         ===========
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_method_call_basic() {
        String sea = supplySomething();
        log(sea); // your answer? => over
    }
    // String型の戻り値だからそのまま帰ってくるはず

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_call_many() {
        String sea = functionSomething("mystic");
        consumeSomething(supplySomething());
        runnableSomething();
        log(sea); // your answer? => mysmys
    }
    // この関数のスコープで定義しているseaは最初だけなので、最初の置換だけ見れば良い
    // .replaceの中身のmatcherの仕組みがいまいちわからなかった...
    // #1on1: 正規表現のコアなところは読むのは大変でしょう (2026/09/25)
    // リテラル置換でも正規表現でも同じくPattern/Matcherを使っているところが面白い。

    // synchronizedは排他制御
    // #1on1: Matcher()の synchronized(this) { compile()をスレッドセーフにしている (2026/09/25)
    // StringBuffer 発見
    // Matcher appendReplacement(StringBuffer sb, String replacement)
    // 1.4の時代のクラスなのでStringBuilderさんがいなかった。

    private String functionSomething(String name) {
        String replaced = name.replace("tic", "mys");
        log("in function: {}", replaced);
        return replaced;
    }

    private String supplySomething() {
        String sea = "over";
        log("in supply: {}", sea);
        return sea;
    }

    private void consumeSomething(String sea) {
        log("in consume: {}", sea.replace("over", "mystic"));
    }

    private void runnableSomething() {
        String sea = "outofshadow";
        log("in runnable: {}", sea);
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_object() {
        St4MutableStage mutable = new St4MutableStage();
        int sea = 904;
        boolean land = false;
        helloMutable(sea - 4, land, mutable);
        if (!land) {
            sea = sea + mutable.getStageName().length();
        }
        log(sea); // your answer? => 910
    }
    // 最後に求められているのはsea, helloMutableでseaは直接変更されないので、mysticがmutableのstageNameとして入ることだけ捉えておく。
    // landはfalseなので！landでif文内に入る
    // sea(904) + mystic(6)で910

    private int helloMutable(int sea, Boolean land, St4MutableStage piari) {
        sea++;
        land = true;
        piari.setStageName("mystic");
        return sea;
    }

    private static class St4MutableStage {

        private String stageName;

        public String getStageName() {
            return stageName;
        }

        public void setStageName(String stageName) {
            this.stageName = stageName;
        }
    }

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private int inParkCount;
    private boolean hasAnnualPassport;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_method_instanceVariable() {
        hasAnnualPassport = true;
        int sea = inParkCount;
        offAnnualPassport(hasAnnualPassport);
        for (int i = 0; i < 100; i++) {
            goToPark();
        }
        ++sea;
        sea = inParkCount;
        log(sea); // your answer? => 100
    }
    // inParkCountはクラス内のプライベートメソッドで初期値は0(intだから)
    // hasAnnualPassportは最初にtrueにされている（offAnnualPassportは引数をfalseにするだけなので無関係）
    // for分内でinParkCountが100回インクリメントされる
    // seaにinParkCountを代入されるため100（++seaとinParkCountは別なので無視）

    private void offAnnualPassport(boolean hasAnnualPassport) {
        hasAnnualPassport = false;
    }

    private void goToPark() {
        if (hasAnnualPassport) {
            ++inParkCount;
        }
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    // write instance variables here
    /**
     * Make private methods as followings, and comment out caller program in test method:
     * <pre>
     * o replaceAwithB(): has one argument as String, returns argument replaced "A" with "B" as String 
     * o replaceCwithB(): has one argument as String, returns argument replaced "C" with "B" as String 
     * o quote(): has two arguments as String, returns first argument quoted by second argument (quotation) 
     * o isAvailableLogging(): no argument, returns private instance variable "availableLogging" initialized as true (also make it separately)  
     * o showSea(): has one argument as String argument, no return, show argument by log()
     * </pre>
     * (privateメソッドを以下のように定義して、テストメソッド内の呼び出しプログラムをコメントアウトしましょう):
     * <pre>
     * o replaceAwithB(): 一つのString引数、引数の "A" を "B" に置き換えたStringを戻す 
     * o replaceCwithB(): 一つのString引数、引数の "C" を "B" に置き換えたStringを戻す 
     * o quote(): 二つのString引数、第一引数を第二引数(引用符)で囲ったものを戻す 
     * o isAvailableLogging(): 引数なし、privateのインスタンス変数 "availableLogging" (初期値:true) を戻す (それも別途作る)  
     * o showSea(): 一つのString引数、戻り値なし、引数をlog()で表示する
     * </pre>
     */
    public void test_method_making() {
        // use after making these methods
        String replaced = replaceCwithB(replaceAwithB("ABC"));
        String sea = quote(replaced, "'");
        if (isAvailableLogging()) {
            showSea(sea); // answer -> BBB
        }
    }

    // write methods here
    private boolean availableLogging = true;

    // #1on1: いいね、メソッド定義位置が呼び出し順序と一致していて直感的で把握しやすい (2026/09/25)
    // $ぼくはけっこう厳しい、配置。
    // 呼び出し順序 + まとまり
    // まとまりの存在感がどのくらいか？
    // 呼び出し順序 + まとまりのハイブリッドで、メソッド間の階層構造を意識して並べている。
    // (LastaFlute の ActionRequestProcessor の例)
    //
    // 既存コードにメソッド追加、(しかるべき場所があるはずなのに)一番下に追加されやすい問題。
    // おじゃまします感。
    // 20人が通過して最終的にごちゃごちゃするケース。
    // 既存コードの「コード体裁デザイン」に注目して修正して欲しい。
    // 既存コードの「コード体裁デザイン」に責任を持つのは今修正しようとしている人。
    //
    private String replaceAwithB(String str) {
        return str.replace("A", "B");
    }

    private String replaceCwithB(String str) {
        return str.replace("C", "B");
    }

    // #1on1: いいね、第二引数、わかりやすい (2026/09/25)
    // 引数名大事。引数名はインターフェースなので、呼び出し側に対するドキュメント。
    private String quote(String str, String quotation) {
        return quotation + str + quotation;
    }

    private boolean isAvailableLogging() {
        return availableLogging;
    }

    private void showSea(String str) {
        log(str);
    }
    // こういうことであっている？
    // #1on1: あってる (2026/09/25)
}
