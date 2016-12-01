/** CategorisedHelpDesk consist of one PrinterSpecialist and one GeneralSpecialist
 * When one of them is talking to the customer, the other is waiting */

import java.util.ArrayDeque;
import java.util.Queue;

public class CategorisedHelpDesk
{
    private Queue<Enquiry> enquiries = new ArrayDeque<>();

    private boolean enquire(Customer customer, Category category ) {
        return enquiries.offer(new Enquiry(customer, category));
    }

    private void realisePrinterEnquiry() { //looks for next enquiry and if it is a printer enq. it realises, else leaves for others
        Enquiry enquiry = enquiries.peek();
        if(enquiry != null && (enquiry.getCategory() == Category.PRINTER)){ //assigns element to 'enquiry' if queue is not empty
            enquiries.remove();
            enquiry.getCustomer().reply("Have U  checked paper?");
        }
        else System.out.println("Printer is waiting");
    }

    private void realiseGeneralEnquiry() {
        Enquiry enquiry = enquiries.peek();
        if(enquiry != null && (enquiry.getCategory() != Category.PRINTER)){ //assigns element to 'enquiry' if queue is not empty
            enquiries.remove();
            enquiry.getCustomer().reply("Have U  tried turning it off and on again?");
        }
        else System.out.println("General is waiting");
    }

    public static void main(String[] args) {

        CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.realisePrinterEnquiry();
        helpDesk.realiseGeneralEnquiry();
        helpDesk.realisePrinterEnquiry();
    }
}
