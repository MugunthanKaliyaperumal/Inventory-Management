package inventorymanagement;

import javax.swing.JPanel;

public class Customer extends JPanel{
    JPanel jp_customer_title = new CustomerTitle(this);    
    JPanel jp_customer_options = new Customeroptions();
    JPanel jp_display_panel = new CustomerDisplay();
    JPanel jp_profile_panel ;
    JPanel jp_invoice_panel = new CustomerInvoice();
    static CustomerViewCart jp_viewcart_panel = new CustomerViewCart();
    public Customer(String username){
        jp_profile_panel = new CustomerProfile(username);
        Customeroptions.getprofile_panel(jp_profile_panel);
        Customeroptions.getdisplay_panel(jp_display_panel);
        Customeroptions.getinvoice_panel(jp_invoice_panel);
        Customeroptions.getview_panel(jp_viewcart_panel.cartview);
        Customeroptions.getcustomer_main(this);
        CustomerDisplay.getview_panel(jp_viewcart_panel.cartview);
        CustomerDisplay.getcustomer_main(this);
        setLayout(null);
        setSize(840,600);
        add(jp_customer_title);
        add(jp_customer_options);
        add(jp_display_panel);
    }
}