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

import org.docksidestage.unit.PlainTestCase;

/**
 * The test of variable. <br>
 * Operate exercise as javadoc. If it's question style, write your answer before test execution. <br>
 * (javadocの通りにエクササイズを実施。質問形式の場合はテストを実行する前に考えて答えを書いてみましょう)
 * @author jflute
 * @author shohei-inoue-biz
 */
public class Step01VariableTest extends PlainTestCase {

    // ===================================================================================
    //                                                                      Local Variable
    //                                                                      ==============
    /**
     * What string is sea variable at the method end? <br>
     * (メソッド終了時の変数 sea の中身は？)
     */
    public void test_variable_basic() { // example, so begin from the next method
        String sea = "mystic";
        log("xxxxは{}である", sea); // your answer? => mystic
    }
    /*
      まずJavaの文法は？
      →クラス, メソッドの書き方
      ${modifier} class ${class_name} {
          ${modifier} ${data_type} ${method_name}( ${argument} ) {
              ...
          }
          ...
      }
      これが基本形
      extends → 親クラスの継承　→ Javaもオブジェクト指向型　→ オーバーライドするメソッドには@Override（アノテーション）つけるのが推奨
    
      log() -> 引数オブジェクト型なんだ（しかも可変長引数）-> 可変長引数...で表す→object型だから可変長できる→Stringの方が良くね？→objectならobjectであればなんでも渡せるんか
     */
    // done inoue [いいね] まずしっかり文法からインプット、素晴らしいです by jflute (2026/07/16)
    // log()メソッドの定義まで追求もGoodです。最終的にはすべてStringにされるわけですが...
    // Integer の値もそのまま引数指定できるようにということで、わりとざっくりなスタイルで実装されています。
    // e.g. 
    //  Integer sea = ...
    //  x log(sea.toString());
    //  o log(sea);
    // UnitTest専用のメソッドだから「ざっくり寄り」というのもあります。
    // #1on1: せっかくなのでSlf4jのコード読んでみた (2026/07/21)
    // e.g. 
    //  public void debug(String format, Object... arguments);

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_initial() {
        String sea = "mystic";
        Integer land = 8;
        String piari = null;
        String dstore = "mai";
        sea = sea + land + piari + ":" + dstore;

        log(sea); // your answer? => mystic8null:mai
    }
    /*
        IntegerとIntどちらがいい？→intが整数型（プリミティブ型）でIntegerはオブジェクトとして扱われるラッパークラス（参照型）
        使い分けは？→通常計算や演算、ループカウント、インデックス、あたいが絶対に存在する時がInt、コレクションやDB,WEBフォーム等はInteger → Web開発は基本Integer
        →Integerであるため、オブジェクトとして扱えるからnull許容もできる→だから文字列に足しても許容?　→intでもいける　→　文字列からの代入は？ -> どちらも無理
     */
    /*
     public void test_variable_initial_exp() {
            String sea = "mystic";
            Integer land = 8;
            int land_int = 8;
           land = Integer.valueOf(land + sea);
            land_int = Integer.parseInt(land_int + sea);
    
            log(land);
            log(land_int);
        }
        error -> java.lang.NumberFormatException: For input string: "8mystic" -> そりゃあ解釈できないか
     */
    // done inoue [いいね] 実験Goodです。 by jflute (2026/07/16)
    // #1on1: ちゃちゃっと実験する環境を整えておくってのも大事 (2026/07/21)
    // TODO inoue [読み物課題] よければ、以下のページを参考に by jflute (2026/07/16)
    // // Java Beginner's Hint - プリミティブ型とラッパー型 | DBFlute
    // https://dbflute.seasar.org/ja/manual/topic/programming/java/beginners.html#primitivewrapper

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_basic() {
        String sea = "mystic";
        String land = "oneman";
        sea = land;
        land = land + "'s dreams";
        log(sea); // your answer? => oneman
    }
    /*
    値渡しだからlandを代入後に変更しても変わらない→Javaにもポインタってある？→ポインタはないが参照がある→ new ${variable_name}でオブジェクトのインスタンスを作ったときに参照が格納される
    コンストラクタみたいなイメージでいいんかな
     */
    // TODO inoue [ふぉろー] Javaにはポインタ参照はあるけどポインタ操作(演算など)はできないとよく聞きます by jflute (2026/07/16)
    // オブジェクト型の変数に入っているのはあくまでアドレスです。どこかのメモリ上のインスタンスを指し示しています。
    //
    // sea = land; の行で、seaもlandも同じアドレスを一瞬持ちます。
    // land = land + "'s dreams"; の行で、land は新しく生成された String インスタンスのアドレスに差し変わります。
    // (land + "'s dreams" の部分は、元々landが指し示すStringと 's dreams を足した新しいStringインスタンスを作っています)
    // seaのアドレスも、seaが指し示しているインスタンスも、特に何か変更が加えられていないのでそのままってことですね。
    //
    // 新しいインスタンスが生成されるときは、そのクラスのコンストラクタが実行されます。
    // Stringだけ特別で、new String(...) って書かなくても、"mystic" って書くだけで、
    // new String("mystic") されているのと同じになるように特別扱いされています。
    // land + "'s dreams" も、内部的には new String("oneman's dreams") で実行されています。

