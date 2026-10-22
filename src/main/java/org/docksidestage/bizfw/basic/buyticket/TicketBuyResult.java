package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author shohei-inoue-biz
 */
public class TicketBuyResult {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final Ticket ticket;
    private final int change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(Ticket ticket, int change) {
        // #1on1: あえて別の方の、指摘されパターンの共有 (2026/10/22)
        // Constructorでロジックを入れるパターン。
        // ResultなのかResultCreatorなのかの違い。
        // ticket,changeなのかchange,ticketなのかのパターン。
        this.ticket = ticket;
        this.change = change;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return ticket;
    }

    public int getChange() {
        return change;
    }
}
