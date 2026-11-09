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
        // all-day ticket has no time restrictions
    }
}