    // #1on1: いのうえさんのコンストラクタのイメージは、C++, Python (2026/07/21)
    // Stringのコンストラクタのコードも一緒に読んでみた。
    // 変数とインスタンスのお話も。インスタンスとは？ (実体というか... by いのうえさん)
    // 車のたとえ by いのうえさん
    // 一軒家のたとめ by くぼ
    // BigDecimalのエクササイズでもインスタンスのお話しした

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_int() {
        int sea = 94;
        int land = 415;
        sea = land;
        land++;
        log(sea); // your answer? => 415
    }
    /*
    今んとこはプリミティブ型扱っているから変化なし
    インクリメントがあるってことは省略型の演算子は基本使えるはず　-> 基本的にはCと一緒、三項演算子も使える
     */
    // done inoue [よもやま] Javaが作られた1995年あたりはC言語は超メジャー言語でしたので... by jflute (2026/07/16)
    // JavaもC言語をだいぶ意識して設計されている印象ですね。(C言語プログラマーがスムーズにJavaに移行できるようにって)

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_reassigned_BigDecimal() {
        BigDecimal sea = new BigDecimal(94);
        BigDecimal land = new BigDecimal(415);
        sea = land;
        log(sea); //415
        sea = land.add(new BigDecimal(1));
        log(sea); // 416
        log(land); //415
        sea.add(new BigDecimal(1));

        log(sea); // your answer? => 417 => 416
        log(land);// 415
    }
    /*
    BigDecimal()とは？→誤差の出ない正確な十進数計算を行うためのAPI -> ん？なぜInt?->整数型なら問題ないらしい→正確な値として保持しているから
    .add()->加算 -> 計算はされるが結果は代入されない -> メソッド見たらリターンされているだけだった
    private final transient long intCompact;　→ transientは変数をシリアライズの対象から外す, intCompact -> long型に収まる場合に高速に計算するための変数
    両方の変数を保持するとデータ量が無駄になる→確かに
    */
    // done jflute ここは1on1でじっくりお話ししますね(^^ (2026/07/16)
    // ↑このとぅどぅは、くぼ用の備忘録なのでそのまま残しておいてOKです
    // #1on1: BigDecimalのimmutableぶりをコード追ってみた (2026/07/21)
    // pythonでimmutable/mutableよく出てきた by いのうえさん
    //
    // immutableメリデメ:
    // o メリット: 変わらないと嬉しいこと、変わっちゃいけないところで使える、可読性、安全性
    //   → 可読性の説明しっかりと
    // o デメリット: add()のたびにインスタンスを生成するのでメモリを少し使う(些細だけど)
    //
    // mutableメリデメ:
    // o メリット: 変えなきゃいけない場面で変えられること、計算の場面とかだと素直かも、メモリを節約できる
    // o デメリット: immutableのメリットの逆
    //
    // immutableの歴史のお話。
    // 徹底する言語、8:2な言語

