package com.naveed.bdd.common;

import com.naveed.bdd.page_objects.Homepage;
import com.naveed.bdd.page_objects.Loginpage;
import com.naveed.bdd.page_objects.SubscriptionPage;

/**
 * Created by nriay on 03/08/2015.
 */
public class LoadPage {

    private Homepage homepage;
    private Loginpage loginpage;
    private SubscriptionPage subscriptionPage;

    public LoadPage(){

    }

    public Homepage getHomepage(){
        if ( homepage == null ){
            homepage = new Homepage();
        }
        return homepage;
    }
//
    public Loginpage getLoginpage(){
        if( loginpage == null){
            loginpage = new Loginpage();
        }
        return loginpage;
    }

    public SubscriptionPage getSubscriptionPage(){
        if( subscriptionPage == null){
            subscriptionPage = new SubscriptionPage();
        }
        return subscriptionPage;
    }
}
