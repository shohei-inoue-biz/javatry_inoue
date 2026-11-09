package org.docksidestage.bizfw.basic.buyticket;

/**
 * The ticket available only at night.
 * @author shohei-inoue-biz
 */
public class NightOnlyTicket extends Ticket {

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public NightOnlyTicket(int displayPrice, int validDays) {
        super(displayPrice, validDays);
    }

    // ===================================================================================
    //                                                                           Condition
    //                                                                           =========
    @Override
    protected void assertSpecialCondition(boolean isNight) {
        if (!isNight) {
            throw new IllegalStateException("Cannot in-park at daytime by night-only ticket: displayedPrice=" + getDisplayPrice());
        }
    }
}
