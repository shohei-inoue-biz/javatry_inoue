package org.docksidestage.bizfw.basic.buyticket;

/**
 * The ticket available all day (both daytime and night).
 * @author shohei-inoue-biz
 */
public class AllDayTicket extends Ticket {
    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public AllDayTicket(int displayPrice, int validDays) {
        super(displayPrice, validDays);
    }

    // ===================================================================================
    //                                                                           Condition
    //                                                                           =========
    @Override
    protected void assertSpecialCondition(boolean isNight) {
        // #1on1: いいね、実装がないことを明示的に表現するコメントあると助かる。 (2026/11/10)
        // $Python だと pass って書く。Javaだとなさそうなのでコメント。
        // all-day ticket has no time restrictions
    }
}
