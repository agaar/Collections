/** PriorityHelpDesk realises enquiries in turn: PRINTER, CCOMPUTER, PHONE, TABLET */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk
{
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };
    private Queue<Enquiry> enquiries = new PriorityQueue<Enquiry>(BY_CATEGORY);

    private void enquire(Customer customer, Category category ) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void realiseAllEnquiries() {                    //looks at all enquiries from customers and one at a time go
        Enquiry enquiry;
        while((enquiry = enquiries.poll()) != null) {               //assigns element to 'enquiry' if queue is not empty
            enquiry.getCustomer().reply("Have U tried turning it off and on again?");
        }
    }

    public static void main(String[] args) {

        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.realiseAllEnquiries();
    }
}