    // ===================================================================================
    //                                                                   Instance Variable
    //                                                                   =================
    private String instanceBroadway;
    private int instanceDockside;
    private Integer instanceHangar;
    private String instanceMagiclamp;

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_String() {
        String sea = instanceBroadway;
        log(sea); // your answer? => null
    }
    /*
    instanceBroadway初期化していないはずだからnull -> 正しい　-> Javaは絶対に初期化しなくて良い？　→ ローカル変数ではダメ、グローバルなら可？
    → グローバル変数というものはJavaにはない。　クラス変数やインスタン変数なら可能 → 規定の初期値が入る　→ 今回はインスタンス変数に当たる
     */
    // TODO inoue 文法的にはグローバル変数はなく、何かしらに所属する変数ということにはなります by jflute (2026/07/16)
    // ただ、クラス変数(static変数) で public だったら、実質的というか概念的なグローバル変数も作れますが。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_int() {
        int sea = instanceDockside;
        log(sea); // your answer? => 0
    }
    /*
    そういえばprivate修飾子ってpythonと一緒？→一緒そう→クラス内なら呼び出せる
    protectedとprivateの違い→protectedはサブクラスと同一パッケージでも呼び出し可能、privateはクラス内のみ
     */
    // TODO inoue Javaのprotectedはちょっとへんてこりんで、パッケージスコープも混ざってます by jflute (2026/07/16)
    // ただ、紛らわしいので、protectedのパッケージスコープ特徴はあまり使わず、継承スコープのみでprotectedを意識することが多いです。

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_default_Integer() {
        Integer sea = instanceHangar;
        log(sea); // your answer? => 0.0 -> null
    }
    /*
    IntegerはIntの参照型→メモリ上のオブジェクトのアドレスを示す→アドレスがない場合はnull
     */

    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_instance_variable_via_method() {
        instanceBroadway = "bbb";
        instanceMagiclamp = "magician";
        helpInstanceVariableViaMethod(instanceMagiclamp);
        String sea = instanceBroadway + "|" + instanceDockside + "|" + instanceHangar + "|" + instanceMagiclamp;
        log(sea); // your answer? => 
    }
    // TODO inoue ここは飛ばしてる？ by jflute (2026/07/16)

    private void helpInstanceVariableViaMethod(String instanceMagiclamp) {
        instanceBroadway = "bigband";
        ++instanceDockside;
        instanceMagiclamp = "burn";
    }

    // ===================================================================================
    //                                                                     Method Argument
    //                                                                     ===============
    // -----------------------------------------------------
    //                                 Immutable Method-call
    //                                 ---------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_immutable_methodcall() {
        String sea = "harbor";
        int land = 415;
        helpMethodArgumentImmutableMethodcall(sea, land);
        log(sea); // your answer? => harbor416 -> harbor
    }

    private void helpMethodArgumentImmutableMethodcall(String sea, int land) {
        ++land;
        String landStr = String.valueOf(land); // is "416"
        sea.concat(landStr);
    }
    /*
    landをインクリメントしている→landの値は正しい→.concat(landStr)が問題→concatは文字列の結合では？→結合しているけど代入しているわけではないからか
     */
    // done inoue [ふぉろー] yes, BigDecimalのadd()みたいに、自分自身のインスタンスの状態を変えるわけではないので... by jflute (2026/07/16)
    // concat()は、harbor416 という新しいStringインスタンスを作っただけに過ぎません。
    // でもって、それを受けってすらなく、すぐさま破棄しているので、test_...()側には何も作用しないと言うことですね。
    // Stringの特徴をわかっていれば、実はこのエクササイズ、help...()のコードを読まなくても答えを断定できます。

    // -----------------------------------------------------
    //                                   Mutable Method-call
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_mutable_methodcall() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentMethodcall(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentMethodcall(StringBuilder sea, int land) {
        ++land;
        sea.append(land);
    }

    // -----------------------------------------------------
    //                                   Variable Assignment
    //                                   -------------------
    /** Same as the previous method question. (前のメソッドの質問と同じ) */
    public void test_variable_method_argument_variable_assignment() {
        StringBuilder sea = new StringBuilder("harbor");
        int land = 415;
        helpMethodArgumentVariable(sea, land);
        log(sea); // your answer? => 
    }

    private void helpMethodArgumentVariable(StringBuilder sea, int land) {
        ++land;
        String seaStr = sea.toString(); // is "harbor"
        sea = new StringBuilder(seaStr).append(land);
    }

    // ===================================================================================
    //                                                                           Challenge
    //                                                                           =========
    /**
     * Define variables as followings:
     * <pre>
     * o local variable named sea typed String, initial value is "mystic"
     * o local variable named land typed Integer, initial value is null
     * o instance variable named piari typed int, without initial value
     * o show all variables by log() as comma-separated
     * </pre>
     * (変数を以下のように定義しましょう):
     * <pre>
     * o ローカル変数、名前はsea, 型はString, 初期値は "mystic"
     * o ローカル変数、名前はland, 型はInteger, 初期値は null
     * o インスタンス変数、名前はpiari, 型はint, 初期値なし
     * o すべての変数をlog()でカンマ区切りの文字列で表示
     * </pre>
     */
    public void test_variable_writing() {
        // define variables here
    }

    // ===================================================================================
    //                                                                           Good Luck
    //                                                                           =========
    /**
     * Make your original exercise as question style about variable. <br>
     * (変数についてあなたのオリジナルの質問形式のエクササイズを作ってみましょう)
     * <pre>
     * _/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/
     * your question here (ここにあなたの質問を):
     * 
     * _/_/_/_/_/_/_/_/_/_/
     * </pre>
     */
    public void test_variable_yourExercise() {
        // write your code here
    }
}
