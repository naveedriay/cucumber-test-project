package com.naveed.bdd.page_elements;

/**
 * Created by nriay on 03/08/2015.
 */
public interface SubscriptionElements {

    String accountTypePanel = "#UpdatePanel1";
    String cash_on_counter = "[for=\"radProduct_0\"]";
    String pardes_card = "[for=\"radProduct_1\"]";
    String bank_account="[for=\"radProduct_2\"]";
    String by_cheque = "[for=\"radProduct_3\"]";
    String account_btn_next = "#btnAdd";

    String beneficiary_panel = "#rblistBen";
    String new_beneficiary = "[for=\"rblistBen_0\"]";
    String existing_beneficiary="[for=\"rblistBen_1\"]";
    String beneficiary_btn_next = "#btnList";

    String subscription_section_header = "#header";
    String selected_product_type = ".S1Title";
    String all_beneficiary_list = "#grdBeneficiary";


    String btn_logout = "#lnkbtnlogout";



}
