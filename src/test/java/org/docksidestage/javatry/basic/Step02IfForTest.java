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

import java.util.ArrayList;
import java.util.List;

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of if-for. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author your_name_here
 */
public class Step02IfForTest extends PlainTestCase {

    // ===================================================================================
    //                                                                        if Statement
    //                                                                        ============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_if_basic() { // example, so begin from the next method
        int sea = 904;
        if (sea >= 904) {
            sea = 2001;
        }
        log(sea); // your answer? => 2001
    }

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_else_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else {
            sea = 7;
        }
        log(sea); // your answer? => 7
    }
    // シンプルなif文、904以上は2001, それ以外は7なので7
    // javaも比較演算子等も他言語（cなど）と基本的一緒？

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_basic() {
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
        } else if (sea >= 904) {
            sea = 7;
        } else if (sea >= 903) {
            sea = 8;
        } else {
            sea = 9;
        }
        log(sea); // your answer? => 7
    }
    // if文はelse ifで繋がっていれば比較演算子の評価がtrueになった時点でif文から抜けるため、7
    // したのにまで適応させたいならif文を分けてあげる必要あるはず

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_if_elseif_nested() {
        boolean land = false;
        int sea = 904;
        if (sea > 904) {
            sea = 2001;
            sea = sea++ * 2;
        } else if (land && sea >= 904) {
            sea = 7;
            sea = ++sea * 2;
        } else if (sea >= 903 || land) {
            if (sea % 2 == 0) {
                sea = sea++ * 2;
            }
            if (!land) {
                land = true; // ここか!?ここ通ればseaは10、おしまい、ってできる
            } else if (sea <= 903) {
                sea++;
            }
            if (sea < 1810) {
                sea = 8;
            }
        } else if (sea == 8) {
            sea++;
            land = false;
        } else {
            sea = 9;
        }
        if (sea >= 9 || (sea > 7 && sea < 9)) {
            sea--;
            if (sea % 2 == 1) {
                sea++;
            }
        }
        if (land) {
            sea = 10;
        }
        log(sea); // your answer? => 10
    }
    // 最初はsea=904, land=falseだから　sea >= 903 || land　の条件式に入り、偶数だからsea=1808.
    // その後のif文でland = trueに変わり、次のif文でsea = 8になる. 上位ネストのelse文は無視で(sea >= 9 || (sea > 7 && sea < 9)の条件式でsea=8だから入るが、引いて足しているので8のまま
    // 最後にlandがtrueだからsea=10
    // というかlandだけおっとけばlandがtrueか否かでsea=10になるか判定できた...
    // #1on1: ↑ご自身でそれを体感できたというのは良いことです (2026/08/20)
    // トレーニングとしては、上から読んで目のトレーニングになったので全然無駄がないのでOKです。
    //
    // いままた読むとしたら？
    // $後ろから読む、深さを意識して読む
    // o 漠然読みで構造把握 (全体像を見る) // この場合だと5つのレイヤーがある
    // o 当たり(ギャンブルポイント)を付けて、フォーカス読み＆逆さ読み
    //
    // もちろん時にはギャンブルに負けることもある。それでも損はない。
    // ある程度構造把握していて、ある程度中も見ているので、改めて網羅読みするときも速くなってるはず。
    // (地図が頭の中にできてることで、網羅読みのときも道に間違いにくい)
    //
    // あと、一つギャンブルに負けても、少し読み進めたことで、また次のギャンブルポイントが見つけることも。
    // それでもっかいフォーカス読みをすれば良い。3,4回繰り返しても、網羅読みをするよりも速い(ことも多い)。
    // 
    // 仮説思考的なソースコードリーディングとも言える。

    // ===================================================================================
    //                                                                       for Statement
    //                                                                       =============
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_inti_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (int i = 0; i < stageList.size(); i++) {
            String stage = stageList.get(i);
            if (i == 1) {
                sea = stage;
            }
        }
        log(sea); // your answer? => dockside
    }
    // stageList.size() = 4で、1番目の要素を表示
    // pythonだとenumerateで取り出しやすいがjcだとこんな感じの書き方になるよな
    // javaでもenumerateのようなインデックスと要素どちらも取り出せるものないかな
    // listIteratorというのがあるらしい...
    // 関数型インタフェースで定義してあげるのが一般？AtomicIntegerなるものもあるのか、ここら辺よくわかってない...

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_basic() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            sea = stage;
        }
        log(sea); // your answer? => magiclamp
    }
    // これで要素に対するfor文回せるんだ
    // for文でループごとにリストの要素がseaに書き換えられ、最後のmagiclampが出力される認識であっているはず

    // #1on1: Javaのfor文 (2026/08/20)
    // intあいのfor文: 伝統的なC言語から伝わるindex使ったループ
    // 拡張for文: Java10歳くらいのときに登場、次の方どうぞ方式ループ (普通のfor文!?)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_foreach_continueBreak() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // your answer? => hangar
    }
    // startsWithは文字列の最初に与えたプレフィックスから始まるかを判断するもの、containsは含まれているか判断するものだったはず。
    // hangarでbreakになる

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_for_listforeach_basic() {
        List<String> stageList = prepareStageList();
        StringBuilder sb = new StringBuilder();
        stageList.forEach(stage -> {
            if (sb.length() > 0) {
                return;
            }
            if (stage.contains("i")) {
                sb.append(stage);
            }
        });
        String sea = sb.toString();
        log(sea); // your answer? => dockside
    }
    // iが含まれているのはdockside、その時点でreturnに入る
    // forEachは内部でラムダ式を利用するイメージであっている？
    // 中みたら、テンプレート型でacceptに渡されるようになっていた
    // acceptって、コンシューマと言われるやつ？ラムダ式の実態というイメージで良いのか？
    // #1on1: ラムダ式の実体というイメージでほぼOKです。どちらかというと「ラムダ式==実体」 (2026/08/20)
    // 「ラムダ式で、Consumerインターフェースの実装クラスを表現した」って感覚。
    // step8でじっくりやる予定なので、今はこのくらいで大丈夫です。
    // #1on1: forEach()メソッドは、単なるメソッド。Java文法という感じじゃない (2026/08/20)
    // メソッド処理を引数で渡して、呼び返してもらっているだけ。たまたまループ。
    // Java20歳くらいのときに登場したループの方式。
    //
    // o いんとあいのfor文   // 当初から
    // o 拡張for文          // 10年目くらいから
    // o forEach()メソッド  // 20年目くらい
    //
    // forEach()メソッドの良いところは？
    // TODO jflute ↑は、foreach書き換えエクササイズをやってもらってから考える (2026/08/20)

    // #1on1: ビジネスサイドと開発サイドの意思疎通のお話 (2026/08/20)
    // システマチックで解決するか？人間的距離感で解決するか？ハイブリッドか？

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Make list containing "a" from list of prepareStageList() and show it as log by loop. (without Stream API) <br>
     * (prepareStageList()のリストから "a" が含まれているものだけのリストを作成して、それをループで回してログに表示しましょう。(Stream APIなしで))
     */
    public void test_iffor_making() {
        // write if-for here
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Change foreach statement to List's forEach() (keep result after fix) <br>
     * (foreach文をforEach()メソッドへの置き換えてみましょう (修正前と修正後で実行結果が同じになるように))
     */
    public void test_iffor_refactor_foreach_to_forEach() {
        List<String> stageList = prepareStageList();
        String sea = null;
        for (String stage : stageList) {
            if (stage.startsWith("br")) {
                continue;
            }
            sea = stage;
            if (stage.contains("ga")) {
                break;
            }
        }
        log(sea); // should be same as before-fix
    }

    /**
     * Make your original exercise as question style about if-for statement. <br>
     * (if文for文についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_iffor_yourExercise() {
        // write your code here
    }

    // ===================================================================================
    //                                                                        Small Helper
    //                                                                        ============
    private List<String> prepareStageList() {
        List<String> stageList = new ArrayList<>();
        stageList.add("broadway");
        stageList.add("dockside");
        stageList.add("hangar");
        stageList.add("magiclamp");
        return stageList;
    }
}
