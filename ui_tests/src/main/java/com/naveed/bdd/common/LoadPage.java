package com.naveed.bdd.common;

import com.naveed.bdd.page_objects.EbayHomepage;
import com.naveed.bdd.page_objects.EbayLoginpage;
import com.naveed.bdd.page_objects.SubscriptionPage;

/**
 * Created by nriay on 03/08/2015.
 */
public class LoadPage {

    private EbayHomepage ebayHomepage;
    private EbayLoginpage ebayLoginpage;
    private SubscriptionPage subscriptionPage;

    public LoadPage(){

    }

    public EbayHomepage getEbayHomepage(){
        if ( ebayHomepage == null ){
            ebayHomepage = new EbayHomepage();
        }
        return ebayHomepage;
    }
//
    public EbayLoginpage getEbayLoginpage(){
        if( ebayLoginpage == null){
            ebayLoginpage = new EbayLoginpage();
        }
        return ebayLoginpage;
    }

    public SubscriptionPage getSubscriptionPage(){
        if( subscriptionPage == null){
            subscriptionPage = new SubscriptionPage();
        }
        return subscriptionPage;
    }
}
